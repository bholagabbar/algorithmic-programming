package CODECHEF.LOCAL_CONTESTS.XCPT2015.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 31/1/15 at 9:04 PM using IntelliJ IDEA (Fast IO Template)
 */

class XC202 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String a2[] = br.readLine().split(" ");
			int[] a = new int[n];
			int max = Integer.parseInt(a2[0]);
			int ind = 1;
			for (int j = 1; j < a2.length; j++) {
				a[j] = Integer.parseInt(a2[j]);
				if (a[j] > max) {
					ind = j + 1;
					max = a[j];
				}
			}
			sb.append(ind + "\n");
		}
		System.out.println(sb);
	}
}