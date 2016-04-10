package SPOJ.src;import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

class FCTRL2
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            int n=Integer.parseInt(br.readLine());
            BigInteger bi=BigInteger.ONE;
            for(int j=1;j<=n;j++)
            {
                bi=(bi.multiply(new BigInteger(Integer.toString(j))));
            }
            pw.println(bi);
        }
        pw.close();
    }
}