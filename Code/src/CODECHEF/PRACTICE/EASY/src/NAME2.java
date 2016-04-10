package CODECHEF.PRACTICE.EASY.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/6/2015 using IntelliJ IDEA
 */

class NAME2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            String a[]=br.readLine().split(" ");
            if(a[0].length()>a[1].length())
            {
                String temp=a[0];
                a[0]=a[1];
                a[1]=temp;
            }
            int cnt=0;
            int fl=a[0].length();
            int flag=0;
            for(int j=0;j<a[1].length();j++)
            {
                if(a[1].charAt(j)==a[0].charAt(cnt))
                {
                    cnt++;
                }
                if(cnt==fl)
                {
                    flag=1;
                    System.out.println("YES");
                    break;
                }
            }
            if(flag==0)
            {
                System.out.println("NO");
            }
        }
    }
}


