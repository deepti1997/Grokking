package linkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public void LinkedList(){
        this.size = 0;
    }
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }
    public void insertFirst(int val){
        Node n = new Node(val);
        n.next = head;
        head = n;

        if(tail == null){
            tail = head;
        }
        size++;
    }
    public void insertLast(int val){
        if(tail == null)
            insertFirst(val);
        else{
            Node n = new Node(val);
            tail.next = n;
            tail = n;
            size++;
        }
    }
    public void insertAtK(int val,int pos){
        if(pos > size)
            return;
        if(pos == 0){
            insertFirst(val);
            return;
        }
        if(pos == size){
            insertLast(val);
            return;
        }
        Node n = new Node(val);
        Node temp = head;
        for(int i =1;i<pos;i++){
            temp = temp.next;
        }
        n.next = temp.next;
        temp.next = n;
        size++;
    }
    public int deleteFirst(){
       int val = Integer.MAX_VALUE;
        if(head != null){
          val = head.value;
          head = head.next;
          if(head == null)
              tail = null;
          size--;
       }
        return val;
    }
    public Node get(int index){
        Node n = head;
        for(int i=0;i<index;i++){
            n = n.next;
        }
        return n;
    }
    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int val = tail.value;
        tail = secondLast;
        secondLast.next = null;
        return val;
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+"->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtK(4,0);
        ll.insertFirst(6);
        ll.insertFirst(8);
        ll.insertFirst(10);
        ll.display();
        System.out.println(ll.deleteFirst());
        ll.display();
        ll.insertAtK(4,0);
        ll.insertFirst(6);
        ll.insertFirst(8);
        ll.display();
        ll.deleteLast();
        ll.display();
    }
}
