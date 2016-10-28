package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


class GCDQ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] a1 = br.readLine().split(" ");
			String[] n = br.readLine().split(" ");
			for (int j = 0; j < Integer.parseInt(a1[1]); j++) {
				String[] q = br.readLine().split(" ");
				int l = 0;
				if (!q[0].equals(q[1])) {
					l = n.length - (1 + (Integer.parseInt(q[1]) - Integer.parseInt(q[0])));
				} else {
					l = n.length - 1;
				}
				BigInteger[] nn = new BigInteger[l];
				int ck = 0;
				for (int k = 1; k <= n.length; k++) {
					if (k != Integer.parseInt(q[0])) {
						nn[ck] = new BigInteger(n[k - 1]);
						ck++;
					} else {
						k = Integer.parseInt(q[1]);
					}
				}
				//System.out.println(nn.length);
				if (nn.length != 1) {
					BigInteger te = new BigInteger(String.valueOf(nn[0]));
					BigInteger k1 = GCD(te, (nn[1]));
					for (int j1 = 2; j1 < nn.length; j1++) {
						k1 = GCD(k1, (nn[j1]));
					}
					System.out.println(k1);
				} else {
					System.out.println(nn[0]);
				}
			}
		}
	}
	
	private static BigInteger GCD(BigInteger a, BigInteger b) {
		return a.gcd(b);
	}
}