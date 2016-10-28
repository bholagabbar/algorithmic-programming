package CODEFORCES.C_Practice.src;

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
 * Created by Shreyans Sheth [bholagabbar] on 12/15/2015 at 12:32 PM using IntelliJ IDEA (Fast IO Template)
 */

public class GagariAndBishop {
	
	static long[][][] dp;
	
	private static class Tuple {
		int x, y;
		long tot;
		
		Tuple(int x, int y, long tot) {
			this.x = x;
			this.y = y;
			this.tot = tot;
		}
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n = in.readInt();
		dp = new long[n][n][5];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j][0] = in.readLong();
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j - 1 >= 0) {
					dp[i][j][1] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1];
				}
				if (j + 1 < n) {
					dp[i][j][2] += dp[i - 1][j + 1][0] + dp[i - 1][j + 1][2];
				}
			}
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (j + 1 < n) {
					dp[i][j][3] += dp[i + 1][j + 1][0] + dp[i + 1][j + 1][3];
				}
				if (j - 1 >= 0) {
					dp[i][j][4] += dp[i + 1][j - 1][0] + dp[i + 1][j - 1][4];
				}
			}
		}
		Tuple even = new Tuple(0, 0, -1), odd = new Tuple(0, 0, -1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				long curr = Arrays.stream(dp[i][j]).sum();
				Tuple ins = new Tuple(i + 1, j + 1, curr);
				if ((i + 1 + j + 1) % 2 == 0) {
					if (curr > even.tot) {
						even = (ins);
					}
				} else {
					if (curr > odd.tot) {
						odd = (ins);
					}
				}
			}
		}
		out.printLine(even.tot + odd.tot);
		out.printLine(even.x + " " + even.y + " " + odd.x + " " + odd.y);
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