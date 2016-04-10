package CODECHEF.LONG_CHALLENGE.MAY15.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Created by Shreyans Sheth [bholagabbar] on 5/11/2015 at 6:53 PM using IntelliJ IDEA (Fast IO Template)
 */

//ADD PUBLIC FOR CF,TC
class DEVSTR {
	public static void main(String[] args) throws Exception {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int tc = in.readInt();
		while (tc-- > 0) {
			int n = in.readInt();
			int k = in.readInt();
			char[] s = in.readString().toCharArray();
			int cnt1 = 0, cnt0 = 0, flip = 0;
			if (k != 1) {
				for (int i = 0; i < n; i++) {
					if (s[i] == '0') {
						cnt0++;
						cnt1 = 0;
					} else {
						cnt1++;
						cnt0 = 0;
					}
					
					if (cnt0 == k + 1) {
						flip++;
						if ((i + 1) < n && s[i + 1] == '0') {
							s[i] = '1';
							cnt0 = 0;
						} else if ((i + 1) < n && s[i + 1] != '0') {
							s[i - 1] = '1';
							cnt0 = 1;
						} else if (i == n - 1) {
							s[i] = '1';
						}
					}
					
					if (cnt1 == k + 1) {
						flip++;
						if ((i + 1) < n && s[i + 1] == '1') {
							s[i] = '0';
							cnt1 = 0;
						} else if ((i + 1) < n && s[i + 1] != '1') {
							s[i - 1] = '0';
							cnt1 = 1;
						} else if (i == n - 1) {
							s[i] = '0';
						}
					}
				}
			} else {
				char[] s1 = Arrays.copyOf(s, s.length);
				int flipx = 1;
				if (s[0] == '1') {
					s1[0] = '0';
				} else {
					s1[0] = '1';
				}
				for (int i = 1; i < n; i++) {
					if (s[i] == s[i - 1]) {
						flip++;
						if (s[i - 1] == '1') {
							s[i] = '0';
						} else {
							s[i] = '1';
						}
					}
					
					if (s1[i] == s1[i - 1]) {
						flipx++;
						if (s1[i - 1] == '1') {
							s1[i] = '0';
						} else {
							s1[i] = '1';
						}
					}
				}
				if (flipx < flip) {
					s = Arrays.copyOf(s1, s.length);
					flip = flipx;
				}
			}
			out.printLine(flip);
			for (char x : s) {
				out.print(x);
			}
			out.printLine();
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