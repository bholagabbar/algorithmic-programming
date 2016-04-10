package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Shreyans on 12/13/2014 in IntelliJ IDEA
 */
class HOTEL {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] s1 = br.readLine().split(" ");
			String[] s2 = br.readLine().split(" ");
			int[] a = new int[n];
			int[] d = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = Integer.parseInt(s1[j]);
				d[j] = Integer.parseInt(s2[j]);
			}
			Arrays.sort(a);
			Arrays.sort(d);
			int j = 0, x = 0, cnt = 0, max = 0;
			while (j < n && x < n) {
				if (a[j] < d[x]) {
					cnt++;
					j++;
				} else if (a[j] == d[x]) {
					int v = a[j];
					while (j != n && a[j] == v) {
						cnt++;
						j++;
					}
					while (x != n && d[x] == v) {
						x++;
						cnt--;
					}
				} else if (a[j] > d[x]) {
					cnt--;
					x++;
				}
				if (cnt > max) {
					max = cnt;
				}
			}
			sb.append(max + "\n");
		}
		System.out.println(sb);
	}
}

/* SPENDING VACATION TIME HOPING THIS SHIT TO WORK
3
3
1 2 3
4 5 6
5
1 2 3 4 5
2 3 4 5 6
7
13 6 5 8 2 10 12
19 18 6 9 9 11 15  */
