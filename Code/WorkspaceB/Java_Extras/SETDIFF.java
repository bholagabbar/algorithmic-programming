import java.io.*;
import java.util.*;
import java.math.*;

//Created by Shreyans Sheth [bholagabbar] using Sublime 3

class SETDIFF
{//AC. FUCK. YEAH.
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        BigInteger two=BigInteger.valueOf(2L);
        BigInteger MOD=BigInteger.valueOf(1000000007L);
        BigInteger[] pow2=new BigInteger[100000];
        pow2[0]=BigInteger.ONE;
        for(int i=1;i<100000;i++)
        {
            pow2[i]=((pow2[i-1].mod(MOD)).multiply(two)).mod(MOD);
        }
        int tc=Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            int n=Integer.parseInt(br.readLine());
            String[] ln=br.readLine().split(" ");
            BigInteger[]nos=new BigInteger[n];
            for(int j=0;j<n;j++)
            {
                nos[j]=new BigInteger(ln[j]);
            }
            Arrays.sort(nos);
            BigInteger max=BigInteger.ZERO;
            BigInteger min=BigInteger.ZERO;
            for(int i=0;i<n;i++)
            {
                max=max.add((nos[i].multiply(pow2[i])).mod(MOD));
                min=min.add((nos[i].multiply(pow2[n-i-1])).mod(MOD));
            }
            pw.println(((max.mod(MOD)).subtract(min.mod(MOD))).mod(MOD));
            pw.flush();
        }
        pw.close();
    }
}