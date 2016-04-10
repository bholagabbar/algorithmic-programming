package CODECHEF.PRACTICE.EASY.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/8/2015 using IntelliJ IDEA
 */

class ANUDTC
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            long a=Integer.parseInt(br.readLine());
            String ans="";
            if(360%a==0)
            {
                ans+="y ";
            }
            else
            {
                ans+="n ";
            }
            if(a<=360)
            {
                ans+="y ";
            }
            else
            {
                ans+="n ";
            }
            if((a*(a+1)/2)<=360)
            {
                ans+="y";
            }
            else
            {
                ans+="n";
            }
            System.out.println(ans);
        }
    }
}
 

