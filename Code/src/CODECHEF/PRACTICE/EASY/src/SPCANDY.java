package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/6/2015 using IntelliJ IDEA
 */

class SPCANDY {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] a = br.readLine().split(" ");
			if (a[0].equals("0")) {
				System.out.println("0 0");
			} else if (!a[0].equals("0") && a[1].equals("0")) {
				System.out.println("0 " + a[0]);
			} else if (!a[0].equals("0") && !a[1].equals("0")) {
				Long a1 = Long.parseLong(a[0]) / Long.parseLong(a[1]);
				Long a2 = Long.parseLong(a[0]) % Long.parseLong(a[1]);
				System.out.println(a1 + " " + a2);
			}
		}
	}
}
 

