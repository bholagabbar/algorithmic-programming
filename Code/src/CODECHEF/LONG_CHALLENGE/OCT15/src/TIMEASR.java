package CODECHEF.LONG_CHALLENGE.OCT15.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.TreeSet;

/**
 * Created by Shreyans Sheth [bholagabbar] on 10/9/2015 at 8:12 PM using IntelliJ IDEA (Fast IO Template)
 */

class TIMEASR {
	
	static class Pair<T1, T2> {
		T1 f;
		T2 s;
		
		Pair(T1 f, T2 s) {
			this.f = f;
			this.s = s;
		}
	}
	
	@SuppressWarnings("unchecked")
	static Pair<Double, Pair<Integer, Integer>>[] time = new Pair[720];
	
	static void PreCalc() {
		double h = 0, m = 0;
		int ind = 0;
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 60; j++) {
				double ang = Math.abs(m - (0.5 * (double) j));
				if (ang > 180) {
					ang = 360 - ang;
				}
				time[ind++] = new Pair<Double, Pair<Integer, Integer>>(ang, new Pair<Integer, Integer>(i, j));
				m += 6;
			}
			m = (h -= 30);
		}
		Arrays.sort(time, new Comparator<Pair<Double, Pair<Integer, Integer>>>() {
			@Override
			public int compare(Pair<Double, Pair<Integer, Integer>> o1, Pair<Double, Pair<Integer, Integer>> o2) {
				return o1.f.compareTo(o2.f);
			}
		});
	}
	
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		PreCalc();
		int tc = in.readInt();
		while (tc-- > 0) {
			double n = in.readDouble();
			int d = 0;
			while ((n - time[d].f) > (1 / 120.0)) {
				d++;
			}
			TreeSet<String> ans = new TreeSet<String>();
			while (d != time.length && (time[d].f - n) < (1 / 120.0)) {
				String h = Integer.toString(time[d].s.f);
				String m = Integer.toString(time[d++].s.s);
				if (h.length() < 2) {
					h = "0" + h;
				}
				if (m.length() < 2) {
					m = "0" + m;
				}
				String ct = h + ":" + m;
				ans.add(ct);
			}
			for (String i : ans) {
				out.printLine(i);
			}
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