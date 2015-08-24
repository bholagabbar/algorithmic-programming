import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by Shreyans Sheth [bholagabbar] on 6/11/2015 at 10:18 PM using IntelliJ IDEA (Fast IO Template)
 */


class STDYTAB
{
    static List<ArrayList<Long>> C=new ArrayList<ArrayList<Long>>(4001);
    static long MOD=1000000000;

    public static void COMBINATIONS()
    {
        long ONE=1;
        for (int i=0; i<=4000; i++)
        {
            C.add(new ArrayList<Long>(i + 1));
            for (int k=0; k<=2000 && k<=i; k++)
            {
                if (k == 0 || k == i)
                {
                    C.get(i).add(ONE);
                }
                else
                {
                    C.get(i).add((C.get(i-1).get(k-1) + C.get(i-1).get(k)) % MOD);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/Stdin_File_Read.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        COMBINATIONS();
        int tc=in.readInt();
        while(tc-->0)
        {
            int n=in.readInt();
            int m=in.readInt();
            long ans=0;
            if(n==1)
            {
                for(int i=0;i<=m;i++)
                {
                    ans+=(C.get(m+i-1).get(i))%MOD;
                }
            }
            else
            {
                long dp[][]=new long[n][m+1];
                for(int i=0;i<=m;i++)
                {
                    if(i==0)
                    {
                        dp[0][i]=(C.get(m+i-1).get(i))%MOD;
                    }
                    else
                    {
                        dp[0][i]=(dp[0][i-1]+C.get(m+i-1).get(i))%MOD;
                    }
                }
                for(int i=1;i<n;i++)
                {
                    for(int j=0;j<=m;j++)
                    {
                        if(j==0)
                        {
                            dp[i][0]=(C.get(m-1).get(0)*dp[i-1][0])%MOD;
                        }
                        else
                        {
                            dp[i][j]=(dp[i][j-1]+(C.get(m+j-1).get(j)*dp[i-1][j]))%MOD;
                        }
                    }
                }
                ans=dp[n-1][m];
            }
            out.printLine(ans%MOD);
        }

        {
            out.close();
        }
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

        public long readLong()
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
            long res = 0;
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