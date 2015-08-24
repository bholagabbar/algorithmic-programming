import java.io.*;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.TreeSet;

/**
 * Created by Shreyans Sheth [bholagabbar] on 5/24/2015 at 10:38 AM using IntelliJ IDEA (Fast IO Template)
 */

//ADD PUBLIC FOR CF,TC
class CSTREET
{
    static int u[],rank[];
    static class Node
    {
        int v1,v2,w;
        Node(int x,int y,int z)
        {
            this.v1=x;
            this.v2=y;
            this.w=z;
        }
    }

    public static int FIND(int x)//Finding the parent of the current Node. Path compression documentation below
    {
        if(u[x]!=u[u[x]])
        {
            u[x]=FIND(u[x]);
        }
        return u[x];
    }

    public static boolean UNION (int x, int y) // Setting the two parents of these nodes equal. Essentially, 'merging' the two sets :)
    {
        int px=FIND(x),py=FIND(y);//Parents of these nodes
        //Union by rank
        if(px==py) return false;//Parents are equal. Don't merge

        if(rank[px]>rank[py]){int temp=px; px=py; py=temp;}//Making sure rank of x is smaller. swap(a,b) is a std f'n in c++14

        else if(rank[px]==rank[py]) rank[py]++; // if both are equal, the combined tree becomes 1 deeper

        u[px]=py;//Setting parents equals and merging sets as mentioned before
        return true;
    }

    static void u_init(int l)//Initialising union array to elements itself first
    {
        for(int i=1;i<=l;i++)
        {
            u[i]=i;
            rank[i]=1;
        }
    }
    public static void main(String[] args) throws Exception
    {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int t=in.readInt();
        while(t-->0)
        {
            int p=in.readInt(),n=in.readInt(),m=in.readInt();
            u=new int[n+1];
            rank=new int[n+1];
            u_init(n);
            TreeSet<Node> edges=new TreeSet<Node>(new Comparator<Node>()
            {
                @Override
                public int compare(Node o1, Node o2)//Custom comparator
                {
                    if(o1.w!=o2.w) return o1.w-o2.w;
                    return 1;
                }
            });
            for(int i=0;i<m;i++)//Building up Edge List
            {
                int x1=in.readInt(),y1=in.readInt(),w1=in.readInt();
                edges.add(new Node(x1,y1,w1));
            }

            long spt_sum=0;//Spanning Tree Sum
            int ecnt=0;
            while(ecnt!=n-1)//Edges in MST equals n-1. Duh
            {
                Node cur=edges.pollFirst();//Removing Node from the list
                if(UNION(cur.v1,cur.v2))//If they don't belong to the same set
                {
                    spt_sum+=(cur.w*p);
                    ecnt++;
                }
            }
            out.printLine(spt_sum);
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