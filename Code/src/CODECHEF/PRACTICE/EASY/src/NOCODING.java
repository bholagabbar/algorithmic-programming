package CODECHEF.PRACTICE.EASY.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/16/2015 using IntelliJ IDEA
 */

class NOCODING
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<t;i++)
        {
            String a=br.readLine();
            int flen=(11*a.length());
            int stp=2;
            for(int j=1;j<a.length();j++)
            {
                char ch=a.charAt(j);
                if((int)ch<(int)(a.charAt(j-1)))
                {
                    stp+=26-((int)a.charAt(j-1)-(int)ch);
                }
                else
                {
                    stp+=(int)ch-(int)a.charAt(j-1);
                }
                stp++;
            }
            if(stp<=flen)
            {
                sb.append("YES\n");
            }
            else
            {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}