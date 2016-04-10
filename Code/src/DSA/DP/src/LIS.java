import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by Shreyans on 4/16/2015 at 7:22 PM using IntelliJ IDEA (Fast IO Template)
 */
class LIS//Longest Increasing Subsequence
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//test: 10 22 9 33 21 50 41 60 80
		PrintWriter out = new PrintWriter(System.out);
		System.out.println("Please Enter few numbers to find the LIS");
		String[] s1 = br.readLine().split(" ");
		int n = s1.length;
		int[] a = new int[n];//List of Numbers
		String[] ls = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(s1[i]);
		}
		int[] dp = new int[n];//Storing length of max subsequence
		int max = dp[0] = 1;
		String seq = ls[0] = s1[0];
		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			String x = "";
			for (int j = i - 1; j >= 0; j--) {
				//First check if number at index j is less than num at i.
				// Second the length of that DP should be greater than dp[i]
				// -1 since dp of previous could also be one. So we compare the dp[i] as empty initially
				if (a[j] < a[i] && dp[j] > dp[i] - 1) {
					dp[i] = dp[j] + 1;
					x = ls[j];
				}
			}
			x += (" " + a[i]);
			ls[i] = x;
			if (dp[i] > max) {
				max = dp[i];
				seq = ls[i];
			}
		}
		out.println("Length of LIS is: " + max + "\nThe Sequence is: " + seq);
		{
			out.close();
		}
	}
}