package CODECHEF.PRACTICE.EASY.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/6/2015 using IntelliJ IDEA
 */

class ERROR
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            String a=br.readLine();
            int flag=0;
            for(int j=0;j<a.length()-2;j++)
            {
                if((a.charAt(j)=='1'&&a.charAt(j+1)=='0'&&a.charAt(j+2)=='1')||(a.charAt(j)=='0'&&a.charAt(j+1)=='1'&&a.charAt(j+2)=='0'))
                {
                    System.out.println("Good");
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                System.out.println("Bad");
            }
        }
    }
}
