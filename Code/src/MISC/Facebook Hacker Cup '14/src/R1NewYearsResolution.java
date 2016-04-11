import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/11/2015 using IntelliJ IDEA
 */

class R1NewYearsResolution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String ans = "Case #" + (i + 1) + ": ";
			String a1[] = br.readLine().split(" ");
			int nu[] = new int[3];
			nu[0] = Integer.parseInt(a1[0]);
			nu[1] = Integer.parseInt(a1[1]);
			nu[2] = Integer.parseInt(a1[2]);
			int x = Integer.parseInt(br.readLine());
			int[][] a = new int[x][3];
			for (int j = 0; j < x; j++) {
				String[] a2 = br.readLine().split(" ");
				a[j][0] = Integer.parseInt(a2[0]);
				a[j][1] = Integer.parseInt(a2[1]);
				a[j][2] = Integer.parseInt(a2[2]);
			}
			int flag = 0;
			for (int j = 1; j < Math.pow(2, x); j++) {
				int sum1 = 0;
				int sum2 = 0;
				int sum3 = 0;
				for (int k = 0; k < x; k++) {
					if ((j & (1 << k)) > 0) {
						sum1 += a[k][0];
						sum2 += a[k][1];
						sum3 += a[k][2];
					}
				}
				if (sum1 == nu[0] && sum2 == nu[1] && sum3 == nu[2]) {
					ans += "yes";
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				ans += "no";
			}
			System.out.println(ans);
		}
	}
}


