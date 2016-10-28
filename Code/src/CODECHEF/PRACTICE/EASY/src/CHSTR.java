package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by Shreyans Sheth [bholagabbar] on 7/21/2015 at 1:05 PM using IntelliJ IDEA (Fast IO Template)
 */

class CHSTR {
	static List<ArrayList<Long>> COMB = new ArrayList<ArrayList<Long>>(4001);
	static int M = 1000000009;
	
	public static void COMBINATIONS() {
		long ONE = 1;
		for (int i = 0; i <= 3000; i++) {
			COMB.add(new ArrayList<Long>(i + 1));
			for (int k = 0; k <= i; k++) {
				if (k == 0 || k == i) {
					COMB.get(i).add(ONE);
				} else {
					COMB.get(i).add((COMB.get(i - 1).get(k - 1) + COMB.get(i - 1).get(k)) % M);
				}
			}
		}
	}
	
	private static long POW(long a, long b, long MOD) {
		long x = 1, y = a;
		while (b > 0) {
			if (b % 2 == 1) {
				x = x * y;
				if (x > MOD) {
					x %= MOD;
				}
			}
			y = y * y;
			if (y > MOD) {
				y %= MOD;
			}
			b /= 2;
		}
		return x;
	}
	
	private static long InverseEuler(long n, long MOD) {
		return (POW(n, MOD - 2, MOD));
	}
	
	private static int countFact(int n, int p) {
		int k = 0;
		while (n >= p) {
			k += n / p;
			n /= p;
		}
		return k;
	}
	
	private static long C(int n, int r, int MOD) {
		if (countFact(n, MOD) > countFact(r, MOD) + countFact(n - r, MOD)) {
			return 0;
		}
		
		return (factMOD(n, MOD) *
				((InverseEuler(factMOD(r, MOD), MOD) *
						InverseEuler(factMOD(n - r, MOD), MOD)) % MOD)) % MOD;
	}
	
	private static long factMOD(int n, int MOD) {
		long res = 1;
		while (n > 0) {
			for (int i = 2, m = n % MOD; i <= m; i++) {
				res = (res * i) % MOD;
			}
			if ((n /= MOD) % 2 > 0) {
				res = MOD - res;
			}
		}
		return res;
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		COMBINATIONS();
		int tc = in.readInt();
		while (tc-- > 0) {
			int n = in.readInt(), m = in.readInt();
			String x = in.readString();
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			for (int i = 0; i < x.length(); i++) {
				for (int j = i; j < x.length(); j++) {
					String y = x.substring(i, j + 1);
					if (!hm.containsKey(y)) {
						hm.put(y, 1);
					} else {
						hm.put(y, hm.get(y) + 1);
					}
				}
			}
			int[] cnt = new int[n + 1];
			for (String y : hm.keySet()) {
				cnt[hm.get(y)]++;
			}
			for (int i = 0; i < m; i++) {
				int k = in.readInt();
				long ans = 0;
				for (int j = k; j <= n; j++) {
					if (j > 3000) {
						ans = (ans + (cnt[j] * C(j, k, M))) % M;
					} else {
						ans = (ans + (cnt[j] * COMB.get(j).get(k))) % M;
					}
				}
				out.printLine(ans);
			}
		}
		
		{
			out.close();
		}
	}
	
	//FAST IO
	private static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
		
		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}
		
		public int readInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		
		public String readString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
		
		public double readDouble() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, readInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E') {
						return res * Math.pow(10, readInt());
					}
					if (c < '0' || c > '9') {
						throw new InputMismatchException();
					}
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		
		public long readLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		
		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
		
		public String next() {
			return readString();
		}
		
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
	
	private static class OutputWriter {
		private final PrintWriter writer;
		
		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}
		
		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}
		
		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0) {
					writer.print(' ');
				}
				writer.print(objects[i]);
			}
			writer.flush();
		}
		
		public void printLine(Object... objects) {
			print(objects);
			writer.println();
			writer.flush();
		}
		
		public void close() {
			writer.close();
		}
		
		public void flush() {
			writer.flush();
		}
	}
}