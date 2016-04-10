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
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shreyans Sheth [bholagabbar] on 1/6/2016 at 1:28 PM using IntelliJ IDEA (Fast IO Template)
 */

class DEVPERF {
	
	static final int N = 1001;
	
	static char grid[][] = new char[N][N];
	static int dx[] = {1, -1, 0, 0, -1, -1, 1, 1};
	static int dy[] = {0, 0, 1, -1, -1, 1, 1, -1};
	static int dist[][] = new int[N][N];
	
	static class Pair {
		int first, second;
		
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	
	static int getMaxTimeUsingBFS(int s1, int s2, int r, int c) {
		boolean vis[][] = new boolean[r + 1][c + 1];
		dist[s1][s2] = 1;
		vis[s1][s2] = true;
		int maxDistance = 1;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(s1, s2));
		while (!q.isEmpty()) {
			Pair curr = q.poll();
			int c1 = curr.first;
			int c2 = curr.second;
			int currentDistance = dist[c1][c2];
			if (grid[c1][c2] == '*') {
				maxDistance = Math.max(maxDistance, currentDistance);
			}
			for (int i = 0; i < 8; i++) {
				if (c1 + dx[i] >= 1 && c1 + dx[i] <= r && c2 + dy[i] >= 1 && c2 + dy[i] <= c && !vis[c1 + dx[i]][c2 + dy[i]]) {
					q.add(new Pair(c1 + dx[i], c2 + dy[i]));
					vis[c1 + dx[i]][c2 + dy[i]] = true;
					dist[c1 + dx[i]][c2 + dy[i]] = currentDistance + 1;
				}
			}
		}
		return maxDistance;
	}
	
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int tc = in.readInt();
		while (tc-- > -0) {
			int r = in.readInt();
			int c = in.readInt();
			int minR = Integer.MAX_VALUE, maxR = Integer.MIN_VALUE, minC = Integer.MAX_VALUE, maxC = Integer.MIN_VALUE;
			String enterRow;
			
			for (int i = 1; i <= r; i++) {
				enterRow = in.readString();
				for (int j = 1; j <= c; j++) {
					grid[i][j] = enterRow.charAt(j - 1);
					if (grid[i][j] == '*') {
						minR = Math.min(minR, i);
						maxR = Math.max(maxR, i);
						minC = Math.min(minC, j);
						maxC = Math.max(maxC, j);
					}
				}
			}
			
			if (minR == Integer.MAX_VALUE) {
				out.printLine("0");
				continue;
			}
			
			HashSet<Pair> possibleMidpoints = new HashSet<Pair>();
			possibleMidpoints.add(new Pair((int) Math.ceil(((minR + maxR) / 2.0)), (int) Math.ceil((((minC + maxC) / 2.0)))));
			possibleMidpoints.add(new Pair((int) Math.floor(((minR + maxR) / 2.0)), (int) Math.ceil((((minC + maxC) / 2.0)))));
			possibleMidpoints.add(new Pair((int) Math.ceil(((minR + maxR) / 2.0)), (int) Math.floor((((minC + maxC) / 2.0)))));
			possibleMidpoints.add(new Pair((int) Math.floor(((minR + maxR) / 2.0)), (int) Math.floor((((minC + maxC) / 2.0)))));
			
			int min = Integer.MAX_VALUE;
			for (Pair toCheck : possibleMidpoints) {
				min = Math.min(min, getMaxTimeUsingBFS(toCheck.first, toCheck.second, r, c));
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