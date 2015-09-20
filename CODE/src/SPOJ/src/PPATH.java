import java.io.*;
import java.util.*;

/**
 * Created by Shreyans Sheth [bholagabbar] on 9/16/2015 at 8:15 PM using IntelliJ IDEA (Fast IO Template)
 */

class PPATH
{
    static class Node
    {
        int f, s;
        Node(int f, int s)
        {
            this.f=f;
            this.s=s;
        }
    }

    static boolean primes[]=new boolean[10000];
    static boolean[] vis=new boolean[10000];

    static void PrimeSieve()
    {
        Arrays.fill(primes, true);
        primes[0]=primes[1]=false;
        for(int i=2;i<=Math.sqrt(10000);i++)
            if(primes[i])
                for(int j=i*i;j<10000;j+=i)
                    primes[j]=false;
    }

    static ArrayList<Integer> getPrimes(int x)
    {
        ArrayList<Integer> al=new ArrayList<Integer>();
        for(int i=0;i<4;i++)
            for(int j=0;j<10;j++)
            {
                StringBuilder sb=new StringBuilder(Integer.toString(x));
                int nn=Integer.parseInt(sb.replace(i,i+1,Integer.toString(j)).toString());
                if (!vis[nn] &&  nn>=1000 && nn<=9999 && primes[nn])
                    al.add(nn);
            }
        return al;
    }

    static int BFS(int x,int y)
    {
        Arrays.fill(vis,false);
        Queue<Node> q=new LinkedList<Node>();
        q.add(new Node(x,0));
        while(!q.isEmpty())
        {
            Node X=q.poll();
            int cn=X.f,cc=X.s;
            if(cn==y)
                return cc;
            for(int i:getPrimes(cn))
                if(!vis[i])
                {
                    vis[i]=true;
                    q.add(new Node(i,cc+1));
                }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception
    {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/Stdin_File_Read.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        PrimeSieve();
        int tc=in.readInt();
        while(tc-->0)
        {
            int x=in.readInt(),y=in.readInt();
            int ans=BFS(x,y);
            if(ans==-1)
                out.printLine("Impossible");
            else
                out.printLine(ans);
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