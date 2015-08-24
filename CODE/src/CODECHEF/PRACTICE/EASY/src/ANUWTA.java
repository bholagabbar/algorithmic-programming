import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Shreyans on 1/30/2015 using IntelliJ IDEA
 */

class ANUWTA
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<t;i++)
        {
            BigInteger bi=new BigInteger(br.readLine());
            BigInteger ans=((bi.multiply(new BigInteger("3").add(bi))).divide(new BigInteger("2")));
            System.out.println(ans);
        }
    }
}
 

