package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

/**
 * Created by Shreyans on 1/31/2015 at 4:08 PM using IntelliJ IDEA (Fast IO Template)
 */

class LEDIV {
	public static void main(String[] args) throws Exception {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		boolean[] pr = SOE();
		int t = in.readInt();
		for (int i = 0; i < t; i++) {
			int n = in.readInt();
			int[] a = new int[n];
			int ap = 0;
			Set<Integer> hs = new HashSet<Integer>();
			for (int j = 0; j < n; j++) {
				a[j] = in.readInt();
				if (pr[a[j]]) {
					//System.out.println(a[j]);
					if (hs.size() == 0) {
						ap = a[j];
					}
					if (!hs.contains(a[j])) {
						hs.add(a[j]);
					}
				}
			}
			if (hs.size() > 1) {
				out.printLine("-1");
			} else if (hs.size() == 1) {
				int flagx = 1;
				for (int j = 0; j < n; j++) {
					if (a[j] % ap != 0) {
						//System.out.println(a[j]);
						flagx = 0;
						break;
					}
				}
				if (flagx == 1) {
					out.printLine(ap);
				} else {
					out.printLine("-1");
				}
			} else if (hs.size() == 0) {
				int k = a[0];
				for (int j = 1; j < n; j++) {
					k = GCD(k, a[j]);
					if (k == 1) {
						break;
					}
				}
				if (k > 1) {
					for (int j = 2; j <= Math.sqrt(k); j++) {
						if (pr[j] && k % j == 0) {
							k = j;
							break;
						}
					}
				} else {
					k = -1;
				}
				out.printLine(k);
			}
			out.flush();
		}
		
		{
			out.close();
		}
	}
	
	private static int GCD(int a1, int b1) {
		while (a1 % b1 != 0) {
			int r = a1 % b1;
			a1 = b1;
			b1 = r;
		}
		return (b1);
	}
	
	private static boolean[] SOE() {
		int max = 100001;
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
		
		public char readChar() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString().charAt(0);
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