package CODECHEF.PRACTICE.EASY.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/8/2015 using IntelliJ IDEA
 */

class CLPERM
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            String a[]=br.readLine().split(" ");
            String b[]=br.readLine().split(" ");
            String[] an=new String[Integer.parseInt(a[0])];
            int cnt=0;
            for(int j=1;j<=Integer.parseInt(a[0]);j++)
            {
                if(!b[cnt].equals(Integer.toString(j)))
                {
                    an[j-1]=Integer.toString(j);
                }
                else
                {
                    an[j-1]="0";
                    cnt++;
                }
            }
            int flag1=1;
            int cnt2=0;
            while(flag1==1)
            {
                cnt=an.length-1;
                int sum=0;
                for (int j = 1; ; j++)
                {
                    if (Integer.parseInt(an[cnt])>j)
                    {
                        cnt--;
                    }
                    else if(Integer.parseInt(an[cnt])==j)
                    {
                        sum=j;
                        break;
                    }
                    else if(Integer.parseInt(an[cnt])<j)
                    {
                        int flag2=1;
                    }
                }
                if(flag1==1)
                {
                    cnt2++;
                }
                else
                {
                    break;
                }
            }

        }

    }
}
 

