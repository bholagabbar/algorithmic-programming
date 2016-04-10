package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/9/2015 using IntelliJ IDEA
 */

class LUCKYSTR {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String c[] = br.readLine().split(" ");
		String[] a = new String[Integer.parseInt(c[0])];
		for (int j = 0; j < a.length; j++) {
			a[j] = br.readLine();
		}
		String[] s = new String[Integer.parseInt(c[1])];
		for (int j = 0; j < s.length; j++) {
			s[j] = br.readLine();
		}
		int[] v = new int[s.length];
		for (int j = 0; j < s.length; j++) {
			if (s[j].length() >= 47) {
				v[j] = 1;
			} else {
				for (int k = 0; k < a.length; k++) {
					if (s[j].contains(a[k])) {
						v[j] = 1;
						break;
					}
				}
			}
			if (v[j] == 1) {
				sb.append("Good\n");
			} else {
				sb.append("Bad\n");
			}
		}
		System.out.println(sb);
	}
}