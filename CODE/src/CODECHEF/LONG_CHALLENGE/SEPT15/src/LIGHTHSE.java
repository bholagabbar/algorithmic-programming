import java.io.*;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.TreeSet;

/**
 * Created by Shreyans Sheth [bholagabbar] on 9/5/2015 at 4:44 PM using IntelliJ IDEA (Fast IO Template)
 */

class LIGHTHSE
{

    static class Node
    {
        int x,y,in;
        Node(int x,int y, int in)
        {
            this.x=x;
            this.y=y;
            this.in=in;
        }
    }

    public static void main(String[] args) throws Exception
    {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/Stdin_File_Read.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int t=in.readInt();
        while(t-->0)
        {
            int n=in.readInt();
            TreeSet<Node> ts=new TreeSet<Node>(new Comparator<Node>()
            {
                @Override
                public int compare(Node o1, Node o2)
                {
                    if(o1.x!=o2.x)
                        return o1.x-o2.x;
                    else
                        return o1.y-o2.y;
                }
            });
            int maxy=Integer.MIN_VALUE,miny=Integer.MAX_VALUE;
            for(int i=1;i<=n;i++)
            {
                int x=in.readInt(),y=in.readInt();
                ts.add(new Node(x,y,i));//Coordinates, island number
                maxy=Math.max(maxy,y);
                miny=Math.min(miny,y);
            }

            //Corner Cases hardcoded for only 1 light house
            if(ts.first().y==miny)
                out.printLine("1\n"+ts.first().in+" NE");//Left most AND Bottom most
            else if(ts.first().y==maxy)
                out.printLine("1\n"+ts.first().in+" SE");//Left most AND Top most
            else if(ts.last().y==miny)
                out.printLine("1\n"+ts.last().in+" NW");//Right most AND Bottom most
            else if(ts.last().y==maxy)
                out.printLine("1\n"+ts.last().in+" SW");//Right most AND Top most
            else//Need 2 lighthouses. Left most point and Rightmost point but they ain't highest or lowest
            {
                //Here lesser of the y coords should point up(NE), bigger should point down(SW)
                if(ts.first().y>=ts.last().y)
                    out.printLine("2\n"+ts.first().in+" SE\n"+ts.last().in+" NW");
                else
                    out.printLine("2\n"+ts.first().in+" NE\n"+ts.last().in+" SW");
            }
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