package linkedList;

public class ReverLinkedList {

    //withRecursion
//    class Solution {
//        public ListNode reverseList(ListNode head) {
//            if(head == null || head.next == null)
//                return head;
//            ListNode newTail =  helper(head);
//            newTail.next = null;
//            return newHead;
//        }
//        ListNode newHead = new ListNode();
//        public ListNode helper(ListNode currentNode){
//            if(currentNode.next == null){
//                newHead = currentNode;
//                return currentNode;
//            }
//            ListNode rNode = helper(currentNode.next);
//            System.out.println(rNode.val);
//            rNode.next = currentNode;
//            return currentNode;
//        }
//    }


    //BetterRecursion
//    public ListNode reverseList(ListNode head) {
//
//        if(head== null || head.next==null)
//            return head;
//
//        ListNode rNode = reverseList(head.next); // remember here head signifies the currentNode
//
//        head.next.next = head;
//        head.next = null;
//
//        return rNode;
//    }

    //ierative
//        if(head == null || head.next == null){
//        return head;
//    }
//
//    ListNode previous = null;
//    ListNode present = head;
//    ListNode nextNode = head.next;
//
//        while(present != null){
//        present.next = previous;
//        previous = present;
//        present = nextNode;
//        if(nextNode != null)
//            nextNode = nextNode.next;
//    }
//
//        return previous;

}
