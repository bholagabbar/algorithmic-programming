package CODECHEF.PRACTICE.EASY.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 11/21/2014 in IntelliJ 
 */
class MUFFINS3
    {
    public static void main(String[] args) throws IOException
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer();
        int t= Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
            {
            int n= Integer.parseInt(br.readLine());
            int  a=n/2;
            while((a*2)<=n)
                {
                a++;
                }
            sb.append(a+"\n");
            }
        System.out.println(sb);
        }
    }
