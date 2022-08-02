

public class LinkedList {
    Node headM;

    public LinkedList(){
        headM = new Node();
    }

    public Node getHeadM() {
        return headM;
    }

    public void addNode(String word){
        Node newN = new Node(word);
        newN.setNext(null);
        Node pointer = headM;

        for(int i = 0 ; pointer.getNext() != null; i ++){
            pointer = pointer.getNext();
        }
        pointer.setNext(newN);
    }

    public void printList(){
        Node after = headM.getNext();

        for(int i = 0; after != null; i++){
            System.out.printf("%s" + " ", after.getWord());
            after = after.getNext();
        }
    }

}
