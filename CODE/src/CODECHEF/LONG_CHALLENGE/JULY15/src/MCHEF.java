import java.io.*;
import java.util.*;

/**
 * Created by Shreyans Sheth [bholagabbar] on 7/6/2015 at 8:32 PM using IntelliJ IDEA (Fast IO Template)
 */

class MCHEF
{


    static class Node
    {
        int l,r,c;
        Node(int l, int r, int c)
        {
            this.l=l;this.r=r;this.c=c;
        }
    }

    /*static int st[]=new int[100007<<2];
    static int lazy[]=new int [100007<<2];

    static void Build(int n)
    {
        Arrays.fill(st,0,4*n,Integer.MAX_VALUE);
        Arrays.fill(lazy,0,4*n,0);
    }

    static void UpdateSt(int node, int a, int b, int i, int j, int value)
    {
        if(lazy[node]!=0)
        {
            if(lazy[node]<st[node])
            {
                st[node]=lazy[node];
                if(a!=b)
                {
                    lazy[2*node]=lazy[node];
                    lazy[2*node+1]=lazy[node];
                }
            }
            lazy[node]=0;
        }

        if(a > b || a > j || b < i)
            return;

        if(a >= i && b <= j)
        {
            if(value<st[node])
            {
                st[node]=value;
                if(a!=b)
                {
                    lazy[2*node]=value;
                    lazy[2*node+1]=value;
                }
            }
            return;
        }

        UpdateSt(node*2, a, (a+b)/2, i, j, value);
        UpdateSt(1 + node * 2, 1 + (a + b) / 2, b, i, j, value);
        st[node] = Math.min(st[node*2], st[node*2+1]);
    }

    public static int RMinQ(int pos,int lo, int hi, int i, int j)
    {
        if (i>hi || j<lo)
            return Integer.MAX_VALUE;

        if(lazy[pos]!=0)
        {
            if(lazy[pos]<st[pos])
            {
                st[pos]=lazy[pos];
                if(lo!=hi)
                {
                    lazy[2*pos]=lazy[pos];
                    lazy[2*pos+1]=lazy[pos];
                }
                lazy[pos]=0;
            }
        }

        if (i<=lo && j>=hi)
            return st[pos];

        return Math.min(RMinQ(2 * pos, lo, (lo + hi) / 2, i, j), RMinQ(2 * pos + 1, 1 + (lo + hi) /2,hi,i,j));//returns minimum in range from l,r
    }*/

    static long[][] dp=new long[100007][507];
    static int min[]=new int[100007];

    public static void main(String[] args) throws Exception
    {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/Stdin_File_Read.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int tc=in.readInt();
        while(tc-->0)
        {
            int n=in.readInt(),k=in.readInt(),m=in.readInt();
            //Build(n);
            int[] a=new int[n+1];
            long sum=0;
            ArrayList<Integer>al=new ArrayList<Integer>();
            for(int i=1;i<=n;i++)
            {
                a[i]=in.readInt();
                min[i]=Integer.MAX_VALUE;
                if(a[i]<0)
                {
                    al.add(i);
                }
                sum+=a[i];
            }

            Node[]chef=new Node[m];
            for(int i=0;i<m;i++)
            {
                //UpdateSt(1,1,n,in.readInt(),in.readInt(),in.readInt());
                chef[i]=new Node(in.readInt(),in.readInt(),in.readInt());
            }
            Arrays.sort(chef, new Comparator<Node>()
            {
                @Override
                public int compare(Node o1, Node o2)
                {
                    return o1.c-o2.c;
                }
            });
            int[]ni=new int[n+1];

            for(int i=0;i<m;i++)
            {
                Node x=chef[i];
                for(int j=x.l;j<=x.r;j++)
                {
                    if(min[j]==Integer.MAX_VALUE)
                    {
                        min[j]=x.c;
                        ni[j]=x.r+1;
                    }
                    else
                    {
                        int nj=ni[j];
                        if(nj<=x.r)
                        {
                            j=nj-1;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
            }

            ArrayList<Integer> v=new ArrayList<Integer>();
            ArrayList<Integer> w=new ArrayList<Integer>();
            for(int i:al)
            {
                int x=min[i];
                if(x!=Integer.MAX_VALUE)
                {
                    w.add(x);
                    v.add(Math.abs((a[i])));
                }
            }

            for(int i=1;i<=w.size();i++)
            {
                for(int j=1;j<=k;j++)
                {
                    dp[i][j]=dp[i-1][j];
                    if(w.get(i-1)<=j)
                    {
                        dp[i][j]=Math.max(dp[i-1][j],v.get(i-1)+dp[i-1][j-w.get(i-1)]);
                    }
                }
            }
            sum+=dp[w.size()][k];
            out.printLine(sum);
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