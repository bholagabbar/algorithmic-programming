package CODECHEF.PRACTICE.PEER.src;import java.io.*;
import java.util.*;

/**
 * Created by Shreyans on 4/30/2015 at 10:27 PM using IntelliJ IDEA (Fast IO Template)
 */

//ADD PUBLIC FOR CF,TC
class BYTESD
{
    static int r,c,s1,s2,f1,f2;//Rows, Columns, Start Coordinates, Finish Coordinates
    static int[] dx={1,-1,0,0};//right, left, NA, NA
    static int[] dy={0,0,1,-1};//NA, NA, bottom, top
    static char[][] grid;//Main grid
    static boolean visited[][];
    public static void main(String[] args)
    {
        InputReader in = new InputReader(System.in);
        OutputWriter out=new OutputWriter(System.out);
        int t=in.readInt();
        for(int i1=0;i1<t;i1++)
        {
            r = in.readInt();
            c = in.readInt();
            grid = new char[r][c];
            visited=new boolean[r][c];
            int flag1 = 0, flag2 = 0;
            for (int i = 0; i < r; i++)
            {
                char[] sx = in.readString().toCharArray();//Reading a line of the Grid
                for (int j = 0; j < sx.length; j++)
                {
                    if (flag1==0&& sx[j]=='s')
                    {
                        s1 = i;
                        s2 = j;
                        flag1 = 1;
                    }
                    if (flag2 == 0 && sx[j] == 'f')
                    {
                        f1 = i;
                        f2 = j;
                        flag2 = 1;
                    }
                }
            }
            if (MAZEBFS())
            {
                grid[s1][s2]='s';
                for (int i = 1; i < r; i++)
                {
                    for (int j = 0; j < c; j++)
                    {
                        if(visited[i][j])
                        {
                            if(grid[i][j]!='s'&&grid[i][j]!='f')
                            {
                                out.print('b');
                            }
                            else
                            {
                                out.print(grid[i][j]);
                            }
                        }
                        else
                        {
                            out.print('-');
                        }
                    }
                    out.printLine();
                }
            }
            else
            {
                out.printLine("The path doesn't exist.");
            }
            out.flush();
        }
        out.close();
    }
    private static boolean MAZEBFS()
    {
        // else
        {
            visited [s1][s2]=visited [f1][f2]=true;
            Queue<int[]> q=new LinkedList<int[]>();
            int[]start={s1,s2};//Start Coordinates
            q.add(start);//Adding start to the queue since we're already visiting it
            grid[s1][s2]='w';
            while(q.peek()!=null)
            {
                int[]curr=q.poll();//poll or remove. Same thing
                visited [curr[0]][curr[1]]=true;
                for(int i=0;i<4;i++)//for each direction
                {
                    if((curr[0]+dx[i]>=0&&curr[0]+dx[i]<r)&&(curr[1]+dy[i]>=0&&curr[1]+dy[i]<c))
                    {
                        //Checked if x and y are correct. ALL IN 1 GO
                        int xc=curr[0]+dx[i];//Setting current x coordinate
                        int yc=curr[1]+dy[i];//Setting current y coordinate
                        if(grid[xc][yc]=='f')//Destination found
                        {
                            //System.out.println(xc+" "+yc);
                            return true;
                        }
                        else if(grid[xc][yc]=='b')//Movable. Can't return here again so setting it to 'w' now
                        {
                            //System.out.println(xc+" "+yc);
                            grid[xc][yc]='w';//now BLOCKED
                            int[]temp={xc,yc};
                            q.add(temp);//Adding current coordinates to the queue
                        }
                    }
                }
            }
            return false;//Will return false if no route possible
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
        }

        public void printLine(Object... objects)
        {
            print(objects);
            writer.println();
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