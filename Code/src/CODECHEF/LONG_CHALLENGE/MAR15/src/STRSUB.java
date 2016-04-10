package CODECHEF.LONG_CHALLENGE.MAR15.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

/**
 * Created by Shreyans on 3/6/2015 at 6:36 PM using IntelliJ IDEA (Fast IO Template)
 */

class STRSUB {
	public static void main(String[] args) throws Exception {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int t = in.readInt();
		for (int i = 0; i < t; i++) {
			int n = in.readInt();
			int k1 = in.readInt();
			int q = in.readInt();
			char[] s = in.readString().toCharArray();
			int[][] a = new int[n][n];
			for (int j = 0; j < n; j++) {
				int cnt0 = 0, cnt1 = 0, cnt = 0, x = 0;
				String s1 = "";
				for (int k = j, c1 = j; k < n; k++) {
					s1 += s[k];
					if (s[k] == '1') {
						cnt1++;
						cnt++;
					} else {
						cnt0++;
						cnt++;
					}
					if (cnt1 <= k1 && cnt0 <= k1) {
						if (k == 0) {
							a[j][k] = cnt;
							//x++;
						} else {
							a[j][k] = a[j][k - 1] + cnt;
							k++;
						}
					} else {
						{
							System.out.println(s1);
						}
						cnt1 = 0;
						cnt0 = 0;
						StringBuffer sb = new StringBuffer();
						for (int l = s1.length() - 1; l >= k; l--) {
							if (s1.charAt(l) == '1') {
								cnt1++;
								sb.append(s1.charAt(l));
							} else {
								cnt0++;
								sb.append(s1.charAt(l));
							}
							if (cnt1 > k1 || cnt0 > k1) {
								cnt = s1.length() - (l + 1);
								k = l;
								if (cnt1 > k1) {
									cnt1 = k;
								} else {
									cnt0 = k1;
								}
								break;
							}
						}
						s1 = String.valueOf(sb.reverse());
						a[j][x] = a[j][x - 1] + cnt;
						x++;
					}
				}
			}
			for (int j = 0; j < q; j++) {
				int a1 = in.readInt() - 1;
				int b1 = in.readInt() - 1;
				out.printLine(a[a1][b1]);
				out.flush();
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