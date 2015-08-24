import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/2/2015 using IntelliJ IDEA
 */

class TIDRICE
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<t;i++)
        {
            int n=Integer.parseInt(br.readLine());
            String[] a=new String[n];
            for(int j=0;j<n;j++)
            {
                a[j]=br.readLine();
            }
            int cnt=0;
            for(int j=n-1;j>=0;j--)
            {
                if(!a[j].equals(""))
                {
                    if(a[j].charAt(a[j].length()-1)=='+')
                    {
                        cnt++;
                    }
                    else
                    {
                        cnt--;
                    }
                    String chk=a[j].substring(0,a[j].length()-2);
                    for(int k=j;k>=0;k--)
                    {
                        if(!a[k].equals(""))
                        {
                            if (chk.equals(a[k].substring(0, a[k].length() - 2)))
                            {
                                a[k] = "";
                            }
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}


