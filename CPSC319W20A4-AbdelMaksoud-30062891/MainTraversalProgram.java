
import java.io.IOException;


/**
 *
 * runs the main program for the graph traversals
 */
public class MainTraversalProgram {

    public static void main(String args[]){

        FileReadHelper fHelp = new FileReadHelper();

        //declare adjacency matrix
        int[][] adjacencyMat;
        //initialize adjacency matrix
        adjacencyMat = fHelp.readFile(args[0]);

        //creates the array keeping track of visited nodes
        int[] visited = new int[fHelp.getoSize()];

        //name of DFT file, needs to be outside the method due to recursive algorithm
        String fileName = fHelp.getnSize() + "x" + fHelp.getnSize() + "_DFT.txt";

        //allocates a traversal class to access traversal methods
        TraversalClass trav = new TraversalClass(fileName, fHelp.getoSize(), fHelp.getnSize());

        try {
            //outputs the graph.txt file
            trav.printadjMat(adjacencyMat);
            //outputs the DFT.txt file
            trav.depthFirstTraversal(adjacencyMat, visited, 0);
            //outputs the MST.txt file
            trav.minimumSpanningTree(adjacencyMat);
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
