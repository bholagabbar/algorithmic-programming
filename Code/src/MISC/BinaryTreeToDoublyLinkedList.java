package MISC;

/**
 * Created by Shreyans Sheth [bholagabbar] on 4/11/2016 at 8:23 PM using IDEA
 */

class BinaryTreeToDoublyLinkedList {

    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    } 
    
//    static TreeNode head = null;
//    static TreeNode prev = null;
//    
//    void BinaryTree2DoubleLinkedList(TreeNode root) {
//        if (root == null)
//            return;
//        BinaryTree2DoubleLinkedList(root.left);
//        if (prev == null) {
//            head = root;
//        } else {
//            root.left = prev;
//            prev.right = root;
//        }
//        prev = root;
//        BinaryTree2DoubleLinkedList(root.right);
//    }
    
    static TreeNode head = null, prev = null;
    
    static void binaryToDLL(TreeNode curr) {
        if (curr == null) {
            return;
        }
        binaryToDLL(curr.left);
        if (prev == null) {
            head = curr;
        } else {
            curr.left = prev;
            prev.right = curr;
        }
        prev = curr;
        binaryToDLL(curr.right);
    }
    
    static void reverseLinkedList(ListNode head) {
        
    }
    
    static void printList(TreeNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    static void printTree(TreeNode lol) {
        if (lol != null) {
            printTree(lol.left);
            System.out.print(lol.data + " ");
            printTree(lol.right);
        }
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        // Let us create the tree as shown in above diagram
        TreeNode root;
        root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);

        printTree(root);
        System.out.println();

        // convert to DLL
        binaryToDLL(root);

        // Print the converted List
        printList(head);

    }
}