package CODECHEF.PRACTICE.EASY.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/16/2015 using IntelliJ IDEA
 */

class ATTIC
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<t;i++)
        {
            String s=br.readLine();
            int cnt=0;
            int d=0;
            for(int j=0;j<s.length();j++)
            {
                if(s.charAt(j)=='.')
                {
                    int x=(s.indexOf('#',j+1) - j);
                    if(x>cnt)
                    {
                        cnt=x;
                        d++;
                    }
                    j+=x-1;
                }
            }
            sb.append(d).append("\n");
        }
        System.out.println(sb);
    }
}

