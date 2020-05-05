/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.math.BigInteger; // https://www.geeksforgeeks.org/biginteger-class-in-java/
// should've done this with long?

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        boolean debug = false;
        
        BigInteger sum = BigInteger.ZERO;
        BigInteger ten = BigInteger.TEN;
        int exp = 0;
        //ListNode[] lArray = new ListNode[]{l1,l2};
        for (ListNode l: new ListNode[]{l1, l2}) {
            ListNode n = l;
            exp = 0;
            while (n.next != null) {
                BigInteger a = BigInteger.valueOf(n.val);
                a = a.multiply(ten.pow(exp));
                sum = sum.add(a);
                //if (debug) { System.out.println(n.val +" * 10^"+exp+" -- "+sum); }
                n = n.next;
                exp++;
            }
            BigInteger a = BigInteger.valueOf(n.val);
            a = a.multiply(ten.pow(exp));
            sum = sum.add(a);
            //if (debug) { System.out.println("Last "+n.val +" * 10^"+exp+" -- "+sum); }
        }
        
        // Could do an int array from reversed string sum but trying to find another way.
        
        ListNode r = new ListNode(sum.mod(ten).intValue());
        //if (debug) { System.out.println(sum + " " + sum%10); }
        sum = sum.subtract(sum.mod(ten));
        sum = sum.divide(ten);
        ListNode n = r;
        //if (debug) { System.out.println(sum + " " + sum%10); }
        while (sum.compareTo(BigInteger.ZERO) > 0) {
            n.next = new ListNode(sum.mod(ten).intValue());
            sum = sum.subtract(sum.mod(ten));
            sum = sum.divide(ten);
            n = n.next;
            //if (debug) { System.out.println(sum + " " + sum%10); }
        }
        return r;
    }
}



