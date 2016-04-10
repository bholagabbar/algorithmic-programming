package CODECHEF.PRACTICE.EASY.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Shreyans on 1/16/2015 using IntelliJ IDEA
 */

class OJUMPS
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BigInteger n=new BigInteger(br.readLine());
        BigInteger s=new BigInteger("6");
        String sa=String.valueOf(n.mod(s));
        if(sa.equals("0")||sa.equals("1")||sa.equals("3")||sa.equals("6"))
        {
            System.out.println("yes");
        }
        else
        {
            System.out.println("no");
        }
    }
}


