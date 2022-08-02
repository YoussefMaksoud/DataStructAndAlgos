

public class Node {

    private String word;
    private Node next;

    public Node(){
    }
    public Node(String word){
        this.word = word;
    }

    public Node getNext() {
        return next;
    }

    public String getWord() {
        return word;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
