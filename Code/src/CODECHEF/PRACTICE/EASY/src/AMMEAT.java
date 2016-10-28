package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by shreyans on 26/1/15 at 10:55 PM using IntelliJ IDEA
 */
class AMMEAT {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < t; i++) {
			String a1[] = br.readLine().split(" ");
			int n1 = Integer.parseInt(a1[0]);
			BigInteger m = new BigInteger(a1[1]);
			String[] s1 = br.readLine().split(" ");
			BigInteger[] b = new BigInteger[s1.length];
			BigInteger sum = BigInteger.ZERO;
			for (int j = 0; j < s1.length; j++) {
				b[j] = new BigInteger(s1[j]);
				sum = sum.add(b[j]);
			}
			if (sum.compareTo(m) < 0) {
				sb.append("-1\n");
			} else {
				Arrays.sort(b);
				sum = b[n1 - 1];
				int x = n1 - 2;
				int cnt = 1;
				while (sum.compareTo(m) < 0 && x > -1) {
					sum = sum.add(b[x]);
					x--;
					cnt++;
				}
				sb.append(cnt).append("\n");
			}
		}
		System.out.println(sb);
	}
}
