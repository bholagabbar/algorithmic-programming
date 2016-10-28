package CODEFORCES.DIV2_310.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Shreyans Sheth [bholagabbar] on 6/29/2015 at 12:54 AM using IntelliJ IDEA (Fast IO Template)
 */

public class D {
	static class DNode//For storing the island in order of bridges needed
	{
		long ul, ll;
		int diff;
		
		DNode(long ul, long ll, int diff) {
			this.ul = ul;
			this.ll = ll;
			this.diff = diff;
		}
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		
		TreeSet<DNode> d = new TreeSet<DNode>(new Comparator<DNode>() {
			@Override
			public int compare(DNode o1, DNode o2) {
				if (o1.ul != o2.ul) {
					if (o1.ul > o2.ul) {
						return 1;
					}
					return -1;
				}
				return o1.diff - o2.diff;
			}
		});
		
		int n = in.readInt();
		int m = in.readInt();
		
		long px = in.readLong();//previous coords
		long py = in.readLong();
		for (int i = 1; i < n; i++) {
			long x = in.readLong();
			long y = in.readLong();
			d.add(new DNode(y - px, x - py, i));
			px = x;
			py = y;
		}
		
		TreeMap<Long, TreeSet<Integer>> bm = new TreeMap<Long, TreeSet<Integer>>();//stores the bridge distances
		for (int i = 1; i <= m; i++) {
			long x = in.readLong();
			if (bm.containsKey(x)) {
				TreeSet<Integer> temp = bm.get(x);
				temp.add(i);
			} else {
				TreeSet<Integer> temp = new TreeSet<Integer>();
				temp.add(i);
				bm.put(x, temp);
			}
		}
		
		int[] ans = new int[n - 1];
		int aflag = 1;
		
		for (DNode x : d)//smallest bridges for smallest flexibility
		{
			Long lk = bm.ceilingKey(x.ll);
			if (lk != null && lk <= x.ul) {
				TreeSet<Integer> temp = bm.get(lk);
				int ind = temp.pollFirst();
				ans[x.diff - 1] = ind;
				if (temp.isEmpty()) {
					bm.remove(lk);
				}
			} else {
				aflag = 0;
				break;
			}
		}
		
		if (aflag == 1) {
			out.printLine("Yes");
			for (int x : ans) {
				out.print(x + " ");
			}
		} else {
			out.printLine("No");
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