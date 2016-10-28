package INTERVIEW.QUES_TRY;

import java.io.*;
import java.util.InputMismatchException;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 10/1/2016
 */

class ReverseSublist {

    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public static void printList(ListNode now) {
        while (now != null) {
            System.out.print(now.val+" ");
            now = now.next;
        }
        System.out.println();
    }
    
    public static ListNode reverseYolo(ListNode node, int cnt, int n) {
        ListNode curr = node;
        ListNode prev = null;
        while (cnt <= n) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }
        node.next = curr;
        node = prev;
        return node;
    }
    
    public static ListNode reverseBetween(ListNode a, int m, int n) {
        ListNode prev = null;
        ListNode start = a;
        int cnt = 1;
        while (start != null) {
            if (cnt == m) {
                if (prev == null) {
                    start = reverseYolo(start, cnt, n);
                    printList(start);
                    return start;
                } else {
                    prev.next = reverseYolo(start, cnt, n);
                }
                break;
            }
            prev = start;
            start = start.next;
            cnt++;
        }
        printList(a);
        return a;
    }
    
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/input.txt"));
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
//        a.next.next.next = new ListNode(4);
//        a.next.next.next.next = new ListNode(5);
        reverseBetween(a, 1, 2);
    }
    
}