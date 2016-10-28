import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/18/2015 using IntelliJ IDEA
 */

class FBHC_R1_PRIMALITY {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		boolean[] arr = SOE();
		for (int i = 0; i < t; i++) {
			String[] a1 = br.readLine().split(" ");
			int a = Integer.parseInt(a1[0]);
			int b = Integer.parseInt(a1[1]);
			long k1 = Long.parseLong(a1[2]);
			long cnt = 0;
			int ans = 0;
			if (k1 == 1) {
				for (int j = a; j <= b; j++) {
					if (!arr[j]) {
						for (int k = 2; k <= j / 2; k++) {
							if ((j % k == 0) && arr[k]) {
								//System.out.println("Primes for 5 15 with number " + j + " are " + k);
								cnt++;
							}
							if (cnt > 1) {
								break;
							}
						}
						if (cnt == 1) {
							ans++;
						}
					} else if (arr[j]) {
						ans++;
					}
					cnt = 0;
				}
			} else {
				for (int j = a; j <= b; j++) {
					if (!arr[j]) {
						if (((j / 2) * 2) == j) {
							if ((arr[j / 2])) {
								cnt++;
							}
						}
						for (int k = 2; k <= Math.sqrt(j); k++) {
							if ((j % k == 0) && arr[k]) {
								//System.out.println("Primes for 5 15 with number " + j + " are " + k);
								cnt++;
							}
							if (cnt > k1) {
								break;
							}
						}
						if (cnt == k1) {
							ans++;
						}
					}
					cnt = 0;
				}
			}
			
			
			for (int j = a; j <= b; j++) {
				if (!arr[j]) {
					for (int k = 2; k <= j / 2; k++) {
						if ((j % k == 0) && arr[k]) {
							//System.out.println("Primes for 5 15 with number " + j + " are " + k);
							cnt++;
						}
						if (cnt > k1) {
							break;
						}
					}
					if (cnt == k1) {
						ans++;
					}
				} else if (arr[j]) {
					cnt = 1;
					if (cnt == k1) {
						ans++;
					}
				}
				cnt = 0;
			}
			System.out.println("Case #" + (i + 1) + ": " + ans);
		}
	}
	
	public static boolean[] SOE() {
		int max = 10000001;
		final boolean[] primeCandidates = new boolean[max]; // defaults to false
		for (int i = 2; i < max; i++) {
			primeCandidates[i] = true;
		}
		
		final double maxRoot = Math.sqrt(max);
		for (int candidate = 2; candidate < maxRoot; candidate++) {
			if (primeCandidates[candidate]) {
				for (int j = 2 * candidate; j < max; j += candidate) {
					primeCandidates[j] = false;
				}
			}
			
		}
		return primeCandidates;
	}
}
 

