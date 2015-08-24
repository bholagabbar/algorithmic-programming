import java.io.*;
import java.util.*;

/**
 * Created by Shreyans on 4/21/2015 at 10:33 PM using IntelliJ IDEA (Fast IO Template)
 */

//ADD PUBLIC FOR CF,TC
class SPATH
{
    public static void main(String[] args) throws Exception
    {
        class Node implements Comparator<Node>
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
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int t=in.readInt();
        for(int i1=0;i1<t;i1++)
        {
            int v=in.readInt();
            List<ArrayList<Node>> gr=new ArrayList<ArrayList<Node>>();
            for(int i=0;i<=v;i++)
            {
                gr.add(new ArrayList<Node>());
            }//graph skeleton built
            Map<String,Integer>hm=new HashMap<String ,Integer>();
            Map<String,int[]>con=new HashMap<String, int[]>();
            for(int i=1;i<=v;i++)
            {
                hm.put(in.readString(),i);
                int e=in.readInt();
                for(int j=0;j<e;j++)
                {
                    gr.get(i).add(new Node(in.readInt(),in.readInt()));
                }
            }
            int[]d=new int[v+1];
            int t1=in.readInt();
            for(int i2=0;i2<t1;i2++)
            {
                String S1=in.readString();
                String DES=in.readString();
                if(con.containsKey(S1))
                {
                    out.printLine(con.get(S1)[hm.get(DES)]);
                }
                else
                {
                    int s=hm.get(S1);
                    int des=hm.get(DES);
                    Queue<Node> pq=new PriorityQueue<Node>(new Node());
                    boolean[]checked=new boolean[v+1];
                    Arrays.fill(d,Integer.MAX_VALUE);
                    d[s]=0;
                    pq.add(new Node(s,0));
                    while(!pq.isEmpty())
                    {
                        Node x=pq.remove();
                        int V=x.node;
                        int W=x.cost;
                        checked[V]=true;
                        for(int i=0;i<gr.get(V).size();i++)
                        {
                            Node z=gr.get(V).get(i);
                            if(!checked[(z.node)])
                            {
                                int v1=z.node;
                                int w1=z.cost;
                                if(d[v1]>W+w1)
                                {
                                    d[v1]=W+w1;
                                }
                                pq.add(new Node(v1,d[v1]));
                            }
                        }
                    }
                    con.put(S1,d);
                    out.printLine(d[des]);
                }
                out.flush();
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