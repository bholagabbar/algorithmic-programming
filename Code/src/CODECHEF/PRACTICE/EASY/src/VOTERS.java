package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Shreyans on 12/10/2014 in IntelliJ
 */
class VOTERS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		int n1 = Integer.parseInt(s1[0]);
		int n2 = Integer.parseInt(s1[1]);
		int n3 = Integer.parseInt(s1[2]);
		int[] a1 = new int[n1];
		int[] a2 = new int[n2];
		int[] a3 = new int[n3];
		for (int i = 0; i < n1; i++) {
			a1[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < n2; i++) {
			a2[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < n3; i++) {
			a3[i] = Integer.parseInt(br.readLine());
		}
		int max = n1;
		if (n2 > n1 && n2 > n3) {
			max = n2;
		} else if (n3 > n1 && n3 > n2) {
			max = n3;
		}
		int cnt = 0;
		int a[] = new int[max];
		if (max == n1) {
			//Arrays.sort(a2);
			//Arrays.sort(a3);
			for (int i = 0; i < max; i++) {
				int in1 = Arrays.binarySearch(a2, a1[i]);
				if (in1 > -1) {
					a[cnt] = a1[i];
					cnt++;
				} else if (in1 < 0) {
					int in2 = Arrays.binarySearch(a3, a1[i]);
					if (in2 > -1) {
						a[cnt] = a1[i];
						cnt++;
					}
				}
			}
			for (int i = 0; i < n2; i++) {
				int in3 = Arrays.binarySearch(a1, a2[i]);
				if (in3 < 0) {
					int in4 = Arrays.binarySearch(a3, a2[i]);
					if (in4 > -1) {
						a[cnt] = a2[i];
						cnt++;
					}
				}
			}
		} else if (max == n2) {
			// Arrays.sort(a1);
			// Arrays.sort(a3);
			for (int i = 0; i < max; i++) {
				int in1 = Arrays.binarySearch(a1, a2[i]);
				if (in1 > -1) {
					a[cnt] = a2[i];
					cnt++;
				} else if (in1 < 0) {
					int in2 = Arrays.binarySearch(a3, a2[i]);
					if (in2 > -1) {
						a[cnt] = a2[i];
						cnt++;
					}
				}
			}
			for (int i = 0; i < n1; i++) {
				int in3 = Arrays.binarySearch(a2, a1[i]);
				if (in3 < 0) {
					int in4 = Arrays.binarySearch(a3, a1[i]);
					if (in4 > -1) {
						a[cnt] = a1[i];
						cnt++;
					}
				}
			}
		} else if (max == n3) {
			// Arrays.sort(a1);
			//Arrays.sort(a2);
			for (int i = 0; i < max; i++) {
				int in1 = Arrays.binarySearch(a1, a3[i]);
				if (in1 > -1) {
					a[cnt] = a3[i];
					cnt++;
				} else if (in1 < 0) {
					int in2 = Arrays.binarySearch(a2, a3[i]);
					if (in2 > -1) {
						a[cnt] = a3[i];
						cnt++;
					}
				}
			}
			for (int i = 0; i < n1; i++) {
				int in3 = Arrays.binarySearch(a3, a1[i]);
				if (in3 < 0) {
					int in4 = Arrays.binarySearch(a2, a1[i]);
					if (in4 > -1) {
						a[cnt] = a1[i];
						cnt++;
					}
				}
			}
		}
		Arrays.sort(a);
		StringBuffer sb = new StringBuffer();
		sb.append(cnt + "\n");
		for (int i = 0; i < max; i++) {
			if (a[i] > 0) {
				sb.append(a[i] + "\n");
			}
		}
		System.out.println(String.valueOf(sb).trim());
	}
	
}