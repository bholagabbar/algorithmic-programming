package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Shreyans on 12/21/2014 in IntelliJ IDEA
 */
class DRAGNXOR {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int a1 = Integer.parseInt(s[1]);
			int a2 = Integer.parseInt(s[2]);
			int b1 = a1, b2 = a2;
			int[] ar1 = new int[n];
			Integer[] ar2 = new Integer[n];
			int cnt1 = 0, cnt2 = 0;
			while (b1 > 0) {
				ar1[cnt1] = (b1 % 2);
				b1 = b1 / 2;
				cnt1++;
			}
			while (b2 > 0) {
				ar2[cnt2] = Integer.valueOf(b2 % 2);
				b2 = b2 / 2;
				cnt2++;
			}
			for (int j = cnt2; j < n; j++) {
				ar2[j] = Integer.valueOf(0);
			}
			Arrays.sort(ar1);
			Arrays.sort(ar2, Collections.reverseOrder());
			int cnt3 = 0;
			int[] ans = new int[n];
			for (int j = 0; j < n; j++) {
				if (ar1[j] != ar2[j]) {
					ans[j] = 1;
				} else {
					ans[j] = 0;
				}
			}
			Arrays.sort(ans);
			int ansf = 0;
			for (int j = 0; j < ans.length; j++) {
				ansf += ans[j] * Math.pow(2, j);
			}
			System.out.println(ansf);
		}
	}
}
