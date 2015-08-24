import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Shreyans on 1/17/2015 using IntelliJ IDEA
 */

class RRCOPY
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            int n=Integer.parseInt(br.readLine());
            String[] s=br.readLine().split(" ");
            int[] nu=new int[n];
            for(int j=0;j<n;j++)
            {
                nu[j]=Integer.parseInt(s[j]);
            }
            Arrays.sort(nu);
            int buff=nu[0];
            int cnt=1;
            for(int j=1;j<n;j++)
            {
                if(nu[j]!=buff)
                {
                    cnt++;
                    buff=nu[j];
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}


