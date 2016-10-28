package INTERVIEW.QUES_TRY;

import java.util.List;

import static INTERVIEW.QUES_TRY.LinkedListPalindromeLinear.mid;
import static javafx.scene.input.KeyCode.L;

//public class for CF, TC
class LinkedListPartition {

    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode partition(ListNode a, int b) {
        if (a.next == null) {
            return a;
        }
        ListNode smallChain = null;
        ListNode smallChainHead = null;
        ListNode bigChain = null;
        ListNode bigChainHead = null;
        ListNode curr = a;
        while (curr != null) {
            if (curr.val < b) {
                if (smallChain == null) {
                    smallChain = curr;
                    smallChainHead = curr;
                } else {
                    smallChain.next = curr;
                    smallChain = smallChain.next;
                }
            } else {
                if (bigChain == null) {
                    bigChain= curr;
                    bigChainHead = curr;
                } else {
                    bigChain.next = curr;
                    bigChain = bigChain.next;
                }
            }
            curr = curr.next;
        }
        if (bigChain != null) {
            bigChain.next = null;
        }
        if (smallChain != null) {
            smallChain.next = bigChainHead;
        } else {
            smallChainHead = bigChainHead;
        }
        return smallChainHead;
    }
    
    public static void main(String[] args) throws Exception {
        ListNode a = new ListNode(2);
        a.next = new ListNode(1);
        a.next.next = new ListNode(4);
        a.next.next.next = new ListNode(3);
        a.next.next.next.next = new ListNode(5);
        a.next.next.next.next.next = new ListNode(2);

        partition(a, 3);
    }
}