package SPOJ.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shreyans Sheth [bholagabbar] on 9/18/2015 at 3:04 AM using IntelliJ IDEA (Fast IO Template)
 */

class HERDING {
	static class Node {
		int c1, c2;
		
		Node(int c1, int c2)//current char, coords
		{
			this.c1 = c1;
			this.c2 = c2;
		}
	}
	
	static char[][] grid;
	static boolean[][] vis;
	static int[][] num;
	static int r, c;
	static int[] p;
	
	static int Find(int x) {
		if (p[p[x]] != x) {
			p[x] = Find(p[x]);
		}
		return p[x];
	}
	
	static void Union(int x, int y) {
		int px = Find(x), py = Find(y);
		p[px] = py;
	}
	
	static void BFS(int x1, int y1, int cnt) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x1, y1));
		vis[x1][y1] = true;
		num[x1][y1] = cnt;
		int x, y;
		while (!q.isEmpty()) {
			Node X = q.poll();
			int c1 = X.c1;
			int c2 = X.c2;
			if (grid[c1][c2] == 'E') {
				x = 0;
				y = 1;
			} else if (grid[c1][c2] == 'W') {
				x = 0;
				y = -1;
			} else if (grid[c1][c2] == 'N') {
				x = -1;
				y = 0;
			} else {
				x = 1;
				y = 0;
			}
			if (c1 + x >= 0 && c1 + x < r && c2 + y >= 0 && c2 + y < c && !vis[c1 + x][c2 + y]) {
				q.add(new Node(c1 + x, c2 + y));
				vis[c1 + x][c2 + y] = true;
				num[c1 + x][c2 + y] = cnt;
			} else if (c1 + x >= 0 && c1 + x < r && c2 + y >= 0 && c2 + y < c && vis[c1 + x][c2 + y]) {
				Union(num[x1][y1], num[c1 + x][c2 + y]);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		r = in.readInt();
		c = in.readInt();
		grid = new char[r][c];
		vis = new boolean[r][c];
		num = new int[r][c];
		p = new int[r * c];
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}
		for (int i = 0; i < r; i++) {
			String s = in.readString();
			s = s.trim();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) != ' ') {
					grid[i][j] = s.charAt(j);
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!vis[i][j]) {
					BFS(i, j, cnt++);
				}
			}
		}
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				hs.add(Find(num[i][j]));
			}
		}
		out.printLine(hs.size());
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