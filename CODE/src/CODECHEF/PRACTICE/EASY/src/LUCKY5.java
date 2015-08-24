import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/16/2015 using IntelliJ IDEA
 */

class LUCKY5
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            String a=br.readLine();
            a=a.trim();
            int cnt=0;
            for(int j=0;j<a.length();j++)
            {
                if(a.charAt(j)!='4'&&a.charAt(j)!='7')
                {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
 

