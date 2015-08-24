import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

class scratch
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        BigInteger two=new BigInteger("2");
        BigInteger[] pow2=new BigInteger[100000];
        BigInteger MOD=new BigInteger("1000000007");
        for(int i=0;i<10000;i++)
        {
            pow2[i]=(two.pow(i)).mod(MOD);
        }
        for(BigInteger x:pow2)
        {
            pw.println(x+",");
        }
    }
}