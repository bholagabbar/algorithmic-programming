import java.util.*;

// Time Complexity : O(k)
// Space Complexity : O(n)

// Problem link : https://www.codechef.com/problems/TWTCLOSE

class TWTCLOSE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] status = new int[n];
        int k = in.nextInt();
        // onSymbol : it is the number to be used for denoting open state
        int onSymbol = 1;
        int count = 0;
        for (int i = 0; i < k; i++) {
            String cmd = in.next();
            if (cmd.equals("CLICK")) {
                int index = in.nextInt() - 1;
                if (status[index] == onSymbol) {
                    count--;
                    status[index] = 0;
                } else {
                    count++;
                    status[index] = onSymbol;
                }
            } else {
                count = 0;
                //changing onSymbol makes status all the element close in constant time 
                onSymbol++;
            }
            System.out.println(count);
        }
    }
}
