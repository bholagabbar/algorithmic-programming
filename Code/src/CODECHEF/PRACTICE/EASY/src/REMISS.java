package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 12/12/2014 in IntelliJ IDEA
 */
class REMISS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] s = (br.readLine()).split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int max = a;
			if (b > max) {
				max = b;
			}
			int sum = (a + b);
			sb.append(max + " " + sum + "\n");
		}
		System.out.println(sb);
	}
}
