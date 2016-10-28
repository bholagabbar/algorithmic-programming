package CODECHEF.COOK_OFFS.COOK63.src;

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
 * Created by Shreyans Sheth [bholagabbar] on 10/18/2015 at 9:59 PM using IntelliJ IDEA (Fast IO Template)
 */

class STEM {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int t = in.readInt();
		while (t-- > 0) {
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			int n = in.readInt();
			for (int q = 0; q < n; q++) {
				String x = in.readString();
				HashSet<String> hs = new HashSet<String>();
				for (int i = 0; i < x.length(); i++) {
					String y = Character.toString(x.charAt(i));
					hs.add(y);
					for (int j = i + 1; j < x.length(); j++) {
						y += x.charAt(j);
						hs.add(y);
					}
				}
				for (String x1 : hs) {
					if (!hm.containsKey(x1)) {
						hm.put(x1, 1);
					} else {
						hm.put(x1, hm.get(x1) + 1);
					}
				}
			}
			String ans = "";
			for (String i : hm.keySet()) {
				if (hm.get(i) == n && ((i.length() > ans.length()) || (i.length() == ans.length() && i.compareTo(ans) < 0))) {
					ans = i;
				}
			}
			out.printLine(ans.trim());
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