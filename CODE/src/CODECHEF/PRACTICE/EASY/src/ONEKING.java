import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/5/2015 using IntelliJ IDEA
 */

class ONEKING
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            int n=Integer.parseInt(br.readLine());
            String[] c=new String[n];
            for(int j=0;j<n;j++)
            {
                c[j]=br.readLine();
            }
            int min=n;
            for(int k=0;k<n;k++)
            {
                int n1=Integer.parseInt(c[k].substring(0,(c[k].indexOf(" "))));
                int n2=Integer.parseInt(c[k].substring(c[k].indexOf(" ")+1,c[k].length()));
                int b=n;
                for(int l=0;l<n;l++)
                {
                    if(l!=k)
                    {
                        if(Integer.parseInt(c[l].substring(0, (c[k].indexOf(" "))))>=n1&&Integer.parseInt(c[l].substring(0,(c[k].indexOf(" "))))<=n2)
                        {
                            b--;
                        }
                    }
                }
                if(b<min)
                {
                    min=b;
                }
            }
            System.out.println(min);
        }
    }
}
 

