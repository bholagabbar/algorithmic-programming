package CODECHEF.LONG_CHALLENGE.JAN16.src;

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
 * Created by Shreyans Sheth [bholagabbar] on 1/10/2016 at 4:42 PM using IntelliJ IDEA (Fast IO Template)
 */

class SEAKAM {
	
	static long[] fact = new long[100001];
	static long MOD = (long) (1e9 + 7);
	static boolean[][] keepPair = new boolean[(1 << 7) + 1][7];
	static int[][] badEdges = new int[7][2];
	static int[] vertexHash = new int[100001];
	
	static class disjointSetUnion {
		static int[] u;
		static int[] rank;
		
		disjointSetUnion(int n) {
			u = new int[n + 1];
			rank = new int[n + 1];
			for (int i = 1; i <= 14; i++) {
				u[i] = i;
			}
		}
		
		public int Find(int x) {
			if (u[x] != u[u[x]]) {
				u[x] = Find(u[x]);
			}
			return u[x];
		}
		
		public boolean Union(int x, int y) {
			int px = Find(x);
			int py = Find(y);
			if (px == py) {
				return false;
			}
			if (rank[px] > rank[py]) {
				int temp = px;
				px = py;
				py = temp;
			} else if (rank[px] == rank[py]) {
				rank[py]++;
			}
			u[px] = py;
			return true;
		}
	}
	
	private static void computeFactorial() {
		fact[1] = 1;
		for (int i = 2; i <= 1e5; i++) {
			fact[i] = (i * (fact[i - 1] % MOD)) % MOD;
		}
	}
	
	static void brutePairs() {
		for (int i = 1; i < (1 << 7); i++) {
			for (int j = 0; j < 7; j++) {
				if ((i & (1 << j)) > 0) {
					keepPair[i][j] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		computeFactorial();
		brutePairs();
		int tc = in.readInt();
		while (tc-- > 0) {
			int n = in.readInt();
			int m = in.readInt();
			int vertexHashCnt = 1;
			for (int i = 0; i < m; i++) {
				badEdges[i][0] = in.readInt();
				badEdges[i][1] = in.readInt();
				vertexHash[badEdges[i][0]] = vertexHashCnt++;
				vertexHash[badEdges[i][1]] = vertexHashCnt++;
			}
			long fAns = fact[n];
			for (int i = 1; i < (1 << m); i++) {
				disjointSetUnion dsu = new disjointSetUnion(2 * m);
				HashMap<Integer, Integer> keepVerticesAndDegrees = new HashMap<Integer, Integer>();
				int numberOfEdges = 0;
				boolean flag = false;
				for (int j = 0; j < m; j++) {
					if (keepPair[i][j]) {
						int v1 = badEdges[j][0], v2 = badEdges[j][1];
						Integer v1Cnt = keepVerticesAndDegrees.get(v1), v2Cnt = keepVerticesAndDegrees.get(v2);
						boolean allowed = dsu.Union(vertexHash[v1], vertexHash[v2]);
						if ((v1Cnt != null && v1Cnt >= 2) || (v2Cnt != null && v2Cnt >= 2) || !allowed) {
							flag = true;
							break;
						}
						numberOfEdges++;
						if (!keepVerticesAndDegrees.containsKey(v1)) {
							keepVerticesAndDegrees.put(v1, 1);
						} else {
							keepVerticesAndDegrees.put(v1, keepVerticesAndDegrees.get(v1) + 1);
						}
						if (!keepVerticesAndDegrees.containsKey(v2)) {
							keepVerticesAndDegrees.put(v2, 1);
						} else {
							keepVerticesAndDegrees.put(v2, keepVerticesAndDegrees.get(v2) + 1);
						}
					}
				}
				if (flag) {
					continue;
				}
				HashSet<Integer> parents = new HashSet<Integer>();
				for (int v : keepVerticesAndDegrees.keySet()) {
					parents.add(dsu.Find(vertexHash[v]));
				}
				long currAns = ((fact[n - keepVerticesAndDegrees.size() + parents.size()] % MOD) * ((1L << parents.size()) % MOD)) % MOD;
				fAns = ((fAns % MOD) + ((numberOfEdges % 2 == 0 ? currAns : -currAns) % MOD)) % MOD;
				if (fAns < 0) {
					fAns = (fAns + MOD) % MOD;
				}
			}
			out.printLine(fAns);
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