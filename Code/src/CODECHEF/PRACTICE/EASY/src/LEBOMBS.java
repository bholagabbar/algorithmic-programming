package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 12/29/2014 using IntelliJ IDEA
 */

class LEBOMBS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] a = br.readLine().split("");
			for (int j = 0; j < a.length; j++) {
				if (a.length > 1 && a[j].equals("1")) {
					if (j != 0 && j != a.length - 1 && !a[j + 1].equals("1")) {
						a[j - 1] = "b";
						a[j + 1] = "b";
					} else if (j != 0 && j != a.length - 1 && a[j + 1].equals("1")) {
						a[j - 1] = "b";
					} else if (j == 0 && a[j + 1].equals("0")) {
						a[j + 1] = "b";
					} else if (j == a.length - 1 && a[j - 1].equals("0")) {
						a[j - 1] = "b";
					}
				}
			}
			int ans = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[j].equals("0")) {
					ans++;
				}
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
}