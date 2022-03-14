package linkedList;

public class RemoveDuplicatesInLL {
    private ListNode head;
    private ListNode tail;
    private int size;

    public void LinkedList(){
        this.size = 0;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {
        RemoveDuplicatesInLL ll = new RemoveDuplicatesInLL();
    }
    public  ListNode removeDuplicates(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode temp = head;
        ListNode temp2 = head.next;
        while(temp.next != null){
           if(temp.val == temp.next.val){
               temp.next = temp.next.next;
           }else {
               temp = temp.next;
           }
        }
        return head;
    }
}
