import java.io.*;
import java.util.*;

/**
 * Created by Shreyans Sheth [bholagabbar] on 12/24/2015 at 2:04 PM using IntelliJ IDEA (Fast IO Template)
 */

public class D
{

    static int n;
    static boolean f;
    static ArrayList<String> al=new ArrayList<String>();

    public static boolean Dfs(HashMap<String, Integer> hm, HashMap<String, Boolean> valid, String curr, int cnt)
    {
        if(hm.get(curr)==1) valid.put(curr,false);
        else hm.put(curr, hm.get(curr)-1);
        al.add(Character.toString(curr.charAt(0)));

        if(cnt==n)
        {
            al.add(Character.toString(curr.charAt(1)));
            al.add(Character.toString(curr.charAt(2)));
            return true;
        }

        for(String s: valid.keySet())
            if(valid.get(s) && s.charAt(0)==curr.charAt(1))
            {
                f|=Dfs(hm, valid, s, cnt+1);
                if(f) break;
            }

        if(!f) al.remove(al.size()-1);
        return f;
    }

    public static void main(String[] args) throws Exception
    {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        n=in.readInt();
        HashMap<String, Integer> hm=new HashMap<String, Integer>();
        for(int i=0;i<n;i++)
        {
            String s=in.readString();
            if(!hm.containsKey(s))hm.put(s,1);
            else hm.put(s, hm.get(s)+1);
        }
        Set<String> setUse=hm.keySet();
        HashMap<String, Boolean> use=new HashMap<String, Boolean>();
        TreeSet<String> it=new TreeSet<String>(hm.keySet());
        for(String curr: it)
        {
            HashMap<String, Integer> hm2=new HashMap<String, Integer>();
            hm2.putAll(hm);
            for(String s: setUse)
                use.put(s, true);
            if(Dfs(hm2, use, curr, 1))
            {
                out.printLine("YES");
                for(String s:al)
                    out.print(s);
                return;
            }
        }
        out.printLine("NO");
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