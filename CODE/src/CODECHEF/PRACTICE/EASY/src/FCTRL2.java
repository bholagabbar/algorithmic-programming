import java.math.BigInteger;
import java.io.*;
class FCTRL2
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int in=Integer.parseInt(br.readLine());
        BigInteger st[]=new BigInteger[in];
        int cnt1=0;
        for(int i=1;i<=in;i++)
        {
            BigInteger f= new BigInteger("1");
            int b=Integer.parseInt(br.readLine());
            for(int j=2;j<=b;j++)
            {
                BigInteger j1= new BigInteger(Integer.toString(j));
                f=f.multiply(j1);
            }
            st[cnt1]=f;
            cnt1++;
        }
        for(int j=0;j<cnt1;j++)
        {
            System.out.println(st[j]);
        }
    }
}
