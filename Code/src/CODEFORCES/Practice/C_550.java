import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.util.InputMismatchException;

/**
 * Created by Shreyans Sheth [bholagabbar] on 7/30/2015 at 12:49 AM using IntelliJ IDEA (Fast IO Template)
 */

public class C_550 {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		StringBuilder x = new StringBuilder(in.readString());
		BigInteger ate = new BigInteger("8");
		if (x.length() == 1) {
			if (Integer.parseInt(x.toString()) % 8 == 0) {
				out.printLine("YES\n" + x);
				return;
			} else {
				out.printLine("NO");
				return;
			}
		} else if (x.length() == 2) {
			int a = x.charAt(0) - 48;
			int b = x.charAt(1) - 48;
			int c = Integer.parseInt(x.toString());
			if (a % 8 == 0) {
				out.printLine("YES\n" + a);
				return;
			} else if (b % 8 == 0) {
				out.printLine("YES\n" + b);
				return;
			} else if (c % 8 == 0) {
				out.printLine("YES\n" + c);
				return;
			} else {
				out.printLine("NO");
				return;
			}
		} else if (x.length() >= 3) {
			while (x.length() >= 3) {
				StringBuilder y = new StringBuilder(x.substring(x.length() - 3, x.length()));//Substring to be modded
				for (int i = 0; i < Math.pow(2, 3); i++) {
					int f1 = 0, f2 = 0, f3 = 0;
					StringBuilder xx = new StringBuilder(x.substring(0, x.length() - 3));//Previous string to append to
					for (int j = 0; j < 3; j++) {
						if (((1 << j) & i) > 0) {
							if (j == 0) {
								f1 = 1;
							} else if (j == 1) {
								f2 = 1;
							} else if (j == 2) {
								f3 = 1;
							}
						}
					}
					
					String yy = "";
					if (f3 == 0) {
						xx.append(y.charAt(0));
						yy += y.charAt(0);
					}
					
					if (f2 == 0) {
						xx.append(y.charAt(1));
						yy += y.charAt(1);
					}
					if (f1 == 0) {
						xx.append(y.charAt(2));
						yy += y.charAt(2);
					}
					
					//out.printLine(y);
					if (yy.length() > 0 && Integer.parseInt(yy) % 8 == 0) {
						out.printLine("YES\n" + Integer.parseInt(yy));
						return;
					}
					
					if (xx.length() > 0 && xx.length() < 3 && Integer.parseInt(xx.toString()) % 8 == 0) {
						out.printLine("YES\n" + Integer.parseInt(xx.toString()));
						return;
					}
					
					if (xx.length() >= 3) {
						BigInteger bi = new BigInteger(xx.substring(xx.length() - 3, xx.length()));
						if (bi.mod(ate).equals(BigInteger.ZERO)) {
							out.printLine("YES\n" + bi);
							return;
						}
					}
				}
				if (x.length() >= 3) {
					x.deleteCharAt(x.length() - 1);
				}
			}
			out.printLine("NO");
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