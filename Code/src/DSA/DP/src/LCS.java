import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 4/18/2015 at 11:21 PM using IntelliJ IDEA (Fast IO Template)
 */

//ADD PUBLIC FOR CF,TC
class LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 2 Strings to find length LCS");
		String a1 = br.readLine();
		String b1 = br.readLine();
		char[] a = new char[a1.length() + 1];
		char[] b = new char[b1.length() + 1];
		int n = a.length - 1;
		int m = b.length - 1;
		for (int i = 1; i <= n; i++) {
			a[i] = a1.charAt(i - 1);
		}
		for (int i = 1; i <= m; i++) {
			b[i] = b1.charAt(i - 1);
		}
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (a[i] == b[j]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println("Length of LCS is: " + dp[n][m]);
		int index = dp[n][m];
		/*
       -1  -1   Ø	M	Z	J	A	W	X	U
        0	Ø	0	0	0	0	0	0	0	0
        1	X	0	0	0	0	0	0	1	1
        2	M	0	1	1	1	1	1	1	1
        3	J	0	1	1	2	2	2	2	2
        4	Y	0	1	1	2	2	2	2	2
        5	A	0	1	1	2	3	3	3	3
        6	U	0	1	1	2	3	3	3	4
        7	Z	0	1	2	2	3	3	3	4

         */
		char[] lcs = new char[index];
		// Start from the right-most-bottom-most corner and
		// one by one store characters in lcs[]
		int i = n, j = m;
		while (i > 0 && j > 0)// BACKTRACKING ALGO. REFER TO IABLE
		{
			// If current character in X[] and Y are same, then
			// current character is part of LCS
			if (a[i] == b[j]) {
				lcs[index - 1] = a[i]; // Put current character in result
				i--;
				j--;
				index--;     // reduce values of i, j and index
			}
			// If not same, then find the larger of two and
			// go in the direction of larger value
			else if (dp[i - 1][j] > dp[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		System.out.print("\nLCS is: ");
		for (char x : lcs) {
			System.out.print(x);
		}
		System.out.println();
	}
}