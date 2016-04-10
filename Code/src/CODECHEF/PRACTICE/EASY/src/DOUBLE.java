package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DOUBLE {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int no = Integer.parseInt(br.readLine());
		int[] ans = new int[no];
		int cnt = 0;
		for (int i = 0; i < no; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a % 2 == 0) {
				ans[cnt] = a;
				cnt++;
			} else {
				ans[cnt] = a - 1;
				cnt++;
			}
		}
		for (int i = 0; i < cnt; i++) {
			System.out.println(ans[i]);
		}
	}
}