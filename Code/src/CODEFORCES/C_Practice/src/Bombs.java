package CODEFORCES.C_Practice.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;

/**
 * Created by Shreyans Sheth [bholagabbar] on 12/20/2015 at 1:00 AM using IntelliJ IDEA (Fast IO Template)
 */

public class Bombs {
	
	static class Pair {
		long x, y;
		
		Pair(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n = in.readInt();
		ArrayList<Pair> al = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			al.add(new Pair(in.readLong(), in.readLong()));
		}
		Collections.sort(al, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				long d1 = o1.x * o1.x + o1.y * o1.y, d2 = (o2.x * o2.x + o2.y * o2.y);
				return Long.compare(d1, d2);
			}
		});
		StringBuilder ans = new StringBuilder();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			StringBuilder later = new StringBuilder();
			long x = al.get(i).x, y = al.get(i).y;
			if (x != 0) {
				if (x < 0) {
					ans.append("1 " + Math.abs(x) + " L\n");
					later.append("1 " + Math.abs(x) + " R\n");
					cnt++;
				} else {
					ans.append("1 " + Math.abs(x) + " R\n");
					later.append("1 " + Math.abs(x) + " L\n");
					cnt++;
				}
			}
			if (y != 0) {
				if (y < 0) {
					ans.append("1 " + Math.abs(y) + " D\n");
					later.append("1 " + Math.abs(y) + " U\n");
					cnt++;
				} else {
					ans.append("1 " + Math.abs(y) + " U\n");
					later.append("1 " + Math.abs(y) + " D\n");
					cnt++;
				}
			}
			String[] toAdd = later.toString().split("\n");
			ans.append("2\n");
			cnt++;
			for (String add : toAdd) {
				ans.append(add.trim() + "\n");
				cnt++;
			}
			ans.append("3\n");
			cnt++;
		}
		out.printLine(cnt);
		out.printLine(ans.toString().trim());
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