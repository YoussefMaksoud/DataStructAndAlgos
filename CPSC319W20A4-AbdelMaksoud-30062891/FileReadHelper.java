
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class FileReadHelper {

    private int oSize;
    private int nSize;

    public int getnSize() {
        return nSize;
    }

    public int getoSize() {
        return oSize;
    }

    /**
     *
     * reads the file
     * @return returns the adjacency matrix created
     */
    public int[][] readFile(String fileName){

        Matrix[] matArr;
        matArr = createMatArr(fileName);

        return createAdj(matArr);
    }

    /**
     *
     * creates the vertex array
     * @return the vertex array
     */
    public Matrix[] createMatArr(String fileName){

        Scanner in = null;
        Matrix[] matArr = null;
        int index;

        try {

            in = new Scanner(new FileReader(fileName));
            System.out.println("File opened");

            //reads the number of vertices and size of neighborhood
            nSize = in.nextInt();
            nSize = in.nextInt();
            oSize = in.nextInt();

            matArr = new Matrix[oSize];

            int val = 0;

            //populates the vertex array with input neighborhoods
            while(in.hasNext()){
                index = in.nextInt();
                matArr[index] = new Matrix(index, nSize);

                for(int i = 0; i < nSize; i++){

                    for(int j = 0; j < nSize; j++){

                        val = in.nextInt();
                        matArr[index].getBody()[i][j] = val;

                    }
                }
            }

        }catch (FileNotFoundException e){

            System.out.println("Error, File not found");

        }finally {

            if(in != null) {

                System.out.println("The contents of the file have been saved");
                in = null;

            }
        }
        return matArr;
    }

    /**
     *
     * creates the adjacency matrix
     * @param matArr vertex array
     * @return adjacency matrix
     */
    public int[][] createAdj(Matrix[] matArr){

        int [][] returnMat = new int[oSize][oSize];

        //populates the adjacency matrix by calling the calc diff function
        for(int i = 0;i < oSize; i ++){
            for(int j = 0; j < oSize; j++){
                returnMat[i][j] = calcDiff(matArr[i], matArr[j]);
            }
        }
        return returnMat;
    }

    /**
     *
     * calcuates the weight between two vertices
     * @param m1 vertex 1
     * @param m2 vertex 2
     * @return weight
     */
    public int calcDiff(Matrix m1, Matrix m2){
        int diff = 0;

        //gets the weight between two vertices
        for(int i = 0; i < nSize; i++){
            for(int j = 0; j < nSize; j++){
                if(m1.getBody()[i][j] != m2.getBody()[i][j]) {
                    diff++;
                }
            }
        }

        return diff;
    }

    /*public void userPrompt(){
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
    }*/

    /**
     *
     * test method used to ensure propper reading of input file
     * @param matArr
     */
    public void printMatArr(Matrix[] matArr){

        //prints the contents of the vertex array in the same format as the input file
        for(int i = 0; i < matArr.length; i ++){
            System.out.println(i);
            for(int j = 0; j < nSize; j++) {
                for (int n = 0; n < nSize; n++) {
                    System.out.print(matArr[i].getBody()[j][n]);
                }
                System.out.println(" ");
            }
            System.out.println(" ");
            System.out.println(" ");
        }
    }
}
