package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/17/2015 using IntelliJ IDEA
 */

class DINP1501_CHEFHILL {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n1 = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int n[] = new int[n1];
		for (int j = 0; j < n1; j++) {
			n[j] = Integer.parseInt(s[j]);
		}
		int n2 = Integer.parseInt(br.readLine());
		for (int i = 0; i < n2; i++) {
			String[] s1 = br.readLine().split(" ");
			int flag = 1;
			int x = n[Integer.parseInt(s1[0]) - 1];
			for (int j = Integer.parseInt(s1[0]); j < Integer.parseInt(s1[1]) - 1; j++) {
				if (n[j] > x) {
					flag = 0;
					break;
				}
			}
			if (flag == 1) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}


