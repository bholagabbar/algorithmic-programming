package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/30/2015 using IntelliJ IDEA
 */

class PLZLYKME {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < t; i++) {
			String x[] = br.readLine().split(" ");
			long l = Long.parseLong(x[0]);
			long d = Long.parseLong(x[1]);
			long s = Long.parseLong(x[2]);
			long c = Long.parseLong(x[3]);
			long sum = s;
			if (sum >= l) {
				sb.append("ALIVE AND KICKING\n");
			} else {
				int flag = 0;
				for (int j = 1; j < d; j++) {
					sum = sum + (sum * c);
					if (sum >= l) {
						flag = 1;
						break;
					}
				}
				if (flag == 1) {
					sb.append("ALIVE AND KICKING\n");
				} else {
					sb.append("DEAD AND ROTTING\n");
				}
			}
		}
		System.out.println(sb);
	}
}


