package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Shreyans Sheth [bholagabbar] on 6/22/2015 at 3:41 PM using IntelliJ IDEA (Fast IO Template)
 */


class DIGJUMP {
	static char s1[];
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		s1 = in.readString().toCharArray();
		int len = s1.length;
		
		List<ArrayList<Integer>> gr = new ArrayList<ArrayList<Integer>>();//Graph
		for (int i = 0; i < 10; i++) {
			gr.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < s1.length; i++) {
			gr.get(s1[i] - 48).add(i);
		}
		
		int dis = BFSmod(gr, 0, len - 1, len);
		
		out.printLine(dis);
		
		{
			out.close();
		}
	}
	
	private static int BFSmod(List<ArrayList<Integer>> g, int s, int d, int size) {
		if (size == 1) {
			return 0;
		}
		
		boolean[] visited = new boolean[size];
		boolean[] numvis = new boolean[10];
		int[] prev = new int[size];//Distance
		visited[s] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		while (q.size() != 0) {
			int rv = q.poll();
			int val = s1[rv] - 48;
			
			if (rv == d) {
				break;
			}
			
			if (!numvis[val]) {
				ArrayList<Integer> sg = g.get(val);
				for (int i : sg) {
					if (!visited[i]) {
						prev[i] = rv;
						q.add(i);
						visited[i] = true;
					}
				}
				numvis[val] = true;//not visiting again
			}
			
			//Smart stuff. No need to add edges to adjacent indices. Directly add from here
			if (rv - 1 >= 0 && !visited[rv - 1])//Previous index
			{
				prev[rv - 1] = rv;
				q.add(rv - 1);
				visited[rv - 1] = true;
			}
			
			if (rv + 1 < size && !visited[rv + 1])//Next index
			{
				prev[rv + 1] = rv;
				q.add(rv + 1);
				visited[rv + 1] = true;
			}
		}
		
		Stack<Integer> path = new Stack<Integer>();
		int x = d;
		while (x != s) {
			path.push(x);
			x = prev[x];
		}
		
		return path.size();
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