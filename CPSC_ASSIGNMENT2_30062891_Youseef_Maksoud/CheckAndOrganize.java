


public class CheckAndOrganize {
    public boolean isAnagram(String s1, String s2){
        Sorter s = new Sorter();
        String word1 = s.selectionSort(s1).toUpperCase().trim();
        String word2 = s.selectionSort(s2).toUpperCase().trim();
        boolean b = false;

        if(word1.compareTo(word2) == 0){
            b = true;
        }
        return b;
    }

    public LinkedList[] organizer(String arr[]){
        Sorter sort = new Sorter();
        int i = 0;
        int j = 0;
        int elems = 0;

        LinkedList list[] = new LinkedList[arr.length];

        for(i = 0; i < arr.length; i ++){
            for(j = 0; j < elems + 1; j++){
                if(list[j] == null){
                    list[j] = new LinkedList();
                    list[j].addNode(arr[i]);
                    elems ++;
                    break;
                }
                else if (isAnagram(sort.selectionSort(arr[i]), sort.selectionSort(list[j].getHeadM().getNext().getWord())) == true){
                    list[j].addNode(arr[i]);
                    break;
                }
            }
        }
        return list;
    }

}
