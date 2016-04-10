package CODECHEF.COOK_OFFS.COOK54.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Shreyans on 1/18/2015 using IntelliJ IDEA
 */

class ANUBTG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            int n=Integer.parseInt(br.readLine());
            String[] a=br.readLine().split(" ");
            int[]no=new int[n];
            for(int j=0;j<a.length;j++)
            {
                no[j]=Integer.parseInt(a[j]);
            }
            Arrays.sort(no);
            int x=0;
            if(n==1)
            {
                System.out.println(no[0]);
            }
            else if(n==2)
            {
                System.out.println((no[0]+no[1]));
            }
            else if((n>2))
            {
                int sum=0;
                for(int j=n-1;j>=0;j-=4)
                {
                    if(j-1>-1)
                    {
                        sum += no[j] + no[j - 1];
                    }
                    else
                    {
                        sum+=no[j];
                    }
                    if(j-2>-1)
                    {
                        no[j-2]=0;
                    }
                    else
                    {
                        break;
                    }
                    if(j-3>-1)
                    {
                        no[j-3]=0;
                    }
                    else
                    {
                        break;
                    }
                }
                System.out.println(sum);
            }
        }
    }
}
