package SPOJ.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shreyans on 3/29/2015 at 3:24 AM using IntelliJ IDEA (Fast IO Template)
 */

class LASTDIG {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] s1 = br.readLine().split(" ");
			long a = Long.parseLong(s1[0]);
			long b = Long.parseLong(s1[1]);
			if (a == 0) {
				pw.println("0");
			} else if (b == 0) {
				pw.println("1");
			} else {
				List<Character> al = new ArrayList<Character>();
				for (int j = 1; ; j++) {
					long x = (long) Math.pow(a, j);
					char ch = Long.toString(x).charAt(Long.toString(x).length() - 1);
					if (!al.contains(ch)) {
						al.add(ch);
					} else {
						break;
					}
				}
				long x = b % al.size();
				if (x == 0) {
					pw.println(al.get(al.size() - 1));
				} else {
					pw.println(al.get((int) x - 1));
				}
			}
		}
		pw.close();
	}
}