package CODEFORCES.DIV2_314.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;

/**
 * Created by Shreyans Sheth [bholagabbar] on 8/5/2015 at 9:21 PM using IntelliJ IDEA (Fast IO Template)
 */

public class C {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n = in.readInt();
		int k = in.readInt();
		int[] a = new int[n];
		if (k > 1) {
			HashMap<Integer, Integer> val = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> ran = new HashMap<Integer, Integer>();
			HashSet<Integer> hs = new HashSet<Integer>();
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				a[i] = in.readInt();
				if (a[i] % k != 0) {
					if (!ran.containsKey(a[i])) {
						ran.put(a[i], 1);
					} else {
						ran.put(a[i], ran.get(a[i]) + 1);
					}
				} else {
					int x = a[i] / k;
					if (x % k != 0) {
						if (!val.containsKey(a[i])) {
							if (ran.containsKey(x)) {
								val.put(a[i], ran.get(x));
							} else {
								val.put(a[i], 0);
							}
						} else if (ran.containsKey(x)) {
							val.put(a[i], val.get(a[i]) + ran.get(x));
						}
					} else {
						int kcnt = 0;
						if (val.containsKey(x)) {
							kcnt += val.get(x);
						}
						if (val.containsKey(a[i])) {
							val.put(a[i], val.get(a[i]) + kcnt);
						} else {
							val.put(a[i], kcnt);
						}
						hs.add(a[i]);
					}
				}
			}
			for (int x : hs) {
				cnt += val.get(x);
			}
			out.printLine(cnt);
		} else {
			HashMap<Integer, Integer> C = new HashMap<Integer, Integer>();
			for (int i = 0; i < n; i++) {
				a[i] = in.readInt();
				if (!C.containsKey(a[i])) {
					C.put(a[i], 1);
				} else {
					C.put(a[i], C.get(a[i]) + 1);
				}
			}
			int cnt = 0;
			for (int x : C.keySet()) {
				int y = C.get(x);
				cnt += ((y - 2) * (y - 1) * y) / 6;
			}
			out.printLine(cnt);
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