import java.io.*;
import java.util.InputMismatchException;

/**
 * Created by Shreyans Sheth [bholagabbar] on 7/27/2015 at 11:32 PM using IntelliJ IDEA (Fast IO Template)
 */

public class DIV2_551_B
{
    public static void main(String[] args) throws Exception
    {
        System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        String x=in.readString();
        String a=in.readString(),b=in.readString();
        char[]m=new char[26];
        for(int i=0;i<x.length();i++)
        {
            m[x.charAt(i)-97]++;
        }
        if(a.length()>b.length())
        {
            String temp=a;
            a=b;
            b=temp;
        }
        StringBuilder sb=new StringBuilder();
        int flag=1,cnt=0;
        while(flag==1)
        {
            char[]nos=new char[26];
            for(int i=0;i<a.length();i++)
            {
                nos[a.charAt(i)-97]++;
                if(nos[a.charAt(i)-97]>m[a.charAt(i)-97])
                {
                    flag=0;
                    break;
                }
            }
            if(flag==1)
            {
                for(int i=0;i<26;i++)
                {
                    m[i]-=nos[i];
                }
                cnt++;
                sb.append(a);
            }
        }
        flag=1;
        while(flag==1)
        {
            char[]nos=new char[26];
            for(int i=0;i<b.length();i++)
            {
                nos[b.charAt(i)-97]++;
                if(nos[b.charAt(i)-97]>m[b.charAt(i)-97])
                {
                    flag=0;
                    break;
                }
            }
            if(flag==1)
            {
                for(int i=0;i<26;i++)
                {
                    m[i]-=nos[i];
                }
                cnt++;
                sb.append(b);
            }
        }
        for(int i=0;i<26;i++)
        {
            if(m[i]>0)
                for(int j=0;j<m[i];j++)
                    sb.append((char)(i+97));
        }
        out.printLine(sb);
        out.printLine(cnt);
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