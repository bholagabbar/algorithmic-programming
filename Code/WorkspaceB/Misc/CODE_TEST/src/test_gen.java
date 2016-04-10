import java.io.*;
import java.util.*;

/**
 * Created by Shreyans Sheth [bholagabbar] on 8/30/2015 at 6:51 PM using IntelliJ IDEA (Fast IO Template)
 */

class test_gen
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
    static boolean start=true;
    static int[] cnt=new int[1000005];//Stores the number of times this vertex/volume is encountered
    static int[] steps=new int[1000005];//Steps taken to reach this vertex. Accumulated over all tries
    static int max;
    static int cnt1=0;

    static void BFS(int x, int m)
    {
        boolean[] visited=new boolean[1000005];
        Queue<Node> q=new LinkedList<Node>();
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
                q.add(new Node(x / m, cs + 1));
            }
        }
    }

    static void Answer(int n1, int m1, int[] a1, boolean b) throws Exception
    {
        OutputWriter ts=new OutputWriter(new FileOutputStream("C:\\Users\\User\\Desktop\\qb2_testdata.txt",true));
        OutputWriter as=new OutputWriter(new FileOutputStream("C:\\Users\\User\\Desktop\\qb2_ans.txt",true));
        if(start)
        {
            ts.printLine("30");
            start=false;
        }
        Arrays.fill(cnt,0);
        Arrays.fill(steps,0);
        int t = 1;
        while (t-->0)
        {
            int n = n1;
            int m = m1;
            int[] a = new int[n];
            max = -1;
            for (int i = 0; i < n; i++)
            {
                a[i] = a1[i];
                max = Math.max(a[i], max);
            }
            for (int i = 0; i < n; i++)
                BFS(a[i], m);//Running BFS on all volumes
            Node ans = new Node(Integer.MAX_VALUE, -1);//Stores the steps required by all volumes to reach this volume followed by the volume
            for (int i = 0; i <= max; i++)
                if (cnt[i] == n && steps[i] < ans.x)
                {
                    ans.x = steps[i];
                    ans.y = i;
                }
            if(b)//only answer
            {
                if(ans.x!=Integer.MAX_VALUE)
                {
                    ts.printLine(n + " " + m);
                    for (int i = 0; i < n; i++)
                        ts.printLine(a[i]);
                    cnt1++;
                    as.printLine(ans.x + " " + ans.y);
                    System.out.println(ans.x + " " + ans.y);
                }
            }
            else//can be asnwer or not
            {
                ts.printLine(n + " " + m);
                for (int i = 0; i < n; i++)
                    ts.printLine(a[i]);
                if(ans.x!=Integer.MAX_VALUE)
                {
                    cnt1++;
                    as.printLine(ans.x + " " + ans.y);
                    System.out.println(ans.x + " " + ans.y);
                }
                else
                {
                    as.printLine("-1");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
        int range1=10000;
        Random rand=new Random();
        int[] az={2,4,8};
        Answer(3,2,az,true);
        while(cnt1<19)
        {
            int temp=cnt1;
            int r1=rand.nextInt(range1)+1;
            //int r2=(rand.nextInt(range1))%100;
            int r2=2;
            int[] a=new int[r1];
            for(int j=0;j<r1;j++)
            {
                a[j]=rand.nextInt(range1)+1;
            }
            if(r2!=0)
               Answer(r1,r2,a,true);
            //if(cnt1>temp)
                System.out.println(cnt1);

        }
        for(int i=0;i<10;i++)
        {
            int r1=rand.nextInt(range1)+1;
            int r2=(rand.nextInt(range1))%100;
            int[] a=new int[r1];
            for(int j=0;j<r1;j++)
            {
                a[j]=rand.nextInt(range1)+1;
            }
            if(r2!=0)
                Answer(r1,r2,a,false);
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