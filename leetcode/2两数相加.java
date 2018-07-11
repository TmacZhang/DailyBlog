/*
���������ǿ���������ʾ�����Ǹ�������λ����������ʽ�洢�����ǵ�ÿ���ڵ�ֻ�洢�������֡���������ӷ���һ���µ�����

����Լ���������� 0 ֮�⣬���������ֶ��������㿪ͷ��

ʾ����

���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
�����7 -> 0 -> 8
ԭ��342 + 465 = 807
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