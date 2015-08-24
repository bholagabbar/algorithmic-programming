import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/4/2015 using IntelliJ IDEA
 */

class CHEFSTON
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<t;i++)
        {
            String[] s=br.readLine().split(" ");
            int n1=Integer.parseInt(s[0]);
            long k1=Long.parseLong(s[1]);
            String[] n=br.readLine().split(" ");
            String[] k=br.readLine().split(" ");
            long max=0,min=0;
            for(int j=0;j<n.length;j++)
            {
                min=k1/Long.parseLong(n[j]);
                if(min*Long.parseLong(k[j])>max)
                {
                    max=min*Integer.parseInt(k[j]);
                }
            }
            sb.append(max+"\n");
        }
        System.out.println(sb);
    }
}


