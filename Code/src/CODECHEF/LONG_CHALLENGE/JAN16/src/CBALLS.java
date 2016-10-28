package CODECHEF.LONG_CHALLENGE.JAN16.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.InputMismatchException;

/**
 * Created by Shreyans Sheth [bholagabbar] on 1/6/2016 at 1:18 PM using IntelliJ IDEA (Fast IO Template)
 */

class CBALLS {
	
	static int sz = 100001;
	static int[] prime = new int[sz];
	
	static void primeFactorSieve() {
		for (int i = 1; i < sz; i++) {
			prime[i] = i;
		}
		for (int i = 2; i * i < sz; i++) {
			if (prime[i] == i) {
				for (int j = i * i; j < sz; j += i) {
					prime[j] = i;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		primeFactorSieve();
		int tc = in.readInt();
		while (tc-- > 0) {
			int n = in.readInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.readInt();
			}
			HashSet<Integer> primeFactors = new HashSet<Integer>();
			for (int i = 0; i < n; i++) {
				int curr = a[i];
				while (curr > prime[curr]) {
					primeFactors.add(prime[curr]);
					curr /= prime[curr];
				}
				primeFactors.add(curr);
			}
			primeFactors.remove(0);
			primeFactors.remove(1);
			primeFactors.add(2);
			int min = Integer.MAX_VALUE;
			for (int currPrime : primeFactors) {
				int toAdd = 0;
				int prev;
				if (a[0] < currPrime) {
					toAdd += currPrime - a[0];
					prev = currPrime;
				} else {
					prev = a[0];
					if (a[0] % currPrime != 0) {
						int factor = a[0] / currPrime;
						prev = currPrime * (factor + 1);
					}
					toAdd += prev - a[0];
				}
				for (int i = 1; i < n; i++) {
					if (toAdd > min) {
						break;
					}
					int currValue = a[i];
					if (currValue < prev) {
						toAdd += prev - currValue;
						currValue = prev;
					}
					int was = currValue;
					if (currValue % currPrime != 0) {
						int factor = currValue / currPrime;
						currValue = currPrime * (factor + 1);
					}
					toAdd += currValue - was;
					prev = currValue;
				}
				min = Math.min(min, toAdd);
			}
			out.printLine(min);
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