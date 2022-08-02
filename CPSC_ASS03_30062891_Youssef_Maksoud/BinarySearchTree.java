import jdk.swing.interop.SwingInterOpUtils;

import javax.sound.midi.Soundbank;


/**
 *
 * class creates and manages a binary search tree of stored words,
 * and corresponding frequencies
 */
public class BinarySearchTree {

    /**
     *
     * tree has properties root node, node count (unique words), depth, max frequency,
     * and most occuring words
     */
    private Node rootNode = null;
    private int nodeCount = 0;
    private int totalWords;
    private int maxFrequency = 0;
    private String mostOccured = "";
    private int treeDepth;

    /**
     *
     * class constructor creates the binary search tree
     * @param wordArr is the array to be stored in the tree
     */
    public BinarySearchTree(String[] wordArr){
        createTree(wordArr);
    }

    //returns the root node
    public Node getRootNode() {
        return rootNode;
    }

    /**
     *
     * creates the binary search tree
     * @param wordArr is the array to be stored
     */
    public void createTree(String[] wordArr){

        //total words in the file is the length of the array
        totalWords = wordArr.length;

        //traverses array and creates/inserts nodes into tree
        for(int i = 0; i < wordArr.length; i ++){
            rootNode = insert(rootNode, wordArr[i]);
        }
        calculateMax(rootNode);
        treeDepth = maxDepth(rootNode);
    }

    /**
     * traverses tree in order(left, node, right)
     * @param node is the root node of the subtree
     */
    public void traverseInOrder(Node node){
        if(node == null){
            return;
        }
        traverseInOrder(node.getLeftSub());
        System.out.println(node.getWordA() + "  freq: " + node.getFrequency());
        traverseInOrder(node.getRightSub());
    }

    /**
     * traverses tree in pre order(node, left, right)
     * @param node is the root node of the subtree
     */
    public void traversePreOrder(Node node){

        if(node == null){
            return;
        }
        System.out.println(node.getWordA() + "  freq: " + node.getFrequency());
        traversePreOrder(node.getLeftSub());
        traversePreOrder(node.getRightSub());

    }

    /**
     * traverses tree in post order(left, right, node)
     * @param node is the root node of the subtree
     */
    public void traversePostOrder(Node node){

        if(node == null){
            return;
        }
        traversePostOrder(node.getLeftSub());
        traversePostOrder(node.getRightSub());
        System.out.println(node.getWordA() + "  freq: " + node.getFrequency());
    }

    private void calculateMax(Node node){
        if(node == null){
            return;
        }
        calculateMax(node.getLeftSub());
        if(maxFrequency < node.getFrequency()){
            maxFrequency = node.getFrequency();
            mostOccured = node.getWordA();
        }
        else if(maxFrequency == node.getFrequency()){
            maxFrequency = node.getFrequency();
            mostOccured = mostOccured + ", " + node.getWordA();
        }
        calculateMax(node.getRightSub());
    }

    /**
     *
     * searches for a key in the binary search tree (binary search)
     * @param node is the root node of the subtree
     * @param word is the key
     */
    public void search(Node node, String word){
        if(node == null){
            System.out.println("Word not found");
            return;
        }
        if(node.getWordA().toLowerCase().compareTo(word.toLowerCase()) == 0){
            System.out.println("The word was found! It occurs " + node.getFrequency() + " times." );
        }
        else if(node.getWordA().compareTo(word) > 0){
            search(node.getLeftSub(), word);
        }
        else if(node.getWordA().compareTo(word) < 0){
            search(node.getRightSub(), word);
        }
    }

    /**
     *
     * creates and inserts a new node in the tree
     * @param root is the root node of the subtree
     * @param word is the word to be inserted
     * @return the new node
     */
    public Node insert(Node root, String word){

        if(root == null){
            nodeCount++;
            return new Node(word);
        }

        //checks if its less than or greater than root
        //if already exists, increments the frequency of the node
        if(word.compareTo(root.getWordA()) > 0){
            root.setRightSub(insert(root.getRightSub(), word));
        }
        else if(word.compareTo(root.getWordA()) < 0){
            root.setLeftSub(insert(root.getLeftSub(), word));
        }
        else if (word.compareTo(root.getWordA()) == 0){
            root.incrementFrequency();
        }

        return root;
    }

    /**
     *
     * gets the depth of the tree
     * @param root is the root node
     * @return the depth of the tree
     */
    public int maxDepth(Node root){
        if(root == null){
            return 0;
        }
        else{
            int left = maxDepth(root.getLeftSub());
            int right = maxDepth(root.getRightSub());

            if(right > left){
                return right + 1;
            }
            else{
                return left + 1;
            }
        }
    }

    /**
     *
     * prints the properties opf the tree
     */
    public void printTreeDetails() {
        System.out.println("-------------------------------");
        System.out.println("TREE DETAILS" + "\n");
        System.out.println("The total number of words is: " + totalWords);
        System.out.println("The number of unique words is: " + nodeCount);
        System.out.println("The word(s): " + mostOccured + " appear(s): " + maxFrequency + " times");
        System.out.println("The height of the tree is: " + treeDepth);
    }

}
