
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TraversalClass {

    private int oSize;
    private int nSize;
    private PrintWriter DFTWriter;

    /**
     *
     * default constructor initializes a printWriter to write into a file
     * @param fileName name of the output file
     * @param oSize number of vertices (overall size)
     * @param nSize size of an individual vertex (neighborhood)
     */
    public TraversalClass(String fileName, int oSize, int nSize){
        //size of neighborhood
        this.nSize = nSize;
        //number of vertices
        this.oSize = oSize;

        try{
            //creates a new output stream to write to a text file, needed to be in constructor due
            //to recursive DFT algorithm
            DFTWriter = new PrintWriter(new FileWriter(fileName), true);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * prints the graph
     * @param adjMat adjacency matrix
     * @throws IOException
     */
    public void printadjMat(int[][] adjMat) throws IOException {

        //name of output file
        String fileName = nSize + "x" + nSize + "_GRAPH.txt";

        PrintWriter writer = new PrintWriter(new FileWriter(fileName), true);

        //System.out.print("Edge" + "     Weight");
        //System.out.println("");

        writer.print("Edge" + "     Weight");
        writer.println(" ");

        //prints the graph
        for(int i = 0; i < oSize; i++){
            for(int j = i; j < oSize; j++){
                if(i != j) {
                    //System.out.printf("%-3d%s%3d%4d", i,"-",j, adjMat[i][j]);
                    //System.out.println(" ");

                    writer.printf("%-3d%s%3d%4d", i,"-",j, adjMat[i][j]);
                    writer.println(" ");
                }
            }
        }
        writer.close();
    }

    /**
     *
     * does a depth first traversal fot the graph
     * @param adjMat adjacency matrix
     * @param visited array keeping track of visited vertices
     * @param startVertex starting vertex
     */
    public void depthFirstTraversal(int[][] adjMat,int[] visited, int startVertex){

        if(visited[startVertex] == 1){
            return;
        }

        //prints the contents of the depth first traversal
        for (int i = startVertex; i < visited.length; i++) {
             if (i != startVertex && visited[startVertex] == 0) {
                 DFTWriter.printf("%-3d%s%3d%4d", startVertex, "-", i, adjMat[startVertex][i]);
                 DFTWriter.println(" ");

                 //System.out.printf("%-3d%s%3d%4d", startVertex, "-", i, adjMat[startVertex][i]);
                 //System.out.println(" ");

                 visited[startVertex] = 1;
                 depthFirstTraversal(adjMat, visited, i);
             }
        }


    }

    /**
     *
     * creates the minimum spanning tree based on the adjacency matrix
     * @param adjMat is the adjacency matrix
     * @throws IOException
     */
    //the following code was sourced from https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
    public void minimumSpanningTree(int[][] adjMat) throws IOException {

        //stores the MST
        int[] parentArr = new int[oSize];

        //stores keys corresponding to minimum weights
        int[] key = new int[oSize];

        //vertices not yet included in MST
        boolean[] notYetInc = new boolean[oSize];

        //initializes key array to inf and sets notYetInc to false for all elements
        for(int i = 0; i < oSize; i++){
            key[i] = Integer.MAX_VALUE;
            notYetInc[i] = false;
        }

        //include first vertex in MST
        key[0] = 0;

        //first node is the root
        parentArr[0] = -1;

        for(int i = 0; i < oSize - 1; i++){

            int minKey = minKey(key, notYetInc);

            notYetInc[minKey] = true;

            for(int j = 0; j < oSize; j++){
                if(adjMat[minKey][j] != 0 && notYetInc[j] == false && adjMat[minKey][j] < key[j]){
                    parentArr[j] = minKey;
                    key[j] = adjMat[minKey][j];
                }
            }
        }

        printSpanningTree(parentArr, adjMat);
    }

    /**
     *
     * prints the minimum spanning tree
     * @param parentArr the parent node array of MST
     * @param adjMat the adjacency matrix
     * @throws IOException
     */
    public void printSpanningTree(int[] parentArr, int[][] adjMat) throws IOException {

        String fileName = nSize + "x" + nSize + "_MST.txt";

        PrintWriter writer = new PrintWriter(new FileWriter(fileName), true);

        writer.print("Edge" + "     Weight");
        writer.println(" ");

        //prints the spanning tree
        for(int i = 1; i < parentArr.length; i ++){
            //System.out.printf("%-3d%s%3d%4d", parentArr[i], "-", i, adjMat[i][parentArr[i]]);
            //System.out.println("");

            writer.printf("%-3d%s%3d%4d", parentArr[i], "-", i, adjMat[i][parentArr[i]]);
            writer.println("");
        }

        writer.close();
    }

    /**
     *
     * returns the index of the minimum key
     * @param key key of element
     * @param notYetInc vertices not yet included in MST
     * @return returns the minimum index
     */
    public int minKey(int[] key, boolean[] notYetInc){
        int min = Integer.MAX_VALUE, minIndex = -1;

        //find the minimum key value
        for(int i = 0; i < oSize; i++){
            if(notYetInc[i] == false && key[i] < min){
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

}
