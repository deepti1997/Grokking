package linkedList;

public class NodeOfCycleStart {

    //https://leetcode.com/problems/linked-list-cycle-ii/
    public int getLength(ListNode slow){
        int length = 1;
        ListNode runner = slow.next;
        while(runner != slow){
            length++;
            runner = runner.next;
        }
        return length;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int length = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                //get the length of the cycle
                length = getLength(slow);
                break;
            }
        }
        if(length == 0)
            return null;
        fast = head;
        while(length != 0){
            fast = fast.next;
            length--;
        }
        slow=head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
