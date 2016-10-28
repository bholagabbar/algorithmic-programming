package INTERVIEW.QUES_TRY;

import java.util.List;

//public class for CF, TC
class AddTwoNosLL {

    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode previous = null;
        ListNode head = null;
        ListNode aHead = a;
        ListNode bHead = b;
        boolean carry = false;
        while (a != null || b != null) {
            int f = 0, s = 0;
            if (carry) {
                f++;
            }
            carry = false;
            if (a != null) {
                f += a.val;
                a = a.next;
            }
            if (b != null) {
                s = b.val;
                b = b.next;
            }
            if (f + s > 9) {
                carry = true;
            }
            int curr = (f + s) % 10;
            ListNode newNode = new ListNode(curr);
            if (previous == null) {
                previous = newNode;
                head = newNode;
            } else {
                previous.next = newNode;
                previous = previous.next;
            }
        }
        printList(aHead);
        printList(bHead);
        if (carry) {
            previous.next = new ListNode(1);
        }
        printList(head);
        return head;
    }
    
    public static void main(String[] args) throws Exception {
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);

        addTwoNumbers(a, b);
    }
}