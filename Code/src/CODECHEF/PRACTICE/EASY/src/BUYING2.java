package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 12/11/2014 in IntelliJ IDEA
 */
class BUYING2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < t; i++) {
			String[] s1 = (br.readLine()).split(" ");
			int n = Integer.parseInt(s1[0]);
			int k = Integer.parseInt(s1[1]);
			String[] s2 = (br.readLine()).split(" ");
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += Integer.parseInt(s2[j]);
			}
			int cnt1 = sum / k;
			int flag = 1;
			int cnt = 0;
			for (int l2 = 0; l2 < n; l2++) {
				int sum2 = 0;
				for (int l = 0; l < n; l++) {
					if (l != cnt) {
						sum2 += Integer.parseInt(s2[l]);
					}
				}
				int cnt2 = sum2 / (k);
				if (cnt2 >= cnt1) {
					flag = 0;
					break;
				}
				cnt++;
			}
			if (flag == 1) {
				sb.append(Integer.toString(cnt1) + "\n");
				//System.out.println(cnt1);
			} else if (flag == 0) {
				sb.append("-1\n");
				//System.out.println("-1");
			}
		}
		System.out.println(sb);
	}
}
