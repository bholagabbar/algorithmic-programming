package CODECHEF.LONG_CHALLENGE.NOV15.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by Shreyans Sheth [bholagabbar] on 11/11/2015 at 11:49 PM using IntelliJ IDEA (Fast IO Template)
 */

class RECRECOV {
	
	//Credits:
	//http://stackoverflow.com/questions/10303800/minimum-number-of-days-required-to-solve-a-list-of-questions/10304235#10304235
	//http://stackoverflow.com/questions/10783473/minimum-path-cover-in-directed-acyclic-graph?lq=1
	//http://armanboyaci.com/?p=272
	//Code understood and taken from: http://zobayer.blogspot.in/2010/05/maximum-matching-with-dfs.html
	
	static final int lim = 101;
	static List<ArrayList<Integer>> graph;
	static boolean[] vis = new boolean[lim];
	static int[] leftBipartite = new int[lim], rightBipartite = new int[lim];
	
	static boolean DFS(int u) {
		if (vis[u]) {
			return false;
		}
		vis[u] = true;
		int len = graph.get(u).size(), i, v;
		for (i = 0; i < len; i++) {
			v = graph.get(u).get(i);
			if (rightBipartite[v] == -1) {
				rightBipartite[v] = u;
				leftBipartite[u] = v;
				return true;
			}
		}
		for (i = 0; i < len; i++) {
			v = graph.get(u).get(i);
			if (DFS(rightBipartite[v])) {
				rightBipartite[v] = u;
				leftBipartite[u] = v;
				return true;
			}
		}
		return false;
	}
	
	static int maxBipartiteMatch() {
		Arrays.fill(leftBipartite, -1);
		Arrays.fill(rightBipartite, -1);
		int i, ans = 0;
		boolean done;
		do {
			done = true;
			Arrays.fill(vis, false);
			for (i = 0; i < lim; i++) {
				if (leftBipartite[i] == -1 && DFS(i)) {
					done = false;
				}
			}
		}
		while (!done);
		for (i = 0; i < lim; i++) {
			if (leftBipartite[i] != -1) {
				ans++;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int tc = in.readInt();
		while (tc-- > 0) {
			int n = in.readInt(), m = in.readInt();
			graph = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < lim; i++) {
				graph.add(new ArrayList<Integer>());
			}
			for (int i = 0; i < m; i++) {
				graph.get(in.readInt()).add(in.readInt());
			}
			out.printLine(n - maxBipartiteMatch());
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