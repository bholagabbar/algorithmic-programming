import java.io.*;
import java.util.StringTokenizer;


//TESTING CUSTOM IO

class ICPC_IO
{
    public static void main(String[] args) throws IOException
    {
        InputReader in=new InputReader(System.in);
        OutputWriter out=new OutputWriter(System.out);
        int[]ia=in.readIntArr();
        int n=ia[0];
        int k=ia[1];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            int x=in.readInt();
            if(x%k==0)
            {
                cnt++;
            }
        }
        out.printLine(cnt);
        {
            out.close();
        }
    }

    //IO
    public static class InputReader
    {
        private static BufferedReader br;

        InputReader(InputStream is)
        {
            br=new BufferedReader(new InputStreamReader(is));
        }

        public String readString() throws IOException
        {
            return br.readLine();
        }

        public int readInt() throws IOException
        {
            return Integer.parseInt(br.readLine());
        }

        public Long readLong() throws IOException
        {
            return Long.parseLong(br.readLine());
        }

        public Double readDouble() throws IOException
        {
            return Double.parseDouble(br.readLine());
        }
        public int[] readIntArr()throws IOException
        {
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            int[]a=new int[st.countTokens()];
            int cnt=0;
            while(st.hasMoreTokens())
            {
                a[cnt++]=Integer.parseInt(st.nextToken());
            }
            return a;
        }
        //Read char as String and take 1st index
    }

    public static class OutputWriter
    {
        private static PrintWriter pw;

        OutputWriter(OutputStream os)
        {
            pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)));
        }

        public void print(Object... objects)
        {
            for (int i = 0; i < objects.length; i++)
            {
                if (i != 0)
                    pw.print(' ');
                pw.print(objects[i]);
            }
            pw.flush();
        }

        public void printLine(Object... objects)
        {
            print(objects);
            pw.println();
            pw.flush();
        }

        public void close()
        {
            pw.close();
        }

    }

}