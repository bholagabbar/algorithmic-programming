package MISC;

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

/**
 * Created by Shreyans Sheth [bholagabbar] on 1/6/2016 at 2:55 PM using IntelliJ IDEA (Fast IO Template)
 */

class TEST {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int tc = in.readInt();
		while (tc-- > 0) {
			int numberOfDays = in.readInt(), whiteButtons = in.readInt(), blackButtons = in.readInt();
			
			int[] diffBetweenButtons = new int[numberOfDays];
			TreeMap<Integer, Integer> getClosestValue = new TreeMap<Integer, Integer>();
			
			for (int i = 0; i < numberOfDays; i++) {
				diffBetweenButtons[i] = in.readInt();
			}
			for (int i = 0; i < numberOfDays; i++) {
				diffBetweenButtons[i] = Math.abs(diffBetweenButtons[i] - in.readInt());
			}
			for (int i = 0; i < whiteButtons; i++) {
				int buttonValue = in.readInt();
				if (!getClosestValue.containsKey(buttonValue)) {
					getClosestValue.put(buttonValue, 1);
				} else {
					getClosestValue.put(buttonValue, getClosestValue.get(buttonValue) + 1);
				}
			}
			for (int i = 0; i < blackButtons; i++) {
				int buttonValue = in.readInt();
				if (!getClosestValue.containsKey(buttonValue)) {
					getClosestValue.put(buttonValue, 1);
				} else {
					getClosestValue.put(buttonValue, getClosestValue.get(buttonValue) + 1);
				}
			}
			
			
			Arrays.sort(diffBetweenButtons);
			int finalMinDiff = 0;
			
			for (int i = numberOfDays - 1; i >= 0; i--) {
				finalMinDiff += diffBetweenButtons[i];
				Integer canReduce = getClosestValue.floorKey(diffBetweenButtons[i]);
				if (canReduce != null) {
					finalMinDiff -= canReduce;
					if (getClosestValue.get(canReduce) == 1) {
						getClosestValue.remove(canReduce);
					} else {
						getClosestValue.put(canReduce, getClosestValue.get(canReduce) - 1);
					}
				}
			}
			out.printLine(finalMinDiff);
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