// Sort a linked list in O(n log n) time using constant space complexity. 在O(nlogn)时间内，利用常量空间，对链表进行排序
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //归并，利用两个快慢指针分拆
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head , fast = head.next;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        return mergeListNode(sortList(head), sortList(head2));
    }
    //合并，递归
    private ListNode mergeListNode(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        
        ListNode head = null;
        //System.out.println("list1.val = " +list1.val + "  list2.val = " +list2.val);
        if(list1.val < list2.val){
            head = list1;
            head.next = mergeListNode(list1.next, list2);
        }else{
            head = list2;
            head.next = mergeListNode(list2.next, list1);
        }
        return head;
    }

}
