

import java.util.Scanner;

public class SortingProg{

    public static void main(String args[]){

        SortingProg ass2 = new SortingProg();
        Sorter sorter = new Sorter();
        CheckAndOrganize check = new CheckAndOrganize();

        String wordArr[];

        wordArr = sorter.mergeSort(ass2.prompt());

        LinkedList[] sortedWords = check.organizer(wordArr);

        ass2.printOrg(sortedWords);



    }

    public String[] prompt(){

        Scanner scan = new Scanner(System.in);
        String wordArr[] = new String[1];
        int wordCount = 0;

        System.out.println("Please enter a list of words type done when list is finished ");

        while(scan.hasNextLine()) {

            String input = scan.nextLine();

            if (input.compareTo("done") == 0){
                System.out.println("Thank you for your input");
                break;
            }

            if(wordCount == wordArr.length){
                wordArr = sArrEnlarge(wordArr);
            }

            wordArr[wordCount] = input.trim();
            wordCount++;

        }

        return wordArr;
    }

    public String[] sArrEnlarge(String arr[]){
        String newArr[] = new String[(arr.length + 1)];

        for(int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }

        return newArr;
    }

    public void printOrg(LinkedList[] arr){
        for(int i = 0; (i < arr.length) && (arr[i] != null); i ++){
            arr[i].printList();
            System.out.println(" ");
        }
    }
}
