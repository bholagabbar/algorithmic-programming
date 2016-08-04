package CODEFORCES.DIV2_301.src;

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
 * Created by Shreyans on 5/1/2015 at 11:50 PM using IntelliJ IDEA (Fast IO Template)
 */

//ADD PUBLIC FOR CF,TC
class C {
	static int r, c, s1, s2, f1, f2;//Rows, Columns, Start Coordinates, Finish Coordinates
	static int[] dx = {1, -1, 0, 0};//right, left, NA, NA
	static int[] dy = {0, 0, 1, -1};//NA, NA, bottom, top
	static char[][] grid;//Main grid
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		r = in.readInt();
		c = in.readInt();
		grid = new char[r][c];
		for (int i = 0; i < r; i++) {
			char[] s1 = in.readString().toCharArray();//Reading a line of the Grid
			System.arraycopy(s1, 0, grid[i], 0, c);//Inbuilt function to copy contents of an array
		}
		s1 = in.readInt() - 1;
		s2 = in.readInt() - 1;
		f1 = in.readInt() - 1;
		f2 = in.readInt() - 1;
		if (MAZEBFS()) {
			out.printLine("YES");
		} else {
			out.printLine("NO");
		}
		out.close();
	}
	
	private static boolean MAZEBFS() {
		if (s1 == f1 && s2 == f2)//case where start and end are the same
		{
			int[] curr = {s1, s2};
			for (int i = 0; i < 4; i++)//for each direction
			{
				if ((curr[0] + dx[i] >= 0 && curr[0] + dx[i] < r) && (curr[1] + dy[i] >= 0 && curr[1] + dy[i] < c) && (grid[curr[0] + dx[i]][curr[1] + dy[i]] != 'X')) {
					return true;
				}
			}
			return false;
		} else {
			int flagx = 0;
			if (grid[f1][f2] == 'X') {
				flagx = 1;
			}
			grid[f1][f2] = 'F';
			Queue<int[]> q = new LinkedList<int[]>();
			int[] start = {s1, s2};
			q.add(start);
			while (q.peek() != null) {
				int[] curr = q.remove();
				for (int i = 0; i < 4; i++)//for each direction
				{
					if (((curr[0] + dx[i] >= 0 && curr[0] + dx[i] < r) && (curr[1] + dy[i] >= 0 && curr[1] + dy[i] < c)) && (grid[curr[0] + dx[i]][curr[1] + dy[i]] != 'X')) {
						//Checked if x and y are correct. ALL IN 1 GO
						int xc = curr[0] + dx[i];
						int yc = curr[1] + dy[i];
						//System.out.println((xc+1)+" "+(yc+1));
						if (grid[xc][yc] == 'F')//Destination found
						{
							if (flagx == 1) {
								return true;
							} else {
								int[] cur = {xc, yc};
								for (int i1 = 0; i1 < 4; i1++)//for each direction
								{
									if ((cur[0] + dx[i1] >= 0 && cur[0] + dx[i1] < r) && (cur[1] + dy[i1] >= 0 && cur[1] + dy[i1] < c) && (grid[curr[0] + dx[i]][curr[1] + dy[i]] != 'X')) {
										return true;
									}
								}
								return false;
							}
						} else//normal point
						{
							grid[xc][yc] = 'X';
							int[] temp = {xc, yc};
							q.add(temp);//Adding current coordinates to the queue
						}
					}
				}
			}
			return false;//Will return false if no route possible
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
		}
		
		public void printLine(Object... objects) {
			print(objects);
			writer.println();
		}
		
		public void close() {
			writer.close();
		}
		
		public void flush() {
			writer.flush();
		}
	}
}