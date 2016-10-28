package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 12/6/2014 in IntelliJ
 */
class CARVANS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			int len = s.length;
			int cnt = 1;
			for (int j = 1; j < s.length; j++) {
				if (Integer.parseInt(s[j]) > Integer.parseInt(s[j - 1])) {
					s[j] = s[j - 1];
				} else {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
