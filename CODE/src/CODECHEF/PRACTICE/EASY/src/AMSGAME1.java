import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 12/21/2014 in IntelliJ IDEA
 */
class AMSGAME1
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<t;i++)
        {
            int n=Integer.parseInt(br.readLine());
            String[] val=br.readLine().split(" ");
            if(n==1)
            {
                sb.append(val[0]+"\n");
            }
            else
            {
                int k=GCD(Integer.parseInt(val[0]),Integer.parseInt(val[1]));
                for(int j=2;j<n;j++)
                {
                    k=GCD(k,Integer.parseInt(val[j]));
                    if(k==1)
                    {
                        break;
                    }
                }
                sb.append(k+"\n");
            }
        }
        System.out.println(String.valueOf(sb).trim());
    }
    private static int GCD(int a1,int b1)
    {
        while(a1%b1!=0)
        {
            int r=a1%b1;
            a1=b1;
            b1=r;
        }
        return(b1);
    }
}
