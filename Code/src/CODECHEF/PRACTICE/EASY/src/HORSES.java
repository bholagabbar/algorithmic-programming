package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Shreyans on 12/5/2014 in IntelliJ
 */
class HORSES {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String s[] = (br.readLine()).split(" ");
			long[] a = new long[n];
			for (int j = 0; j < n; j++) {
				a[j] = Integer.parseInt(s[j]);
			}
			long min = Math.abs(a[1] - a[0]);
			Arrays.sort(a);
			for (int k = 0; k < n - 1; k++) {
				if (Math.abs(a[k] - a[k + 1]) < min) {
					min = Math.abs(a[k] - a[k + 1]);
				}
			}
			sb.append(min + "\n");
		}
		System.out.println(sb);
	}
}
