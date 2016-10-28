package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/9/2015 using IntelliJ IDEA
 */

class DIVIDING {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int asum = ((n * (n + 1)) / 2);
		int qsum = 0;
		String[] a = br.readLine().split(" ");
		for (int j = 0; j < n; j++) {
			qsum += Integer.parseInt(a[j]);
		}
		if (qsum == asum) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
 

