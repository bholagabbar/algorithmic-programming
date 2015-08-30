import java.io.*;
import java.util.*;

/**
 * Created by Shreyans Sheth [bholagabbar] on 8/28/2015 at 11:23 PM using IntelliJ IDEA (Fast IO Template)
 */

class KINGCON
{
    static boolean[] visited=new boolean[3005];

    static void BFS(int s, int x, ArrayList<ArrayList<Integer>> a)
    {

        Queue<Integer> q=new LinkedList<Integer>();
        q.add(s);
        while(!q.isEmpty())
        {
            int cv=q.poll();
            for(int i:a.get(cv))
                if(i!=x && !visited[i])
                {
                    visited[i]=true;
                    q.add(i);
                }
        }
    }

    static boolean ArticulationPoint(int x, int n, ArrayList<ArrayList<Integer>> a)//x is the vertex to be missed
    {
        Arrays.fill(visited, 0, n + 1, false);
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            System.out.println(cnt);
            if (i != x)
            {
                if (cnt == 0 && !visited[i])
                {
                    BFS(i, x, a);
                    cnt++;
                } else if (cnt > 0 && !visited[i])
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException
    {
        System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/Stdin_File_Read.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int tc=in.readInt();
        while(tc-->0)
        {
            int n=in.readInt(),m=in.readInt(),k=in.readInt();
            ArrayList<ArrayList<Integer>>a=new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<n;i++)
                a.add(new ArrayList<Integer>());
            for(int i=0;i<m;i++)
            {
                int x=in.readInt(),y=in.readInt();
                a.get(x).add(y);
                a.get(y).add(x);
            }
            int cnt=0;
            for(int i=0;i<n;i++)
            {
                out.printLine(i);
                if(ArticulationPoint(i,n,a))
                    cnt+=k;
            }
            out.printLine(cnt);
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