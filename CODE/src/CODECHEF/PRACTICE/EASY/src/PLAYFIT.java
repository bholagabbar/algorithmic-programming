import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/17/2015 using IntelliJ IDEA
 */

class PLAYFIT
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            int n=Integer.parseInt(br.readLine());
            String[] a=br.readLine().split(" ");
            int max = 0;
            for (int j =0; j <n-1; j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    if(Integer.parseInt(a[k])>Integer.parseInt(a[j]))
                    {
                        if(Integer.parseInt(a[k])-Integer.parseInt(a[j])>max)
                        {
                            max=Integer.parseInt(a[k])-Integer.parseInt(a[j]);
                        }
                    }
                    else
                    {
                        break;
                    }
                }
            }
            if(max==0)
            {
                sb.append("UNFIT\n");
            }
            else
            {
                sb.append(max+"\n");
            }
        }
        System.out.println(String.valueOf(sb).trim());
    }
}


