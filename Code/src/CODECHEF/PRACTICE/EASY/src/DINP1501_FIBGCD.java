package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/16/2015 using IntelliJ IDEA
 */

class DINP1501_FIBGCD {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String s[] = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int g = GCD(a, b);
			System.out.println(FIB(g));
		}
	}
	
	private static int GCD(int a, int b) {
		if (b != 0) {
			return (GCD(b, a % b));
		} else {
			return (a);
		}
	}
	
	private static long FIB(int g) {
		if (g == 1) {
			return (1);
		} else {
			int cnt = 2;
			long a1 = 0, a2 = 1;
			long ans = 0;
			while (cnt <= g) {
				ans = (a1 + a2) % ((1000000000) + 7);
				a1 = a2;
				a2 = ans;
				cnt++;
			}
			return (ans);
		}
	}
}


