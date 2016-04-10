package SPOJ.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shreyans Sheth [bholagabbar] on 9/4/2015 at 12:35 AM using IntelliJ IDEA (Fast IO Template)
 */

class ABCPATH {
	
	static class Node {
		char cur;
		int cnt, c1, c2;
		
		Node(char cur, int c1, int c2, int cnt)//current char, coords, cnt
		{
			this.cur = cur;
			this.c1 = c1;
			this.c2 = c2;
			this.cnt = cnt;
		}
	}
	
	static char[][] grid;
	static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};
	
	static int BFS(int s1, int s2, int r, int c) {
		boolean[][] vis = new boolean[100][100];
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(grid[s1][s2], s1, s2, 1));
		int ma = 1;
		while (!q.isEmpty()) {
			Node x = q.poll();
			int c1 = x.c1;
			int c2 = x.c2;
			int ccnt = x.cnt;
			char cchar = x.cur;
			char nchar = (char) (cchar + 1);
			ma = Math.max(ma, ccnt);
			for (int i = 0; i < 8; i++) {
				if (c1 + dx[i] > 0 && c1 + dx[i] <= r && c2 + dy[i] > 0 && c2 + dy[i] <= c && !vis[c1 + dx[i]][c2 + dy[i]] && grid[c1 + dx[i]][c2 + dy[i]] == nchar) {
					q.add(new Node(nchar, c1 + dx[i], c2 + dy[i], ccnt + 1));
					vis[c1 + dx[i]][c2 + dy[i]] = true;
				}
			}
		}
		return ma;
	}
	
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int r = in.readInt(), c = in.readInt();
		int cnt = 1;
		while (r != 0 && c != 0) {
			grid = new char[r + 1][c + 1];
			for (int i = 1; i <= r; i++) {
				String nl = in.readString();
				for (int j = 1; j <= c; j++) {
					grid[i][j] = nl.charAt(j - 1);
				}
			}
			int max = 0;
			for (int i = 1; i <= r; i++) {
				for (int j = 1; j <= c; j++) {
					if (grid[i][j] == 'A')//No intermediate node can be used as start node
					{
						max = Math.max(max, BFS(i, j, r, c));
					}
				}
			}
			out.printLine("Case " + (cnt++) + ": " + max);
			r = in.readInt();
			c = in.readInt();
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