package CODECHEF.PRACTICE.MEDIUM.src;import java.io.*;
import java.util.*;

/**
 * Created by Shreyans Sheth [bholagabbar] on 5/25/2015 at 10:28 AM using IntelliJ IDEA (Fast IO Template)
 */

class COALSCAM //ADD PUBLIC FOR CF
{
    static int u[];
    static int rank[];
    private static class Node
    {
        int v1,v2,w;
        Node(int v1,int v2,int w)
        {
            this.v1=v1;
            this.v2=v2;
            this.w=w;
        }
    }

    public static int FIND(int x)
    {
        if(u[x]!=u[u[x]])
        {
            u[x]=FIND(u[x]);
        }
        return u[x];
    }

    public static boolean UNION(int x, int y)
    {
        int px=FIND(x),py=FIND(y);

        //Union by rank
        if(px==py) return false;

        if(rank[px]>rank[py]) {int tmp=px;px=py;py=tmp;}

        else if(rank[px]==rank[py]) rank[py]++;

        u[px]=py;
        return true;
    }

    public static void initialize(int l)
    {
        for(int i=0;i<=l;i++)
        {
            u[i]=i;
            rank[i]=1;
        }
    }

    public static void main(String[] args) throws Exception
    {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int tc=in.readInt();
        while(tc-->0)
        {
            int n=in.readInt(),M1=in.readInt(),M2=in.readInt();
            u=new int[n+1]; rank=new int[n+1];
            initialize(n);
            ArrayList<Node>al1=new ArrayList<Node>();
            ArrayList<Node>al2=new ArrayList<Node>();
            for(int i=0;i<M1;i++)
            {
                al1.add(new Node(in.readInt(), in.readInt(), in.readInt()));
            }
            for(int i=0;i<M2;i++)
            {
                al2.add(new Node(in.readInt(), in.readInt(), in.readInt()));
            }
            Collections.sort(al1, new Comparator<Node>()
            {
                @Override
                public int compare(Node o1, Node o2)
                {
                    return o2.w-o1.w;
                }
            });
            Collections.sort(al2, new Comparator<Node>()
            {
                @Override
                public int compare(Node o1, Node o2)
                {
                    return o1.w-o2.w;
                }
            });
            long cnt=0,cprof=0,oprof=0;

            while(al2.size()>0&&cnt<n-1)
            {
                Node cur=al2.remove(al2.size()-1);
                if(UNION(cur.v1,cur.v2))
                {
                    cnt++;
                    cprof+=cur.w;
                }
            }
            while(al1.size()>0&&cnt<n-1)
            {
                Node cur=al1.remove(al1.size()-1);
                if(UNION(cur.v1,cur.v2))
                {
                    cnt++;
                    oprof+=cur.w;
                }
            }

            if(cnt==n-1)
            {
                out.printLine(cprof+" "+(cprof+oprof));
            }
            else
            {
                out.printLine("Impossible");
            }
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

        public OutputWriter(Writer writer) { this.writer = new PrintWriter(writer);}

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

        public void close() {writer.close();}

        public void flush() {writer.flush();}
    }
} 