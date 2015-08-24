import java.io.*;
import java.util.InputMismatchException;
import java.util.Stack;

/**
 * Created by Shreyans on 3/15/2015 at 5:11 PM using IntelliJ IDEA (Fast IO Template)
 */

class DEVCLASS
{
    public static void main(String[] args) throws Exception
    {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int ts=in.readInt();
        for(int i=0;i<ts;i++)
        {
            int t=in.readInt();
            char[]x=in.readString().toCharArray();
            char[]y=x.clone();
            int bcnt=0,gcnt=0;
            if(x[0]=='B')
            {
                bcnt++;
                y[0]='G';
            }
            else
            {
                gcnt++;
                y[0]='B';
            }
            Stack<Integer>stx=new Stack<Integer>();
            Stack<Integer>sty=new Stack<Integer>();
            sty.push(0);
            long ans1=0,ans2=0;
            for(int j=1;j<x.length;j++)
            {
                if(x[j]=='B')
                {
                    bcnt++;
                }
                else
                {
                    gcnt++;
                }
                if(x[j]==x[j-1])
                {
                    if(x[j-1]=='B')
                    {
                        x[j]='G';
                    }
                    else
                    {
                        x[j]='B';
                    }
                    stx.push(j);
                    if(stx.size()==2)
                    {
                        if(!stx.get(0).equals(stx.get(1)))
                        {
                            ans1+=(long)Math.pow(Math.abs(stx.get(1)-stx.get(0)),t);
                        }
                        stx.clear();
                    }
                }
                if(y[j]==y[j-1])
                {
                    if(y[j-1]=='B')
                    {
                        y[j]='G';
                    }
                    else
                    {
                        y[j]='B';
                    }
                    sty.push(j);
                    if(sty.size()==2)
                    {
                        if(!sty.get(0).equals(sty.get(1)))
                        {
                            ans2+=(long)Math.pow(Math.abs(sty.get(1)-sty.get(0)),t);
                        }
                        sty.clear();
                    }
                }
            }
            int flag=1;
            if((x.length%2==0)&&(bcnt!=gcnt))
            {
                out.printLine("-1");
                flag=0;
            }
            else if(x.length%2==1)
            {
                if((bcnt+1)==gcnt||(gcnt+1==bcnt))
                {
                    //
                }
                else
                {

                    out.printLine("-1");
                    flag=0;
                }
            }
            if(flag==1)
            {
                if(stx.size()==1&&sty.size()==0)
                {
                    out.printLine(ans2);
                }
                else if(stx.size()==0&&sty.size()==1)
                {
                    out.printLine(ans1);
                }
                else if(stx.size()==0&&sty.size()==0)
                {
                    out.printLine(Math.min(ans1,ans2));
                }
            }
            out.flush();
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