import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 12/16/2014 in IntelliJ IDEA
 */
class CHEFLUCK
    {
    public static void main(String[] args) throws IOException
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
            StringBuffer sb=new StringBuffer();
        for(int i=0;i<t;i++)
            {
                int n=Integer.parseInt(br.readLine());
                int ans=0;
                if(n%7==0)
                {
                        ans=n;
                }
                else
                {
                    int nf=0;
                    int ns=0;
                    ns=4;
                    nf=n-ns;
                    int cnt=1;
                    int flag=0;
                    while(nf>=7)
                    {
                    if(nf%7==0&&ns%4==0)
                    {
                        ans=nf;
                        flag=1;
                        break;
                    }
                        cnt++;
                        ns=4*cnt;
                        nf=n-ns;
                    }
                    if(flag==0)
                    {
                        if(n%4==0)
                        {
                            ans=0;
                        }
                        else
                        {
                            ans = -1;
                        }
                    }
                }

                sb.append(ans+"\n");
            }
            System.out.println(String.valueOf(sb).trim());
        }
    }
