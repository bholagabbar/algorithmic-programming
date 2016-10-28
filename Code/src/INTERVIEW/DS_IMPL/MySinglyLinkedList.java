package INTERVIEW.DS_IMPL;

/**
 * Shreyans Sheth [bholagabbar | http://shreyans-sheth.me]
 * 9/16/2016
 */

public class MySinglyLinkedList<T> {

    Node<T> head;
    Node<T> tail;
    int cnt;

    public MySinglyLinkedList() {
        head = null;
        tail = null;
        cnt = 0;
    }

    public void addToTail(T element) {
        Node<T> toAdd = new Node<>(element, null);
        if (head == null) {
            head = toAdd;
            tail = toAdd;
        } else {
            Node<T> temp = tail;
            temp.nextNode = toAdd;
            tail = toAdd;
        }
        cnt++;
    }

    public void addToHead(T element) {
        Node<T> toAdd = new Node<>(element, null);
        if (head == null) {
            head = toAdd;
            tail = toAdd;
        } else {
            toAdd.nextNode = head;
            head = toAdd;
        }
        cnt++;
    }

    public void deleteHead() {
        if (head == null) {
            System.out.println("Underflow");
        } else if (head.nextNode == null) {
            head = null;
            tail = null;
        } else {
            head = head.nextNode;
        }
        cnt--;
    }

    public void deleteTail() {
        if (tail == null) {
            System.out.println("Underflow");
        } else {
            Node<T> tmp = head;
            while ((tmp.nextNode).nextNode != null) {
                tmp = tmp.nextNode;
            }
            tmp.nextNode = null;
        }
        cnt--;
    }

    public void printList() {
        Node<T> tmp = head;
        while (tmp != null) {
            System.out.print(tmp.value + " ");
            tmp = tmp.nextNode;
        }
        System.out.println();
    }
    
    public void reverse() {
        Node<T> previous = null;
        Node<T> next = null;
        Node<T> current = head;
        while (current != null) {
            next = current.nextNode;
            current.nextNode = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
    
    public void recursiveReverse(Node<T> current, Node<T> previous) {
        if (current == null) {
            head = previous;
            return;
        }
        Node<T> next = current.nextNode;
        current.nextNode = previous;
        previous = current;
        current = next;
        recursiveReverse(current, previous);
    }
    
    public int getCnt() {
        return this.cnt;
    }
    
    public Node<T> getHead() {
        return head;
    }
}

class Node<T> implements Comparable<T> {
    public T value;
    public Node<T> nextNode;

    public Node() {
        this.value = null;
        this.nextNode = null;
    }

    public Node(T value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public int compareTo(T arg) {
        if (arg == value) {
            return 0;
        }
        return 1;
    }
}