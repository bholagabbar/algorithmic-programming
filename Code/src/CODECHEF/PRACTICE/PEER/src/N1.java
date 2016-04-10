package CODECHEF.PRACTICE.PEER.src;import java.io.*;
import java.util.*;

/**
 * Created by Shreyans on 5/2/2015 at 2:29 PM using IntelliJ IDEA (Fast IO Template)
 */

//ADD PUBLIC FOR CF,TC
class Node
{
    int x,y;
    Node(int x1,int y1)
    {
        x=x1;
        y=y1;
    }
}

class N1
{

    static char grid[][];
    static int distances[][];
    static int r=0,c=0,s1=0,s2=0,f1=0,f2=0;
    static int dx[]={1,-1,0,0};
    static int dy[]={0,0,-1,1};
    static Set<Node> points=new HashSet<Node>();
    static int flag=1;

    public static void main(String[] args) throws IOException
    {
        InputReader in=new InputReader(System.in);
        OutputWriter out=new OutputWriter(System.out);
        int t=in.readInt();
        for(int ixx=0;ixx<t;ixx++)
        {
            flag=1;
            r=in.readInt();
            if(r==1)
            {
                in.readString();
                out.printLine("0");
                out.flush();
                continue;
            }
            c=r;
            grid=new char[r][c];
            distances=new int[r][c];
            points.clear();
            for(int i=0;i<r;i++)
            {
                char[]x1=in.readString().toCharArray();
                for(int j=0;j<c;j++)
                {
                    grid[i][j]=x1[j];
                    if(x1[j]=='*')
                    {
                        points.add(new Node(i,j));
                    }
                }
            }//built grid
            s1=s2=0;
            distances[s1][s2]=0;//for 0,0
            int ansd=0;
            while(!points.isEmpty())
            {
                for(int i=0;i<r;i++)
                {
                    for (int j = 0; j < c; j++)
                    {
                        distances[i][j]=0;
                        if(grid[i][j]=='V')//Visited
                        {
                            grid[i][j]='.';
                        }
                    }
                }
                distances[s1][s2]=0;
                int dis=BFS();
                if(dis!=-1)
                {
                    ansd += dis;
                    //System.out.println("CURR DIS: "+ansd);
                }
                else
                {
                    out.printLine("-1");
                    flag = 0;
                    break;
                }
            }
            if(flag==1)
            {
                for(int i11=0;i11<r;i11++)
                {
                    for(int j1=0;j1<c;j1++)
                    {
                        if(grid[i11][j1]=='V')
                        {
                            grid[i11][j1]='.';
                        }
                        distances[i11][j1]=0;
                    }
                }
                f1=r-1;f2=c-1;
                grid[f1][f2]='*';
                int x=BFS();
                if(x!=-1)
                {
                    out.printLine((ansd+x));
                }
                else
                {
                    out.printLine("-1");
                }
            }
            out.flush();
        }
        out.close();
    }

    public static int BFS()
    {
        //Debugging down below. Give grid correctly according to concept

        //System.out.println("SOURCE IS:"+(s1+1)+","+(s2+1));
        /*for(int i2=0;i2<r;i2++)
        {
            for (int j1 = 0; j1 < c; j1++)
            {
                //if(grid[i1][j1]=='V')
                {
                    System.out.print(grid[i2][j1]);
                }
            }
            System.out.println();
        }*/
        Queue<Node>q=new LinkedList<Node>();
        q.add(new Node(s1,s2));
        while(!q.isEmpty())
        {
            Node p=q.poll();
            for(int i=0;i<4;i++)
            {
                if(((p.x+dx[i]>=0)&&(p.x+dx[i]<r))&&((p.y+dy[i]>=0)&&(p.y+dy[i]<c))&&(grid[p.x+dx[i]][p.y+dy[i]]!='#'))
                {//If point is in range
                    int cx,cy;
                    cx=p.x+dx[i];
                    cy=p.y+dy[i];
                    distances[cx][cy]=distances[p.x][p.y]+1;//Distances
                    if(grid[cx][cy]=='*')//destination
                    {
                        for(Node rm:points)// finding the node and removing it
                        {
                            if(rm.x==cx&&rm.y==cy)
                            {
                                points.remove(rm);
                                break;
                            }
                        }
                        grid[cx][cy]='.';//It i walkable again
                        s1=cx;s2=cy;//next source set
                        return distances[cx][cy];
                    }
                    else if(grid[cx][cy]=='.')//Normal tile. Now setting to visited
                    {
                        grid[cx][cy]='V';//Adding to visited
                        q.add(new Node(cx,cy));
                    }
                }
            }
        }
        return -1;
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