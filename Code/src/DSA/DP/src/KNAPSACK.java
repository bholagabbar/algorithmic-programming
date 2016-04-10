import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 4/17/2015 at 10:50 PM using IntelliJ IDEA (Fast IO Template)
 */
//ADD PUBLIC FOR CF,TC
class KNAPSACK {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter total number of items");
		int n = Integer.parseInt(br.readLine());
		;//No of elements. +1 for 0
		int[] w = new int[n + 1];//Array storing weights of each element.
		int[] c = new int[n + 1];// Storing cost of each element. Again.
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter <Weight> <Value> for element " + (i));
			String[] s1 = br.readLine().split(" ");
			w[i] = Integer.parseInt(s1[0]);
			c[i] = Integer.parseInt(s1[1]);
		}
		System.out.println("Enter <capacity> of knapsack");
		int W = Integer.parseInt(br.readLine());
		int max = 0;
		int dp[][] = new int[n + 1][W + 1];//+1 for 0
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (w[i] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + c[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\nThe maximum value that can be attained is: " + max);
	}
}