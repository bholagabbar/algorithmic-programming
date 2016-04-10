package CODECHEF.PRACTICE.EASY.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/8/2015 using IntelliJ IDEA
 */

class TAVISUAL
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            String []s=br.readLine().split(" ");
            //int n=Integer.parseInt(s[0]);
            int cp=Integer.parseInt(s[1]);
            int nf=Integer.parseInt(s[2]);
            for(int j=0;j<nf;j++)
            {
                //System.out.println(cp);
                String[] x=br.readLine().split(" ");
                int p1=Integer.parseInt(x[0]);
                int p2=Integer.parseInt(x[1]);
                if(cp>=p1&&cp<=p2)
                {
                    cp = p2 - (cp-p1);
                }
            }
            sb.append(cp+"\n");
        }
        System.out.println(sb);
    }
}


/*TLE BUT WORKS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class TAVISUAL
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            String []s=br.readLine().split(" ");
            int n=Integer.parseInt(s[0]);
            int cp=Integer.parseInt(s[1]);
            int nf=Integer.parseInt(s[2]);
            int a[]=new int[n];
            a[cp-1]=1;
            int fp=0;
            for(int j=0;j<nf;j++)
            {
                String[] x=br.readLine().split(" ");
                int p1=Integer.parseInt(x[0]);
                int p2=Integer.parseInt(x[1]);
                while(p1<p2)
                {
                    //System.out.println(p1+" "+p2);
                    if(a[p1-1]==1)
                    {
                        //System.out.println("1 found at "+(p1)+" and shifted to "+(p2));
                        a[p1-1]=0;
                        a[p2-1]=1;
                        fp=p2;
                        break;
                    }
                    else if(a[p2-1]==1)
                    {
                        //System.out.println("1 found at "+(p2)+" and shifted to "+(p1));
                        a[p2-1]=0;
                        a[p1-1]=1;
                        fp=p1;
                        break;
                    }
                    p1++;
                    p2--;
                }
            }
            System.out.println(fp);
        }

    }
}*/
 

