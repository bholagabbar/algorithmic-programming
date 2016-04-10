package CODECHEF.PRACTICE.EASY.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Shreyans on 12/14/2014 in IntelliJ IDEA
 */
class LAPIN
    {
    public static void main(String[] args) throws IOException
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
            {
            String a=br.readLine();
            int n=a.length();
            int mid=n/2;
            String[]a1=new String[mid];
            String[]a2=new String[mid];
            if(n%2==0)
                {
                for (int j = 0; j < mid; j++)
                    {
                    a1[j] = Character.toString(a.charAt(j));
                    }
                int cnt1 = 0;
                for (int j = mid; j < n; j++)
                    {
                    a2[cnt1] = Character.toString(a.charAt(j));
                    cnt1++;
                    }
                }
            else
                {
                for(int j=0;j<mid;j++)
                    {
                    a1[j]=Character.toString(a.charAt(j));
                    }
                int cnt1=0;
                for(int j=mid+1;j<n;j++)
                    {
                    a2[cnt1]=Character.toString(a.charAt(j));
                    cnt1++;
                    }
                }
            Arrays.sort(a1);
            Arrays.sort(a2);
            int flag=1;
            for(int j=0;j<mid;j++)
                {
                if(a1[j].compareTo(a2[j])!=0)
                    {
                    flag=0;
                    break;
                    }
                }
            if(flag==1)
                {
                sb.append("YES\n");
                }
            else
                {
                sb.append("NO\n");
                }
            }
        System.out.println(String.valueOf(sb).trim());
        }
    }
