package MISC;

import java.io.*;
import java.util.ArrayList;

class FIBal {

    static final int N = (int) 1e5;

    static class Node {
        int left, right, total;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
            this.total = 10;
        }
    }

    static ArrayList<ArrayList<Integer>> left = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList<Integer>> right = new ArrayList<ArrayList<Integer>>();
    static ArrayList<Node> storeWeight = new ArrayList<Node>();
    static boolean[] vis = new boolean[N + 1];

    static int dfs(int s) {
        vis[s] = true;
        for (int i : left.get(s)) {
            if (!vis[i]) {
                storeWeight.get(s).left += dfs(i);
            }
        }
        for (int i : right.get(s)) {
            if (!vis[i]) {
                storeWeight.get(s).right += dfs(i);
            }
        }
        storeWeight.get(s).total += 2 * Math.max(storeWeight.get(s).left, storeWeight.get(s).right);
        return storeWeight.get(s).total;
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("E:\\Shreyans\\Documents\\algorithmic-programming\\Code\\src\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            left.add(new ArrayList<Integer>());
            right.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            String[] leftPart = br.readLine().split(" ");
            String[] rightPart = br.readLine().split(" ");
            storeWeight.add(new Node(Integer.parseInt(leftPart[0]), Integer.parseInt(rightPart[0])));
            for (int j = 1; j < leftPart.length; j++) {
                left.get(i).add(Integer.parseInt(leftPart[j]));
            }
            for (int j = 1; j < rightPart.length; j++) {
                right.get(i).add(Integer.parseInt(rightPart[j]));
            }
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            int leftToAdd = 0;
            int rightToAdd = 0;
            int currLeft = storeWeight.get(i).left;
            int currRight = storeWeight.get(i).right;
            int diff = Math.max(currLeft, currRight) - Math.min(currLeft, currRight);
            if (currLeft > currRight) {
                rightToAdd = diff;
            } else {
                leftToAdd = diff;
            }
            System.out.print(leftToAdd + " " + rightToAdd);
            System.out.println();
        }
    }
}


// INPUT
// 
// 22
// 0 1 2
// 2 3 4 5
// 0 11 9
// 0 10
// 0
// 0
// 0 6
// 0 7
// 0
// 0 13 14 15
// 0
// 0
// 0 19
// 0
// 0
// 0 8
// 0
// 1
// 0
// 0
// 0
// 0
// 0 12
// 7
// 0
// 0
// 0
// 0
// 0
// 0
// 0 16
// 0 17
// 0
// 0
// 0 18
// 11
// 0
// 0
// 0
// 0
// 3 21
// 5
// 1
// 2
// 
// OUTPUT
// 0: 188 0
// 1: 0 30
// 2: 0 0
// 3: 4 0
// 4: 94 0
// 5: 0 0
// 6: 0 10
// 7: 12 0
// 8: 1 0
// 9: 0 0
// 10: 0 0
// 11: 0 3
// 12: 0 0
// 13: 0 0
// 14: 0 0
// 15: 22 0
// 16: 0 0
// 17: 1 0
// 18: 0 0
// 19: 0 0
// 20: 0 12
// 21: 1 0
// 