/*
给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode p = l1, q = l2;
         int w = 0;
         int value = 0;
        
         ListNode head = null;
         ListNode head1 = null;
         boolean isHead = true;
         while(p != null || q != null || w>0){

             
            value = w + (p != null ? p.val:0) + (q != null ? q.val : 0);
            w = value / 10;
             
            if(isHead){
                isHead =false;
                head1 = head = new ListNode(value % 10); 
            }else{
                head.next = new ListNode(value % 10); 
                head = head.next ;
            }              
             
            p =  p != null ? p.next : null;
            q =  q != null ? q.next : null; 
         }
        
        return head1;
    }

}