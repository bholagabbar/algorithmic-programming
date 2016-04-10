import java.io.*;
import java.util.*;

/**
 * Created by Shreyans on 3/25/2015 at 7:38 PM using IntelliJ IDEA (Fast IO Template)
 */

class ADJACENCY_LIST_IMPLEMENTED
{
    public static void main(String[] args) throws Exception
    {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        int v=in.readInt();//Inputting number of Vertices
        int e=in.readInt();//Inputting number of Edges
        ADJLIST adl=new ADJLIST(v);
        for(int i=0;i<e;i++)//Reading Edges in Graph Format : <source index> <destination index>
        {
            int s=in.readInt();//SOURCE
            int d=in.readInt();//DESTINATION
            adl.setEdge(s,d);
        }
        for(int i=1;i<=v;i++)
        {
            List <Integer> ev=adl.getEdge(i);
            out.print(i+"->");
            for(int j=0;j<ev.size();j++)
            {
                out.print(ev.get(j)+"->");
            }
            out.print("null \n");
        }
        {
            out.close();
        }
    }

    private static class ADJLIST// ADJACENCY LIST
    {
        /* Makes use of Map collection to store the adjacency list for each vertex.*/
        private Map<Integer, ArrayList<Integer>> Adjacency_List;

        /*
         * Initializes the map to with size equal to number of vertices in a graph
         * Maps each vertex to a given List Object
         */
        public ADJLIST(int number_of_vertices)
        {
            Adjacency_List = new HashMap<Integer, ArrayList<Integer>>();
            for (int i = 1; i <= number_of_vertices; i++)
            {
                Adjacency_List.put(i, new ArrayList<Integer>());
            }
        }
        /* Adds nodes in the Adjacency list for the corresponding vertex */
        public void setEdge(int source, int destination)
        {
            List<Integer> slist = Adjacency_List.get(source);
            slist.add(destination);
            List<Integer> dlist = Adjacency_List.get(destination);
            dlist.add(source);//assuming undirected
        }

        /* Returns the List containing the vertex joining the source vertex */
        public List<Integer> getEdge(int source)
        {
            return Adjacency_List.get(source);
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