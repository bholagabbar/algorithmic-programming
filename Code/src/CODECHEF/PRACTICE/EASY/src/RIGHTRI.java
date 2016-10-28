package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 12/29/2014 using IntelliJ IDEA
 */

class RIGHTRI {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < t; i++) {
			String[] v = br.readLine().split(" ");
			double a = Math.pow(Integer.parseInt(v[0]) - Integer.parseInt(v[2]), 2) + Math.pow(Integer.parseInt(v[1]) - Integer.parseInt(v[3]), 2);
			double b = Math.pow(Integer.parseInt(v[0]) - Integer.parseInt(v[4]), 2) + Math.pow(Integer.parseInt(v[1]) - Integer.parseInt(v[5]), 2);
			double c = Math.pow(Integer.parseInt(v[2]) - Integer.parseInt(v[4]), 2) + Math.pow(Integer.parseInt(v[3]) - Integer.parseInt(v[5]), 2);
			if (a == b + c || b == a + c || c == a + b) {
				cnt++;
			}
			System.out.println(cnt);
		}
	}
}
 

