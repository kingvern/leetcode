/*stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
/**
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rst = new ListNode(0);
        ListNode dummy = rst;
        int carrier = 0;
        //while
        while (l1 != null || l2 != null){
            if(l1 != null){
                carrier += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                carrier += l2.val;
                l2 = l2.next;
            }
            rst.next = new ListNode(carrier % 10);
            carrier = carrier / 10;
            rst = rst.next;
        }//END while
        //check the carrier
        if (carrier == 1){
            rst.next = new ListNode(1);
        }
        return dummy.next;
    }
}