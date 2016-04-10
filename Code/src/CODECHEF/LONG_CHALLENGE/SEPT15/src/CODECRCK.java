package CODECHEF.LONG_CHALLENGE.SEPT15.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

/**
 * Created by Shreyans Sheth [bholagabbar] on 9/7/2015 at 5:40 PM using IntelliJ IDEA (Fast IO Template)
 */

class CODECRCK {
	static double sq2 = Math.sqrt(2);
	static double sq6 = Math.sqrt(6);
	
	static double IterateForward(double ax, double bx) {
		return ax * (sq2 - sq6) + bx * (sq2 + sq6) + (sq2 + sq6) * ax + (-sq2 + sq6) * bx;
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		double i = in.readDouble(), k = in.readDouble(), s = in.readDouble();
		double a_i = in.readDouble(), b_i = in.readDouble(), ans = 0;
		if ((k - i) % 2 == 0) {
			ans = (a_i + b_i) * Math.pow(16.0, ((k - i) / 2.0) - (s / 4.0));
		} else {
			ans = IterateForward(a_i * Math.pow(16.0, ((k - i - 1) / 2.0) - (s / 4.0)), b_i * Math.pow(16.0, ((k - i - 1) / 2.0) - (s / 4.0)));
		}
		out.printLine(ans);
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
/*

DIAGONALIZATION-EIGEN VALUES APPROACH NOT WORKING!

import java.io.*;
import java.util.InputMismatchException;

class CODECRCK_MATRIX_DIAG_EIGEN
{
    //static double [][]P={{-0.7933533402912351650826394688920117914676666259765625,0.6087614290087206558865773331490345299243927001953125},{0.6087614290087206558865773331490345299243927001953125,0.7933533402912351650826394688920117914676666259765625}};
    //static double [][]P_inv={{-0.7933533402912351650826394688920117914676666259765625,0.6087614290087206558865773331490345299243927001953125},{0.6087614290087206558865773331490345299243927001953125,0.7933533402912351650826394688920117914676666259765625}};

    static double sq2=1.41421356237309504880168872420969807856967187537694807317667973799073247846210703885038753432764157273501384623091229702,sq3=1.73205080756887729352744634150587236694280525381038062805580697945193301690880003708114618675724857567562614141540670302,sq6=2.44948974278317809819728407470589139196594748065667012843269256725096037745731502653985943310464023481859460122661418912;

    static double[][]P={{-((-1.0+2.0*sq2+sq3)/(1+sq3)),(1.0+2.0*sq2-sq3)/(1+sq3)},{1,1}};
    static double[][]P_inv={{-((1.0+sq3)/(4*sq2)),(1.0/8.0)*(4.0+sq2-sq6)},{(1.0+sq3)/(4.0*sq2),(1.0/8.0)*(4.0-sq2+sq6)}};

    static double[][] MatrixMultiply2x2(double[][] i, double[][] j)
    {
        double[][]c=new double[2][2];
        c[0][0]=i[0][0]*j[0][0]+i[0][1]*j[1][0];
        c[0][1]=i[0][0]*j[0][1]+i[0][1]*j[1][1];
        c[1][0]=i[1][0]*j[0][0]+i[1][1]*j[1][0];
        c[1][1]=i[1][0]*j[0][1]+i[1][1]*j[1][1];
        return c;

    }

    static double[][] MatrixMultiply2x1(double[][] A, double[][] B)
    {
        double[][] C=new double[2][1];
        C[0][0]=A[0][0]*B[0][0]+A[0][1]*B[1][0];
        C[1][0]=A[1][0]*B[0][0] + A[1][1]*B[1][0];
        return C;
    }

    static double[][] MatrixInverse(double[][] A)
    {
        double[][] inv=new double[2][2];
        double a=A[0][0],b=A[0][1],c=A[1][0],d=A[1][1];
        double det=Math.abs((a*d)-(b*c));
        inv[0][0]=d/det;
        inv[0][1]=(-b)/det;
        inv[1][0]=(-c)/det;
        inv[1][1]=a/det;
        return inv;
    }

    static double[][] EigenPower(double pow)//Taking 4 out common
    {
        double[][]Dpow=new double[2][2];
        if(pow%2==1)
            Dpow[0][0]=-1;
        else
            Dpow[0][0]=1;
        Dpow[0][1]=0;
        Dpow[1][1]=1;
        Dpow[1][0]=0;
        return Dpow;
    }


    public static void main(String[] args) throws Exception
    {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        double[][]d=MatrixMultiply2x2(P,P_inv);
        double i=in.readInt(),k=in.readInt(),s=in.readInt();
        double a_i=in.readInt(),b_i=in.readInt();
        double X[][];
        double A_i[][]={{a_i},{b_i}};
        if(k>=i)
            X=MatrixMultiply2x1(MatrixMultiply2x2(MatrixMultiply2x2(P,EigenPower(k-i)), P_inv),A_i);
        else
            X=MatrixMultiply2x1(MatrixInverse(MatrixMultiply2x2(MatrixMultiply2x2(P,EigenPower(i-k)), P_inv)),A_i);
        X[0][0]*=Math.pow(4.0,(k-i)-s/2.0);
        X[1][0]*=Math.pow(4.0,(k-i)-s/2.0);
        double ans=X[0][0]+X[1][0];
        out.printLine(ans);
    }

    //FAST IO
    private static class InputReader
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream)
        {
            this.stream = stream;
        }

        public int read()
        {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars)
            {
                curChar = 0;
                try
                {
                    numChars = stream.read(buf);
                } catch (IOException e)
                {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do
            {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public double readDouble()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.')
            {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, readInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.')
            {
                c = read();
                double m = 1;
                while (!isSpaceChar(c))
                {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, readInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public boolean isSpaceChar(int c)
        {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next()
        {
            return readString();
        }

        public interface SpaceCharFilter
        {
            public boolean isSpaceChar(int ch);
        }
    }

    private static class OutputWriter
    {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream)
        {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer)
        {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects)
        {
            for (int i = 0; i < objects.length; i++)
            {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
            writer.flush();
        }

        public void printLine(Object... objects)
        {
            print(objects);
            writer.println();
            writer.flush();
        }

        public void close()
        {
            writer.close();
        }

        public void flush()
        {
            writer.flush();
        }
    }
}
 */