import java.io.*;
import java.util.InputMismatchException;

/**
 * Created by Shreyans Sheth [bholagabbar] on 12/25/2015 at 11:54 AM using IntelliJ IDEA (Fast IO Template)
 */

public class Hamburgers
{

    static long[] minNeeded=new long[3];
    static long[] kitna=new long[3];
    static long[] paisaNeeded=new long[3];
    static long kitnaGareeb;

    private static boolean check(long val)
    {
        long nowNeeded=(val*(minNeeded[0]*paisaNeeded[0]+minNeeded[1]*paisaNeeded[1]+minNeeded[2]*paisaNeeded[2]));
        if(nowNeeded <= kitnaGareeb)
            return true;
        return false;
    }

    static long binarySearch()
    {
        long hi=(long)1e13;
        long lo=(long)0;
        while(hi>lo)
        {
            long mid=(lo)+(hi-lo+1)/2;
            if(!check(mid)) //Too much burger. Itna paisa nai hai. Lol bhikari saala
                hi=mid-1;
            else
                lo=mid;
            //System.out.println(lo+" "+hi);
        }
        return lo;
    }


    public static void main(String[] args) throws Exception
    {
        //System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        String s=in.readString();

        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='B')
                minNeeded[0]++;
            else if(s.charAt(i)=='S')
                minNeeded[1]++;
            else
                minNeeded[2]++;
        }
        kitna[0]=in.readInt();
        kitna[1]=in.readInt();
        kitna[2]=in.readInt();
        paisaNeeded[0]=in.readInt();
        paisaNeeded[1]=in.readInt();
        paisaNeeded[2]=in.readInt();
        kitnaGareeb=in.readLong();
        long cnt=0;

        while((kitna[0]>= minNeeded[0] && minNeeded[0]>0) && (kitna[1]>= minNeeded[1] &&minNeeded[1]>0)&& (kitna[2]>= minNeeded[2] && minNeeded[2]>0))
        {
            kitna[0]-=minNeeded[0];
            kitna[1]-=minNeeded[1];
            kitna[2]-=minNeeded[2];
            cnt++;
        }

        while((kitna[0]>0 && minNeeded[0]>0) ||( kitna[1]>0 && minNeeded[1]>0)|| (kitna[2]>0 && minNeeded[2]>0))
        {
            if(kitna[0]<minNeeded[0])
            {
                long req=(minNeeded[0]-kitna[0]);
                long paiseAbhi=req*paisaNeeded[0];
                kitnaGareeb-=paiseAbhi;
                kitna[0]=0;
            }
            else
            {
                kitna[0]-=minNeeded[0];
            }
            if(kitna[1]<minNeeded[1])
            {
                long req=(minNeeded[1]-kitna[1]);
                long paiseAbhi=req*paisaNeeded[1];
                kitnaGareeb-=paiseAbhi;
                kitna[1]=0;
            }
            else
            {
                kitna[1]-=minNeeded[1];
            }
            if(kitna[2]<minNeeded[2])
            {
                long req=(minNeeded[2]-kitna[2]);
                long paiseAbhi=req*paisaNeeded[2];
                kitnaGareeb-=paiseAbhi;
                kitna[2]=0;
            }
            else
            {
                kitna[2]-=minNeeded[2];
            }

            if(kitnaGareeb>=0) //Abe tu toh amir hai
            {
                cnt++;
            }
            else
            {
                out.printLine(cnt);
                return;
            }
        }
        //Now you got squat left in the kitchen
        //bsearch for burgers?
        long ans= binarySearch();
        ans+=cnt;
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