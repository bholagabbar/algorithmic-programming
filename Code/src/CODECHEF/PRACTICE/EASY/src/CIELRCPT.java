package CODECHEF.PRACTICE.EASY.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 11/23/2014 in IntelliJ 
 */
class CIELRCPT
    {
    public static void main(String[] args) throws IOException
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        int[] et=new int[12];
        int ei=0;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<12;i++)
            {
            et[i]=(int)Math.pow(2,ei);
            ei++;
            }
        for(int i=0;i<t;i++)
            {
            int n= Integer.parseInt(br.readLine());
            int cnt=0;
            int mi=11;
            while((n>-1)&&(mi>-1))
                {
                if(n-et[mi]>=0)
                    {
                    n=n-et[mi];
                    cnt++;
                    }
                else
                    {
                    mi--;
                    }
                }
            System.out.println(cnt);
            }
        }
    }
