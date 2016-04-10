package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class AMRIT13D {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a1 = br.readLine();
		BigInteger n = new BigInteger(a1);
		for (BigInteger i = n;
		     i.compareTo(BigInteger.ZERO) > 0;
		     i = i.subtract(BigInteger.ONE)) {
			String a2 = br.readLine();
			String a3 = br.readLine();
			BigInteger a = new BigInteger(a2);
			BigInteger b = new BigInteger(a3);
			BigInteger temp = new BigInteger(String.valueOf(a));
			BigInteger temp1 = new BigInteger(String.valueOf(b));
			BigInteger flag1 = new BigInteger("0");
			BigInteger flag2 = new BigInteger("0");
			BigInteger two = new BigInteger("2");
			BigInteger one = new BigInteger("1");
			while (temp.compareTo(temp1) != 0) {
				if (temp.compareTo(temp1) == 1) {
					temp = temp.divide(two);
				} else if (temp.compareTo(temp1) == -1) {
					temp1 = temp1.divide(two);
				} else if (temp.compareTo(temp1) == 0) {
					break;
				}
			}
			while (a.compareTo(temp) != 0) {
				flag1 = flag1.add(one);
				a = a.divide(two);
			}
			while (b.compareTo(temp) != 0) {
				flag2 = flag2.add(one);
				b = b.divide(two);
			}
			System.out.println(flag1.add(flag2));
		}
	}
}