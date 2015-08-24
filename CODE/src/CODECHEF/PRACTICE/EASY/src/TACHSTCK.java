import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Shreyans on 1/17/2015 using IntelliJ IDEA
 */

class TACHSTCK
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []s=br.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        long d=Long.parseLong(s[1]);
        long[] k=new long[n];
        for(int j=0;j<n;j++)
        {
            k[j]=Long.parseLong(br.readLine());
        }
        Arrays.sort(k);
        int cnt=0;
        for(int j=1;j<n;j+=2)
        {
            if(k[j]-k[j-1]<=d)
            {
                cnt++;
            }
            else
            {
                j--;//!!if it doesn't satisfy you cant directly skip to the next pair. You have to consider the present element int the next pair
            }
        }
        System.out.println(cnt);
    }
}


