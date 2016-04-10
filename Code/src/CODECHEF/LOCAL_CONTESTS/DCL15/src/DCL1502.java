package CODECHEF.LOCAL_CONTESTS.DCL15.src;import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;

/**
 * Created by Shreyans on 3/5/2015 at 4:24 PM using IntelliJ IDEA (Fast IO Template)
 */

class DCL1502
{
    public static void main(String[] args) throws Exception
    {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int t=in.readInt();
        boolean com[]=SOE();
        for(int i=0;i<t;i++)
        {
            char[] a=in.readString().toCharArray();
            HashMap<Character,Integer>hm=new HashMap<Character, Integer>();
            for(int j=65;j<=122;j++)
            {
                hm.put((char)j,0);
            }
            int cnt=0;
            for(int j=0;j<a.length;j++)
            {
                int x=hm.get(a[j]);
                x++;
                hm.put(a[j],x);
                if(x>cnt)
                {
                    cnt=x;
                }
                //System.out.println(a[j]+" "+hm.get(a[j]));
            }
            int sum=0;
            if(com[cnt])
            {
                for(int j=65;j<=122;j++)
                {
                    if(com[hm.get((char)j)])
                    {
                        sum+=(hm.get((char)j)/2);
                    }
                    else
                    {
                        sum+=(hm.get((char)j));
                    }
                }
            }
            else if(!com[cnt])
            {
                for(int j=65;j<=122;j++)
                {
                    if(!com[hm.get((char)j)]&&hm.get((char)j)!=1)
                    {
                        sum+=(hm.get((char)j))/2;
                    }
                    else if(com[hm.get((char)j)]||hm.get((char)j)==1)
                    {
                        sum+=(hm.get((char)j));
                    }
                }
            }
            out.printLine(sum);
            //out.flush();
        }

        {
            out.close();
        }
    }
    public static boolean[] SOE()
    {
        int max=10001;
        final boolean[] primeCandidates = new boolean[max]; // defaults to false
        for (int i = 2; i < max; i++) {
            primeCandidates[i] = true;
        }

        final double maxRoot = Math.sqrt(max);
        for (int candidate = 2; candidate < maxRoot; candidate++) {
            if (primeCandidates[candidate]) {
                for (int j = 2 * candidate; j < max; j += candidate) {
                    primeCandidates[j] = false;
                }
            }

        }
        return primeCandidates;
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
        }

        public void printLine(Object... objects)
        {
            print(objects);
            writer.println();
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