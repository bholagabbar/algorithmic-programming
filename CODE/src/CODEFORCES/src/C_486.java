import java.io.*;
import java.util.InputMismatchException;

/**
 * Created by Shreyans Sheth [bholagabbar] on 10/24/2015 at 12:02 AM using IntelliJ IDEA (Fast IO Template)
 */

public class C_486
{
    public static void main(String[] args) throws Exception
    {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/Stdin_File_Read.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n=in.readInt();
        int p=in.readInt()-1;
        int cnt=0;//Stores number of transformations
        String a=in.readString();
        for(int i=0;i<n/2;i++)
        {
            if(a.charAt(i)!=a.charAt(n-i-1))
            {
                int x=a.charAt(i);
                int y=a.charAt(n-i-1);
                int x1=x,y1=y,cnt1=0,cnt2=0;
                while(x1!=y1)
                {
                    x1++;
                    if(x1>122)
                        x1=97;
                    cnt1++;
                }
                x1=x;y1=y;
                while(x1!=y1)
                {
                    x1--;
                    if(x1<97)
                        x1=122;
                    cnt2++;
                }
                //System.out.println(a.charAt(i)+" "+a.charAt(n-i-1)+" "+cnt1+" "+cnt2);
                cnt+=Math.min(cnt1,cnt2);
            }
        }
        String left=a.substring(0, n / 2);
        String right=(new StringBuilder(a.substring(n/2,n)).reverse().toString());
        if(n%2==1)
            right=right.substring(0,right.length()-1);
        if(n%2==0)
        {
            int leftcnt=0,rightcnt=0;
            for(int i=0;i<p;i++)
                if(left.charAt(i)!=right.charAt(i))
                {
                    //System.out.println(left.charAt(i)+" "+right.charAt(i));
                    leftcnt=p-i;
                    break;
                }
            for(int i=left.length()-1;i>p;i--)
                if(left.charAt(i)!=right.charAt(i))
                {
                    rightcnt=i-p;
                    break;
                }
            cnt+=(Math.min(rightcnt,leftcnt)*2+Math.max(rightcnt,leftcnt));
        }
        else
        {
            p-=n/2;
            int leftcnt=0,rightcnt=0;
            for(int i=0;i<p;i++)
                if(left.charAt(i)!=right.charAt(i))
                {
                    //System.out.println(left.charAt(i)+" "+right.charAt(i));
                    leftcnt=i;
                    break;
                }
            for(int i=left.length()-1;i>p;i--)
                if(left.charAt(i)!=right.charAt(i))
                {
                    rightcnt=i-p;
                    break;
                }
            cnt+=(Math.min(rightcnt,leftcnt)*2+Math.max(rightcnt,leftcnt));
        }
        out.printLine(cnt);
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