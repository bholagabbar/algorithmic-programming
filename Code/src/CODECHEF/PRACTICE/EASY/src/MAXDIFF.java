package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Shreyans on 1/2/2015 using IntelliJ IDEA
 */

class MAXDIFF {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < t; i++) {
			String a1[] = br.readLine().split(" ");
			int n = Integer.parseInt(a1[0]);
			int k = Integer.parseInt(a1[1]);
			String a2[] = br.readLine().split(" ");
			int[] a = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = Integer.parseInt(a2[j]);
			}
			Arrays.sort(a);
			int n1 = 0, n2 = 0, cnt1 = n - 1, n3 = 0, n4 = 0;
			for (int j = 0; j < n; j++) {
				if (j < k) {
					
					n1 += a[j];
					n2 += a[cnt1];
					cnt1--;
				} else {
					
					n3 += a[j];
					n4 += a[cnt1];
					cnt1--;
					if (cnt1 == -1) {
						break;
					}
				}
			}
			int ans = 0;
			if (n3 - n1 > n2 - n4) {
				ans = n3 - n1;
			} else {
				ans = n2 - n4;
			}
			//System.out.println(n1+" "+n2);
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
}