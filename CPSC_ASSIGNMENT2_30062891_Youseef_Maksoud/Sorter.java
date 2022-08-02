

public class Sorter {

    public String[] mergeSort(String wordArray[]){

        if(wordArray.length == 1) {
            return wordArray;
        }

        String[] left = new String[wordArray.length/2];
        String right[];

        if(wordArray.length % 2 == 0){
            right = new String[wordArray.length/2];
        }
        else{
            right = new String[(wordArray.length)/2 + 1];
        }
        //if even size creates two equal halves else right side is one larger

        for(int i = 0 ; i < left.length; i ++) {
            left[i] = wordArray[i];
        }

        for(int j = 0; j < right.length; j ++){
            right[j] = wordArray[left.length + j];
        }
        String result[];

        left = mergeSort(left);
        right = mergeSort(right);

        result = merge(left,right);

        return result;
    }

    public String selectionSort(String toBeSorted){
        char toSort[] = toBeSorted.toCharArray();
        char greatest;
        int j = toSort.length - 1;
        int spot = 0;

        while(j > -1){
            greatest = ' ';
            for (int i = 0; i <= j; i++) {
                if (toSort[i] > greatest) {
                    greatest = toSort[i];
                    spot = i;
                }
            }

            toSort[spot] = toSort[j];
            toSort[j] = greatest;
            j--;
        }
        String ret = "";
        for(int l = 0; l < toSort.length; l ++){
            ret += toSort[l];
        }

        return ret;
    }

    public String[] merge(String left[], String right[]){
        String merged[] = new String[left.length + right.length];

        int leftHolder = 0;
        int rightHolder = 0;
        int mergedIndex = 0;

        while(leftHolder < left.length || rightHolder < right.length) {

            if (leftHolder < left.length && rightHolder < right.length) {

                if (left[leftHolder].compareTo(right[rightHolder]) > 0) {
                    merged[mergedIndex] = right[rightHolder];
                    mergedIndex++;
                    rightHolder++;
                }
                else if (left[leftHolder].compareTo(right[rightHolder]) < 0) {
                    merged[mergedIndex] = left[leftHolder];
                    mergedIndex++;
                    leftHolder++;
                }
                else {
                    merged[mergedIndex] = left[leftHolder];
                    merged[mergedIndex + 1] = right[rightHolder];
                    mergedIndex += 2;
                    rightHolder++;
                    leftHolder++;
                }
            }
            else if(leftHolder < left.length){
                merged[mergedIndex] = left[leftHolder];
                mergedIndex++;
                leftHolder++;
            }
            else if(rightHolder < right.length){
                merged[mergedIndex] = right[rightHolder];
                mergedIndex++;
                rightHolder++;
            }
        }
        return merged;
    }

}
