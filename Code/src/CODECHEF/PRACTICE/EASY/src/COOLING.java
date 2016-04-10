package CODECHEF.PRACTICE.EASY.src; /**
 * Created by Shreyans on 11/20/2014.
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class COOLING {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] ans = new int[a];
		int cnta = 0;
		for (int i = 0; i < a; i++) {
			int n = sc.nextInt();
			int[] pi = new int[n];
			int[] cr = new int[n];
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				pi[j] = sc.nextInt();
			}
			for (int j = 0; j < n; j++) {
				cr[j] = sc.nextInt();
			}
			Arrays.sort(pi);
			Arrays.sort(cr);
			int cntp = 0;
			for (int j = 0; j < n; j++) {
				if (pi[cntp] <= cr[j]) {
					cntp++;
				}
			}
			ans[cnta] = cntp;
			cnta++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i : ans) {
			sb.append(i + "\n");
		}
		System.out.println(sb);
	}
}
