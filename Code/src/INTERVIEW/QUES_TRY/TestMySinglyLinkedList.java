package INTERVIEW.QUES_TRY;

import INTERVIEW.DS_IMPL.MySinglyLinkedList;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 9/16/2016
 */

class TestMySinglyLinkedList {
    public static void main(String[] args) throws Exception {
        MySinglyLinkedList<Integer> ln = new MySinglyLinkedList<>();
        ln.addToHead(2);
        ln.addToHead(3);
        ln.addToHead(7);
        ln.addToHead(10);
        ln.addToHead(4);
        ln.printList();
        
        ln.reverse();
        ln.printList();
        
        ln.recursiveReverse(ln.getHead(), null);
        ln.printList();
        
        
    }


}