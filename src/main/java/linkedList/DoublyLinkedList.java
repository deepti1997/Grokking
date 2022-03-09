package linkedList;

public class DoublyLinkedList {
    Node head;
    private class Node{
        private int val;
        private Node next;
        private Node prev;


        public  Node(int val){
            this.val = val;
        }

        public  Node(int val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertFirst(int val){
        Node n = new Node(val);
        n.next = head;
        n.prev = null;
        if(head != null)
            head.prev = n;
        head = n;
    }
    public void display(){
        Node temp = head;
        if(head == null){
            System.out.println("END");
            return;
        }
        while(temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public void displayReverse(){
        Node temp = head;
        if(head == null){
            System.out.println("END");
            return;
        }
        while(temp.next != null){
            temp = temp.next;
        }
        while (temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.prev;
        }
        System.out.println("Start");
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(5);
        doublyLinkedList.insertFirst(8);
        doublyLinkedList.display();
        doublyLinkedList.displayReverse();
    }
}
