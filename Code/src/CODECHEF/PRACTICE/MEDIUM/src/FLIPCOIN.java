package CODECHEF.PRACTICE.MEDIUM.src;

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
 * Created by Shreyans Sheth [bholagabbar] on 6/3/2015 at 1:13 PM using IntelliJ IDEA (Fast IO Template)
 */


class FLIPCOIN {
	static boolean[] lazy = new boolean[100003 << 2];
	static int[] SegTree = new int[100003 << 2];
	
	public static void BuildSegTree() {
		Arrays.fill(SegTree, 0);//built up SegTree
		Arrays.fill(lazy, false);
	}
	
	public static void update(int node, int i, int j, int a, int b) {
		if (lazy[node]) {
			SegTree[node] = (j - i + 1) - SegTree[node];
			if (i != j) {
				lazy[2 * node] = !lazy[2 * node];
				lazy[2 * node + 1] = !lazy[2 * node + 1];
			}
			lazy[node] = false;
		}
		if (a > j || b < i) {
			return;
		}
		
		if (i >= a && j <= b) {
			SegTree[node] = (j - i + 1) - SegTree[node];
			if (i != j) {
				lazy[2 * node] = !lazy[2 * node];
				lazy[2 * node + 1] = !lazy[2 * node + 1];
			}
			return;
		}
		update(2 * node, i, (i + j) >> 1, a, b);
		update(2 * node + 1, ((i + j) >> 1) + 1, j, a, b);
		
		SegTree[node] = SegTree[2 * node] + SegTree[2 * node + 1];
	}
	
	public static int RSUMQ(int node, int i, int j, int a, int b) {
		if (a > j || b < i) {
			return 0;
		}
		
		if (lazy[node]) {
			SegTree[node] = (j - i + 1) - SegTree[node];
			if (i != j) {
				lazy[2 * node] = !lazy[2 * node];
				lazy[2 * node + 1] = !lazy[2 * node + 1];
			}
			lazy[node] = false;
		}
		
		if (i >= a && j <= b) {
			return SegTree[node];
		}
		
		int x = RSUMQ(2 * node, i, (i + j) >> 1, a, b);
		int y = RSUMQ(2 * node + 1, ((i + j) >> 1) + 1, j, a, b);
		return x + y;
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n = in.readInt(), m = in.readInt();
		
		BuildSegTree();
		
		for (int i = 0; i < m; i++) {
			int q = in.readInt();
			int x = in.readInt();
			int y = in.readInt();
			
			if (q == 0) {
				update(1, 0, n - 1, x, y);
			} else if (q == 1) {
				out.printLine(RSUMQ(1, 0, n - 1, x, y));
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