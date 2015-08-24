import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 12/5/2014 in IntelliJ 
 */
class LECANDY
    {
    public static void main(String[] args) throws IOException
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<t;i++)
            {
            String s1[]=(br.readLine()).split(" ");
            int n= Integer.parseInt(s1[0]);
            int c= Integer.parseInt(s1[1]);
            String s2[]=(br.readLine()).split(" ");
            int[] a =new int[s2.length];
            for(int j=0;j<s2.length;j++)
                {
                a[j]= Integer.parseInt(s2[j]);
                }
            int[]b=new int[n];
            int flag=1;
            for(int j=0;j<n;j++)
                {
                if(c-a[j]>=0)
                    {
                    c=c-a[j];
                    }
                else if(c-a[j]<0)
                    {
                    flag=0;
                    break;
                    }
                }
            if(flag==1)
                {
                sb.append("Yes"+"\n");
                }
            else
                {
                sb.append("No"+"\n");
                }

            }

        System.out.println(sb);
        }
    }
