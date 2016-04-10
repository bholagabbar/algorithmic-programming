package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/5/2015 using IntelliJ IDEA
 */

class NOTATRI {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		while (n != 0) {
			String[] a = br.readLine().split(" ");
			int cnt = 0;
			for (int i = 1; i <= n - 2; i++) {
				int m1 = i;
				int m2 = i + 1;
				int m3 = i + 2;
				int r = m3;
				while (m2 <= n - 1) {
					int a1 = Integer.parseInt(a[m1 - 1]);
					int a2 = Integer.parseInt(a[m2 - 1]);
					int a3 = Integer.parseInt(a[m3 - 1]);
					if (a1 > a2 + a3) {
						cnt++;
					}
					if (a2 > a1 + a3) {
						cnt++;
					}
					if (a3 > a1 + a2) {
						cnt++;
					}
					m3++;
					if (m3 > n) {
						r++;
						m3 = r;
						m2++;
					}
				}
			}
			sb.append(cnt + "\n");
			n = Integer.parseInt(br.readLine());
		}
		System.out.println(sb);
	}
}