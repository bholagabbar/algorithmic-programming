package CODECHEF.PRACTICE.EASY.src;

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
 * Created by Shreyans Sheth [bholagabbar] on 6/17/2015 at 1:51 PM using IntelliJ IDEA (Fast IO Template)
 */


class SEAGRP {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int t = in.readInt();
		NXT:
		while (t-- > 0) {
			int n = in.readInt(), m = in.readInt();
			boolean[][] am = new boolean[n + 1][n + 1];
			int[] deg = new int[n + 1];
			for (int i = 0; i < m; i++) {
				int a = in.readInt(), b = in.readInt();
				am[a][b] = true;
				am[b][a] = true;
				deg[a]++;
				deg[b]++;
			}
			for (int i = 1; i <= n; i++) {
				List<Integer> deg1 = new ArrayList<Integer>();
				List<Integer> deg2 = new ArrayList<Integer>();
				for (int j = 1; j <= n; j++) {
					if (am[i][j]) {
						if (deg[j] == 1) {
							deg1.add(j);
						} else if (deg[j] > 1) {
							deg2.add(j);
						}
					}
				}
				if (deg1.size() > 1 || (deg1.size() == 0 && deg2.size() == 0))//having more than 2 adjacent vertices with deg 1
				{
					out.printLine("NO");
					continue NXT;
				} else if (deg1.size() == 1) {
					int tv = deg1.get(0);
					Arrays.fill(am[i], false);//Removing connections
					Arrays.fill(am[tv], false);
					am[i][tv] = true;//Setting one connection
					am[tv][i] = true;
					deg[i] = 1;//Degree will be one
					deg[tv] = 1;
				} else if (deg1.size() == 0 && deg2.size() > 0)//need to check vertices adjacent to these >1 degree vertices
				{
					int flag = 0;
					for (int x : deg2) {
						int flag1 = 1;
						for (int j = 1; j <= n; j++) {
							if (am[x][j] && deg[j] == 1) {
								flag1 = 0;
								break;
							}
						}
						if (flag1 == 1) {
							Arrays.fill(am[i], false);//Removing connections
							Arrays.fill(am[x], false);
							am[i][x] = true;//Setting one connection
							am[x][i] = true;
							deg[i] = 1;//Degree will be one
							deg[x] = 1;
							flag = 1;
						}
						if (flag == 1) {
							break;
						}
					}
					if (flag == 0) {
						out.printLine("NO");
						continue NXT;
					}
				}
			}
			out.printLine("YES");
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