
/**
 *
 * class composes all individual nodes of the binary search tree
 */
public class Node {

    /**
     *
     * node contains a word, frequency of word, and a left and right pointer to children
     */
    private Node leftSub;
    private Node rightSub;
    private String wordA;
    private int frequency = 0;

    /**
     *
     * class constructor sets member variables
     * @param word is the data item contained within the node
     */
    public Node(String word){

        wordA = word;
        leftSub = null;
        rightSub = null;

        incrementFrequency();
    }

    //sets the left child of a node
    public void setLeftSub(Node leftSub) {
        this.leftSub = leftSub;
    }

    //sets the right child of a node
    public void setRightSub(Node rightSub) {
        this.rightSub = rightSub;
    }

    //increments the frequency of an occuring word to avoid duplicate nodes
    public void incrementFrequency(){
        frequency ++;
    }

    //returns the frequency of occuance of a word
    public int getFrequency() {
        return frequency;
    }

    //returns the left child of a node
    public Node getLeftSub() {
        return leftSub;
    }

    //returns the right child of a node
    public Node getRightSub() {
        return rightSub;
    }

    //returns the data item of the node
    public String getWordA() {
        return wordA;
    }
}

