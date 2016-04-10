package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Shreyans on 1/16/2015 using IntelliJ IDEA
 */

class DINP1501_CHEFPOW {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String h = br.readLine();
		BigInteger n = new BigInteger(h);
		String[] s = new String[100000];
		String ans = "";
		int cnt = 0;
		while (n.compareTo(BigInteger.ZERO) > 0) {
			double x = Math.log(n.doubleValue()) / Math.log(2);
			BigInteger p = new BigInteger(Long.toString((long) Math.pow(2, (long) x)));
			n = n.subtract(p);
			s[cnt] = String.valueOf(p);
			cnt++;
		}
		for (int j = cnt - 1; j >= 0; j--) {
			System.out.print(s[j] + " ");
		}
	}
}