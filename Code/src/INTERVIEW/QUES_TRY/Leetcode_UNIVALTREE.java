package INTERVIEW.QUES_TRY;

/**
 * Created by Shreyans Sheth [bholagabbar] on 4/11/2016 at 8:23 PM using IDEA
 */

class Leetcode_UNIVALTREE {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static int cnt = 0;

    public static boolean rec(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = rec(root.left);
        boolean right = rec(root.right);
        if (left && right) {
            if (root.left != null && root.left.val != root.val || root.right != null && root.right.val != root.val) {
                return false;
            }
            cnt++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(1);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(5);
        rec(node);
        System.out.println(cnt);
    }
}