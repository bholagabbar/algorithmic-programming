import java.io.*;
import java.util.InputMismatchException;
import java.util.TreeMap;

/**
 * Created by Shreyans Sheth [bholagabbar] on 12/27/2015 at 11:33 PM using IntelliJ IDEA (Fast IO Template)
 */

class ABROADS
{

    static final int sz=500001;
    static int[] u=new int[sz];
    static int[] r=new int[sz];
    static int[] v1=new int[sz];
    static int[] v2=new int[sz];
    static long[] newPop=new long[sz];
    static long[] oldPop=new long[sz];
    static long[] ans=new long[sz];
    static boolean[] roadUsed=new boolean[sz];
    static TreeMap<Long, Integer> tm=new TreeMap<Long, Integer>();

    static class Query
    {
        char type;
        int x, y;
        Query(char type, int x)
        {
            this.type=type;
            this.x = x;
        }
        Query(char type, int x, int y)
        {
            this.type=type;
            this.x=x;
            this.y=y;
        }
    }

    static int FIND(int x)
    {
        if(u[x]!=u[u[x]])
            u[x]=FIND(u[x]);
        return u[x];
    }

    static boolean UNION (int x, int y)
    {
        int px=FIND(x),py=FIND(y);
        if(px==py)
            return false;

        if(r[px]>r[py])
        {
            int temp=px;
            px=py;
            py=temp;
        }

        else if(r[px]==r[py])
            r[py]++;

        //y is new parent

        //remove old pop of  px
        if(tm.get(newPop[px]) == 1)
            tm.remove(newPop[px]);
        else
            tm.put(newPop[px], tm.get(newPop[px])-1);

        //remove old pop of py
        if(tm.get(newPop[py]) == 1)
            tm.remove(newPop[py]);
        else
            tm.put(newPop[py], tm.get(newPop[py])-1);

        newPop[py] += newPop[px]; //set new pop

        //put new pop of combined
        if(!tm.containsKey(newPop[py]))
            tm.put(newPop[py], 1);
        else
            tm.put(newPop[py], tm.get(newPop[py])+1);

        //set new parent
        u[px]=py;

        return true;
    }


    public static void main(String[] args) throws Exception
    {
        System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/src/Stdin_File_Read.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int n=in.readInt(), m=in.readInt(), q=in.readInt();
        for(int i=1; i<=n; i++){
            u[i]=i;
            oldPop[i]=in.readLong();
        }
        for(int i=1; i<=m; i++)
        {
            v1[i]=in.readInt();
            v2[i]=in.readInt();
            roadUsed[i]=true;
        }
        Query[] Q=new Query[q+1];
        for(int i=1; i<=q; i++)
        {
            char ty=in.readString().charAt(0);
            if(ty=='P')
            {
                int city=in.readInt(), pop=in.readInt();
                newPop[city] = oldPop[city];
                oldPop[city] =pop;
                Q[i]=new Query(ty, city, pop);
            }
            else
            {
                int dontuse=in.readInt();
                roadUsed[dontuse]=false;
                Q[i]=new Query(ty, dontuse);
            }
        }

        for(int i=1; i<=n; i++) //adding the population
        {
            if(!tm.containsKey(oldPop[i]))
                tm.put(oldPop[i], 1);
            else
                tm.put(oldPop[i], tm.get(oldPop[i])+1);
        }

        for(int i=1; i<=m; i++)
            if(roadUsed[i])
                UNION(v1[i], v2[i]);

        for(int i=q; i>=1; i--)
        {
            ans[i] = tm.lastKey();
            if (Q[i].type == 'D')
                UNION(v1[Q[i].x], v2[Q[i].x]);
            else
            {
                int par = FIND(Q[i].x);

                //remove old pop
                if (tm.get(newPop[par])!=null && tm.get(newPop[par]) == 1)
                    tm.remove(newPop[par]);
                else
                    if(tm.get(newPop[par])!=null)
                        tm.put(newPop[par], tm.get(newPop[par]) - 1);

                //new pop
                newPop[par] += oldPop[par] - Q[i].y;

                //update
                if (!tm.containsKey(newPop[par]))
                    tm.put(newPop[par], 1);
                else
                    tm.put(newPop[par], tm.get(newPop[par]) + 1);
            }
        }
        for(int i=1; i<=q; i++)
            out.printLine(ans[i]);
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
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
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
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
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
            do {
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
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, readInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
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
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
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
            for (int i = 0; i < objects.length; i++) {
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