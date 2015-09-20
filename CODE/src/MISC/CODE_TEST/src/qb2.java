import java.io.*;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shreyans Sheth [bholagabbar] on 8/30/2015 at 5:08 PM using IntelliJ IDEA (Fast IO Template)
 */

class qb2
{
    static class Node//Storing a pair of numbers
    {
        int x, y;
        Node(int x, int y)
        {
            this.x=x;
            this.y=y;
        }
    }

    static int[] cnt=new int[1000005];//Stores the number of times this vertex/volume is encountered
    static int[] steps=new int[1000005];//Steps taken to reach this vertex. Accumulated over all tries
    static int max;

    static void BFS(int x, int m)
    {
        boolean[] visited=new boolean[1000005];
        Queue<Node>q=new LinkedList<Node>();
        q.add(new Node(x, 0));//source
        while(!q.isEmpty())
        {
            Node curr=q.poll();
            int cv=curr.x;//Current vertex
            int cs=curr.y;//Current Steps
            if(!visited[cv] && cv<=max)
            {
                visited[cv]=true;
                cnt[cv]++;
                steps[cv]+=cs;
                q.add(new Node(x*m,cs+1));
                q.add(new Node(x/m,cs+1));
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        System.setIn(new FileInputStream("E:\\Shreyans\\Documents\\Code\\CODE\\src\\MISC\\CODE_TEST\\src\\qb2_t.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int t=in.readInt();
        int q=0;
        while(q++<t)
        {
            int n=in.readInt();
            int m=in.readInt();
            int[] a=new int[n];
            max=-1;
            for(int i=0;i<n;i++)
            {
                a[i]=in.readInt();
                max=Math.max(a[i],max);
            }
            for(int i=0;i<n;i++)
                BFS(a[i],m);//Running BFS on all volumes
            Node ans=new Node(Integer.MAX_VALUE,-1);//Stores the steps required by all volumes to reach this volume followed by the volume
            for(int i=0;i<=max;i++)
                if(cnt[i]==n && steps[i]<ans.x)
                {
                    ans.x=steps[i];
                    ans.y=i;
                }
            if(ans.x==Integer.MAX_VALUE)
                out.printLine(ans.y);
            else
            {
                out.printLine(ans.x+" "+ans.y);
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