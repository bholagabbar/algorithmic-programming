package CODECHEF.LONG_CHALLENGE.APRIL15.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

/**
 * Created by Shreyans on 4/4/2015 at 9:37 PM using IntelliJ IDEA (Fast IO Template)
 */

class CSEQ {
	public static void main(String[] args) throws Exception {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int p = 1000000 + 3;
		int t = in.readInt();
		for (int i = 0; i < t; i++) {
			int r = in.readInt();
			int a = in.readInt();
			int b = in.readInt();
			int n = (b - a + 1);
			long ans = (C(n + r, r, p) - 1) + p;//Formula is summation of[(n+r-1)C(r)] and +mod is for if value goes into -ve
			out.printLine(ans % p);
			out.flush();
		}
		{
			out.close();
		}
	}
	
	//Code for finding nCr mod p
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
		}
		
		public void printLine(Object... objects) {
			print(objects);
			writer.println();
		}
		
		public void close() {
			writer.close();
		}
		
		public void flush() {
			writer.flush();
		}
	}
}