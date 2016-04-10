package CODECHEF.PRACTICE.EASY.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 12/10/2014 in IntelliJ 
 */
class CONFLIP
    {
    public static void main(String[] args) throws IOException
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
            {
            int g=Integer.parseInt(br.readLine());
            for(int j=0;j<g;j++)
                {
                String[] s=(br.readLine()).split(" ");
                int l= Integer.parseInt(s[0]);
                int n= Integer.parseInt(s[1]);
                int q= Integer.parseInt(s[2]);
                int ans=0;
                if(l==1)
                    {
                    if(q==1)
                        {
                        ans=n/2;
                        }
                    else
                        {
                        if(n%2==0)
                            {
                            ans=n/2;
                            }
                        else
                            {
                            ans=(n/2) +1;
                            }
                        }
                    }
                else
                    {
                    if(q==2)
                        {
                        ans=n/2;
                        }
                    else
                        {
                        if(n%2==0)
                            {
                            ans=n/2;
                            }
                        else
                            {
                            ans=(n/2) +1;
                            }
                        }
                    }
                System.out.println(ans);
                }
            }
        }
    }