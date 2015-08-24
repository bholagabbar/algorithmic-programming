import java.io.*;
import java.text.DecimalFormat;
import java.util.InputMismatchException;

/**
 * Created by Shreyans Sheth [bholagabbar] on 6/3/2015 at 8:24 PM using IntelliJ IDEA (Fast IO Template)
 */


class MSTICK
{

    static int[]maxSt=new int[100003<<2];//Max SegTree
    static int[]minSt=new int[100003<<2];//Min SegTree
    static int[]arr=new int[100003];//Array with I/P

    public static void BuildMax(int node,int a,int b)
    {
        if(a>b)
            return;

        if(a==b)
        {
            maxSt[node]=arr[a];
            return;
        }

        BuildMax(2*node, a, (a+b)/2);
        BuildMax(2*node+1, 1+ (a+b)/2, b);

        maxSt[node]=Math.max(maxSt[2*node], maxSt[2*node +1 ]);
    }

    public static void BuildMin(int node,int a,int b)
    {
        if(a>b)
            return;

        if(a==b)
        {
            minSt[node]=arr[a];
            return;
        }

        BuildMin(2 * node, a, (a + b)/2);
        BuildMin(2 * node + 1, 1 + (a + b)/2, b);

        minSt[node]=Math.min(minSt[2 * node], minSt[2 * node + 1]);
    }

    public static int QueryMax(int node, int a,int b, int i,int j)//return maximum in hte min range
    {
        if(i>b || j<a ||a>b)
            return Integer.MIN_VALUE;

        if(i<=a && j>=b)
            return maxSt[node];

        return Math.max(QueryMax(2*node, a, (a+b)/2, i ,j), QueryMax(2*node +1 , 1+ (a+b)/2, b, i ,j));
    }

    public static int QueryMin(int node, int a,int b, int i,int j)//return maximum in hte min range
    {
        if(i>b || j<a ||a>b)
            return Integer.MAX_VALUE;

        if(i<=a && j>=b)
            return minSt[node];

        return Math.min(QueryMin(2 * node, a, (a + b) / 2, i, j), QueryMin(2 * node + 1, 1 + (a + b) / 2, b, i, j));
    }

    public static void main(String[] args) throws Exception
    {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/Stdin_File_Read.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out=new OutputWriter(System.out);
        int n=in.readInt();
        for(int i=0;i<n;i++)
        {
            arr[i]=in.readInt();
        }

        BuildMax(1,0,n-1);
        BuildMin(1,0,n-1);

        int q=in.readInt();
        while(q-->0)
        {
            int l=in.readInt();
            int r=in.readInt();

            int a=QueryMin(1,0,n-1,l,r);//Min of Middle part that was put on fire

            int b=QueryMax(1,0,n-1,0,l-1) + a;//Max Left Part plus time for a

            int c=QueryMax(1,0,n-1,r+1,n-1) + a;//Max Right Part plus time for a

            double d=a+ (double)(QueryMax(1,0,n-1,l,r)-a)/2;//a+ Max of mid part by 2

            double Maxt=Math.max(b,Math.max(c,d));

            DecimalFormat df=new DecimalFormat("0.0");

            out.printLine(df.format(Maxt));
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