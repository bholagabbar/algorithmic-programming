import java.io.*;
import java.util.*;

/**
 * Created by Shreyans on 4/21/2015 at 1:37 AM using IntelliJ IDEA (Fast IO Template)
 */

//ADD PUBLIC FOR CF,TC
class EZDIJKST
{
    static class Node implements Comparator<Node>
    {
        public int node;
        public int cost;

        public Node() {}

        public Node(int node, int cost)
        {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2)
        {
            if (node1.cost < node2.cost)
                return -1;
            if (node1.cost > node2.cost)
                return 1;
            return 0;
        }
    }

    public static void main(String[] args) throws Exception
    {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int t=in.readInt();
        for(int i1=0;i1<t;i1++)
        {
            List<ArrayList<Node>>gr=new ArrayList<ArrayList<Node>>();
            int v=in.readInt();
            for(int i=0;i<=v;i++)
            {
                gr.add(new ArrayList<Node>());
            }
            int e=in.readInt();
            for(int i=0;i<e;i++)
            {
                int a=in.readInt();
                int b=in.readInt();
                int c=in.readInt();
                gr.get(a).add(new Node(b,c));
            }
            int s=in.readInt();
            int des=in.readInt();
            Queue<Node> pq=new PriorityQueue<Node>(new Node());
            int[]d=new int[v+1];
            boolean[]checked=new boolean[v+1];
            Arrays.fill(d,Integer.MAX_VALUE);
            d[s]=0;
            pq.add(new Node(s,0));
            while(!pq.isEmpty())
            {
                Node x=pq.remove();
                int V=x.node;
                int W=x.cost;
                if(V==des)
                {
                    break;
                }
                checked[V]=true;
                for(int i=0;i<gr.get(V).size();i++)
                {
                    Node z=gr.get(V).get(i);
                    if(!checked[z.node])
                    {
                        int v1=z.node;
                        int w1=z.cost;
                        d[v1]=Math.min(d[v1],W+w1);
                        pq.add(new Node(v1,d[v1]));
                    }
                }
            }
            if(d[des]==Integer.MAX_VALUE)
            {
                out.printLine("NO");
            }
            else
            {
                out.printLine(d[des]);
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
