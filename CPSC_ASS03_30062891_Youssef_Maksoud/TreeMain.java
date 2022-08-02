
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * program frontend that contains the static main method
 */
public class TreeMain {

    public static void main(String args[]) throws FileNotFoundException {

        //creates a new reader and main treemain
        TreeMain t = new TreeMain();
        Reader r = new Reader();

        //creates the array
        r.makeArray();

        //stores array into a binary search tree
        BinarySearchTree bst = new BinarySearchTree(r.getWords());
        bst.printTreeDetails();

        //prompts user to select an option from the displayed menu
        t.readMenuInput(bst);

    }

    /**
     *
     * displays the option menu after the tree has been created
     */
    public void menu(){
        System.out.println("\n");
        System.out.println("----------------------------------");
        System.out.println("Please select one of the following options: ");
        System.out.println("1. In-Order Print");
        System.out.println("2. Pre-Order Print");
        System.out.println("3. Post-Order Print");
        System.out.println("4. Search for a word");
        System.out.println("5. Quit");
        System.out.println("----------------------------------");
        System.out.println("\n");



    }

    /**
     *
     * reads the users choice and performs the according action based on the menu
     * @param b is the binary search tree
     */
    public void readMenuInput(BinarySearchTree b){
        Scanner scan = new Scanner(System.in);
        while(true){
            menu();
            int choice = scan.nextInt();
            scan.nextLine();

            switch(choice){

                case 1:
                    b.traverseInOrder(b.getRootNode()); //in order tree print
                    break;
                case 2:
                    b.traversePreOrder(b.getRootNode()); // pre order tree print
                    break;
                case 3:
                    b.traversePostOrder(b.getRootNode()); // post order tree print
                    break;
                case 4:
                    System.out.println("Please enter word you would like to search for:");
                    String word = scan.nextLine();
                    b.search(b.getRootNode(), word); // search for a word in the tree
                    break;
                case 5:
                    System.out.println("Thank you");
                    System.exit(0); // quit
                default:
            }

        }
    }
}
