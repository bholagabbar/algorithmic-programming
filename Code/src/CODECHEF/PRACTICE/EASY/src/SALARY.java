package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by shreyans on 22/1/15 at 11:03 PM using IntelliJ IDEA
 */
class SALARY {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < t; i++) {
			int no = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			int[] n = new int[no];
			for (int j = 0; j < no; j++) {
				n[j] = Integer.parseInt(s[j]);
			}
			Arrays.sort(n);
			int sum = 0;
			for (int j = 1; j < no; j++) {
				sum += n[j] - n[0];
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}
}
