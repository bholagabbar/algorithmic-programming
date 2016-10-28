package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TLG {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int in = Integer.parseInt(br.readLine());
		int max = 0, win = 0, p1 = 1, p2 = 2, s1 = 0, s2 = 0;
		for (int i = 0; i < in; i++) {
			String s = br.readLine();
			s1 += Integer.parseInt(s.substring(0, s.indexOf(' ')));
			s2 += Integer.parseInt(s.substring((s.indexOf(' ') + 1), s.length()));
			if ((s1 > s2) && ((s1 - s2) > max)) {
				
				max = s1 - s2;
				win = 1;
			} else if ((s2 > s1) && ((s2 - s1) > max)) {
				max = (s2 - s1);
				win = 2;
			}
			
		}
		if (win == 1) {
			
			System.out.print(p1 + " " + max);
			
		} else if (win == 2) {
			
			System.out.print(p2 + " " + max);
			
		}
	}
}
