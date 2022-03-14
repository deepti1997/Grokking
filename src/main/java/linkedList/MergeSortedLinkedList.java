package linkedList;
//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeSortedLinkedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = new ListNode(-1);
        ListNode p2 = p1;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                p2.next = list1;
                p2 = p2.next;
                list1 = list1.next;
            }else{
                p2.next = list2;
                p2 = p2.next;
                list2 = list2.next;
            }
        }
        p2.next = list1 == null ? list2 : list1;
        return p1.next;
    }
}
