import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Shreyans Sheth [bholagabbar] on 12/15/2015 at 8:04 PM using IntelliJ IDEA (Fast IO Template)
 */

public class ArithmeticProgression {
	
	static class Pair implements Comparable<Pair> {
		int x, y;
		
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Pair o1) {
			if (x != o1.x) {
				return x - o1.x;
			}
			return y - o1.y;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n = in.readInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.readInt();
		}
		Arrays.sort(a);
		if (a.length == 1) {
			out.printLine("-1");
			return;
		}
		
		if (a.length == 2) {
			if (a[1] - a[0] != 0 && (a[1] - a[0]) % 2 == 0) {
				int add = a[0] + (a[1] - a[0]) / 2;
				out.printLine("3\n" + (2 * a[0] - a[1]) + " " + add + " " + (2 * a[1] - a[0]));
				return;
			}
			if (a[1] - a[0] == 0) {
				out.printLine("1\n" + a[0]);
				return;
			}
			out.print("2\n");
			out.printLine((2 * a[0] - a[1]) + " " + (2 * a[1] - a[0]));
			return;
		}
		int cd = a[1] - a[0];
		TreeMap<Integer, TreeSet<Pair>> map = new TreeMap<Integer, TreeSet<Pair>>();
		map.put(cd, new TreeSet<Pair>());
		map.get(cd).add(new Pair(a[0], a[1]));
		for (int i = 2; i < n; i++) {
			int curr = a[i] - a[i - 1];
			if (map.size() == 2 && !map.containsKey(curr)) {
				out.printLine("0");
				return;
			} else if (!map.containsKey(curr)) {
				map.put(curr, new TreeSet<Pair>());
			}
			map.get(curr).add(new Pair(a[i - 1], a[i]));
		}
		int diff;
		if (map.get(map.firstKey()).size() < map.get(map.lastKey()).size()) {
			diff = map.firstKey();
			cd = map.lastKey();
		} else {
			diff = map.lastKey();
			cd = map.firstKey();
		}
		if (map.size() == 1 && diff == 0) {
			out.printLine("1\n" + a[0]);
			return;
		}
		if ((map.size() > 1 && map.get(diff).size() > 1)) {
			out.printLine("0");
			//System.out.println("O");
			return;
		}
		if (map.size() == 1) {
			out.printLine("2\n" + (a[0] - diff) + " " + (a[a.length - 1] + diff));
			return;
		}
		Pair curr = map.get(diff).pollFirst();
		if (curr.y - curr.x == 0 || (curr.y - curr.x) % 2 != 0 || (curr.y - curr.x) / 2 != cd) {
			System.out.println("0");
			return;
		} else {
			out.printLine("1");
			out.print((curr.x + (curr.y - curr.x) / 2));
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