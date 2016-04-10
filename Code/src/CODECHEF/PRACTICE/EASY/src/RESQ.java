package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 12/30/2014 using IntelliJ IDEA
 */

class RESQ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int sq = (int) Math.sqrt(n);
			int min;
			if ((sq * sq) == n) {
				min = 0;
			} else {
				min = n - 1;
				for (int j = 2; j <= sq; j++) {
					if (n % j == 0) {
						if (Math.abs((n / j) - j) < min) {
							min = (Math.abs((n / j) - j));
							if (min == 1) {
								break;
							}
						}
					}
				}
			}
			sb.append(min + "\n");
		}
		System.out.println(sb);
	}
}