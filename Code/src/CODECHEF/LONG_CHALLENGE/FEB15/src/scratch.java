package CODECHEF.LONG_CHALLENGE.FEB15.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

/**
 * Created by Shreyans on 2/12/2015 at 10:36 PM using IntelliJ IDEA (Fast IO Template)
 */

class scratch {
	public static void main(String[] args) throws Exception {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		char[] a = (in.readString()).toCharArray();
		int[][] c = new int[1000000][4];
		int[][] h = new int[1000000][4];
		int[][] e = new int[1000000][4];
		int[][] f = new int[1000000][4];
		int cc = 0, ch = 0, ce = 0, cf = 0;
		for (int j = a.length - 1; j >= 0; j--) {
			if (a[j] == 'h') {
				c[cc][1]++;
			} else if (a[j] == 'e') {
				c[cc][2]++;
			} else if (a[j] == 'f') {
				c[cc][3]++;
			} else {
				c[cc][0] = j;
				cc++;
				c[cc][1] = c[cc - 1][1];
				c[cc][2] = c[cc - 1][2];
				c[cc][3] = c[cc - 1][3];
			}
		}
		for (int j = a.length - 1; j >= 0; j--) {
			if (a[j] == 'e') {
				h[ch][1]++;
			} else if (a[j] == 'f') {
				h[ch][2]++;
			} else if (a[j] == 'c') {
				h[ch][3]++;
			} else {
				h[ch][0] = j;
				ch++;
				h[ch][1] = h[ch - 1][1];
				h[ch][2] = h[ch - 1][2];
				h[ch][3] = h[ch - 1][3];
			}
		}
		for (int j = a.length - 1; j >= 0; j--) {
			if (a[j] == 'f') {
				e[ce][1]++;
			} else if (a[j] == 'c') {
				e[ce][2]++;
			} else if (a[j] == 'h') {
				e[ce][3]++;
			}
			//else
			{
				e[ce][0] = j;
				ce++;
				e[ce][1] = e[ce - 1][1];
				e[ce][2] = e[ce - 1][2];
				e[ce][3] = e[ce - 1][3];
			}
		}
		for (int j = a.length - 1; j >= 0; j--) {
			if (a[j] == 'c') {
				f[cf][1]++;
			} else if (a[j] == 'h') {
				f[cf][2]++;
			} else if (a[j] == 'e') {
				f[cf][3]++;
			} else {
				f[cf][0] = j;
				cf++;
				f[cf][1] = f[cf - 1][1];
				f[cf][2] = f[cf - 1][2];
				f[cf][3] = f[cf - 1][3];
			}
		}
		int t = in.readInt();
		for (int i = 0; i < t; i++) {
			char a1 = in.readString().charAt(0);
			char a2 = in.readString().charAt(0);
			int n1 = in.readInt();
			int n2 = in.readInt();
			if (a1 == 'c') {
				int x = 0;
				if (a2 == 'h') {
					x = 1;
				} else if (a2 == 'e') {
					x = 2;
				} else if (a2 == 'f') {
					x = 3;
				}
				n1--;
				n2--;
				long ans = c[n2][x] - c[n1][x];
				System.out.println(ans);
			}
			if (a1 == 'h') {
				int x = 0;
				if (a2 == 'e') {
					x = 1;
				} else if (a2 == 'f') {
					x = 2;
				} else if (a2 == 'c') {
					x = 3;
				}
				n1--;
				n2--;
				long ans = 0;
				for (int j = ch - 1; j >= 0; j--) {
					if (h[j][0] >= n1 && h[j][0] < n2) {
						ans += h[j][x];
					}
				}
				System.out.println(ans);
			}
			if (a1 == 'e') {
				int x = 0;
				if (a2 == 'f') {
					x = 1;
				} else if (a2 == 'c') {
					x = 2;
				} else if (a2 == 'h') {
					x = 3;
				}
				n1--;
				n2--;
				long ans = 0;
				for (int j = ce - 1; j >= 0; j--) {
					if (e[j][0] >= n1 && e[j][0] < n2) {
						ans += e[j][x];
					}
				}
				System.out.println(ans);
			}
			if (a1 == 'f') {
				int x = 0;
				if (a2 == 'c') {
					x = 1;
				} else if (a2 == 'h') {
					x = 2;
				} else if (a2 == 'e') {
					x = 3;
				}
				n1--;
				n2--;
				long ans = 0;
				for (int j = cf - 1; j >= 0; j--) {
					if (f[j][0] >= n1 && f[j][0] < n2) {
						if (c[j][0] >= n1 && c[j][0] < n2) {
							ans += f[j][x];
						}
					}
				}
				System.out.println(ans);
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