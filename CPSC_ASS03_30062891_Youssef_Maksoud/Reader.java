
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

/**
 *
 * class responsible for reading the input file provided by the user
 */
public class Reader {

    private String fileName; // name of the file
    private String[] words; // array of words to be turned into a tree

    /**
     *
     * constructor creates an array of words of size 5000
     */
    public Reader(){
        words = new String [5000];
    }

    //returns the word array
    public String[] getWords() {
        return words;
    }

    //sets the file name
    public void setFilename(String name){
        fileName = name;
    }

    /**
     *
     * method opens the input file and reads the contents word by word,
     * removing any undesired characters amd stores in an array
     */
    public void makeArray(){
        Scanner in = null;

        // appends the filename to the user directory to read from the file
        userPrompt();
        String line = "";


        //reads the file stroes value as a string
        try {
            in = new Scanner(new FileReader(fileName));
            System.out.println("File opened");

            while(in.hasNext()){
                line = line + in.next().trim() + " ";
            }

        }catch (FileNotFoundException e){
            System.out.println("Error, File not found");
        }finally {
            if(in != null) {
                System.out.println("The contents of the file have been saved");
                words = line.replace("-"," ").replaceAll("[^0-9a-zA-Z ]", "").toLowerCase().split(" ");
                in = null;
            }
        }
    }

    /**
     *
     * prompts user to input a file name
     */
    public void userPrompt(){
        Scanner scan = new Scanner(System.in);
        String readVal = "";

        while(true){

            //prompts user for a textfile
            System.out.println("Please enter the name of the file you would like organized: ");
            readVal = scan.nextLine();
            break;
        }
        scan = null;
        fileName = readVal;

        System.out.println(fileName + " " + "Was saved to the reader:" + "\n");
        System.out.println("Please wait while we organize your data..." + "\n");
    }
}
