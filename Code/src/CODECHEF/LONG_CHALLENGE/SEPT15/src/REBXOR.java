package CODECHEF.LONG_CHALLENGE.SEPT15.src;import java.io.*;
import java.util.InputMismatchException;

/**
 * Created by Shreyans Sheth [bholagabbar] on 9/9/2015 at 6:20 PM using IntelliJ IDEA (Fast IO Template)
 */

class REBXOR
{
    static int[] pow=new int[32];

    static void Powersof2()//Pre-calculates powers of 2
    {
        pow[0]=1;
        for(int i=1;i<31;i++)
            pow[i]=2*pow[i-1];
    }

    static class Trie
    {
        /*Credits:

        -https://github.com/xennygrimmato/Data-Structures-and-Algorithms/blob/master/Trie/iterative_trie.cpp
        -http://threads-iiith.quora.com/Tutorial-on-Trie-and-example-problems
        */

        int next[][];
        boolean created[];
        final int MaxN=20000000;
        static int sz;
        Trie()
        {
            next=new int[2][MaxN];//Stores next node to go to
            created=new boolean[MaxN];
            sz=0;
            this.Insert(0);
        }

        void Insert(int x)
        {
            int v = 0,c;
            for (int i = 0; i<=30; ++i)
            {
                c=((x&(1<<(30-i))))>0?1:0;
                if (!created[next[c][v]])
                {
                    next[c][v] = ++sz;
                    created[sz] = true;
                }
                v = next[c][v];
            }
        }

        int XORQuery(int n) //Return Maximum Xor
        {
            int v=0;
            int x=0,c;
            for(int i=30;i>=0;i--)
            {
                c=(n&(1<<i))>0?0:1;
                if(!created[next[c][v]])
                    c=(c==1)?0:1;
                x+=pow[i]*c;
                v=next[c][v];
            }
            return x^n;
        }
    }

    public static void main(String[] args) throws Exception
    {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        Powersof2();
        Trie t1=new Trie();
        Trie t2=new Trie();
        int n=in.readInt();
        int ans=0,a1=0,a2=0,pre=0;
        int []startLeft=new int[n+1];
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=in.readInt();
            pre^=a[i];
            t1.Insert(pre);
            a1=Math.max(a1,t1.XORQuery(pre));
            startLeft[i]=a1;
        }
        pre=0;
        for(int i=n-1;i>0;i--)
        {
            pre^=a[i];
            t2.Insert(pre);
            a2=Math.max(a2,t2.XORQuery(pre));
            ans=Math.max(ans,startLeft[i]+a2);
        }
        out.printLine(ans);
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