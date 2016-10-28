package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/16/2015 using IntelliJ IDEA
 */

class ALEXNUMB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			Long n = Long.parseLong(br.readLine());
			String[] s = br.readLine().split(" ");
			n--;
			System.out.println((n * (n + 1)) / 2);
		}
	}
}
 

