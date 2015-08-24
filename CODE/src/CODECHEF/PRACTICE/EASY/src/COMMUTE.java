import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/17/2015 using IntelliJ IDEA
 */

class COMMUTE
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            int n=Integer.parseInt(br.readLine());
            int time=0;
            for(int j=0;j<n;j++)
            {
                String[]s=br.readLine().split(" ");
                int x=Integer.parseInt(s[0]);
                int l=Integer.parseInt(s[1]);
                int f=Integer.parseInt(s[2]);
                if(time==x)
                {
                    time+=l;
                }
                else if(time<x)
                {
                    time+=(x-time)+l;
                }
                else if(time>x)
                {
                    int et=f+x;
                    while(et<time)
                    {
                        et+=f;
                    }
                    time+=(et-time)+l;
                }
            }
            sb.append(time+"\n");
        }
        System.out.println(sb);
    }
}