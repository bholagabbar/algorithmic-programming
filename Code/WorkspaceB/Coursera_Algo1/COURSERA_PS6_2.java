import java.io.*;
import java.util.InputMismatchException;
import java.util.TreeSet;

/**
 * Created by Shreyans Sheth [bholagabbar] on 8/31/2015 at 2:16 AM using IntelliJ IDEA (Fast IO Template)
 */

class COURSERA_PS6_2
{
    public static void main(String[] args) throws Exception
    {
        System.setIn(new FileInputStream("E:\\Shreyans\\Coursera Algos 1\\Week 6\\Median.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        TreeSet<Integer>ExtractMinfromMax=new TreeSet<Integer>();//Stores max half
        TreeSet<Integer>ExtractMaxfromMin=new TreeSet<Integer>();//Stores min half
        int i1=in.readInt();
        int med=i1;
        int i2=in.readInt();
        ExtractMinfromMax.add(Math.max(i1,i2));
        ExtractMaxfromMin.add(Math.min(i1, i2));
        med+=Math.min(i1,i2);
        for(int i=3;i<=10000;i++)
        {
            if(i%2!=0)
            {
                int x=in.readInt();
                int gmin=ExtractMaxfromMin.last();//greatest min number
                if(x<gmin)
                    ExtractMaxfromMin.add(x);
                else
                    ExtractMinfromMax.add(x);
                if(ExtractMaxfromMin.size()>ExtractMinfromMax.size())//median must be in odd numbered tree
                    med+=(ExtractMaxfromMin.last()%10000);
                else
                    med+=(ExtractMinfromMax.first()%10000);
            }
            else
            {
                int x=in.readInt();
                int gmin=ExtractMaxfromMin.last();
                if(x<gmin)
                    ExtractMaxfromMin.add(x);
                else
                    ExtractMinfromMax.add(x);
                if(ExtractMaxfromMin.size()==ExtractMinfromMax.size()+2)//more smaller numbers
                    ExtractMinfromMax.add(ExtractMaxfromMin.pollLast());
                else if(ExtractMaxfromMin.size()+2==ExtractMinfromMax.size())
                    ExtractMaxfromMin.add(ExtractMinfromMax.pollFirst());
                med+=(ExtractMaxfromMin.last()%10000);
            }
        }
        out.printLine(med%10000);
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