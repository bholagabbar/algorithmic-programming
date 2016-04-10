package CODECHEF.PRACTICE.EASY.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Shreyans on 12/15/2014 in IntelliJ IDEA
 */
class JOHNY
    {
    public static void main(String[] args) throws IOException
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<t;i++)
            {
            int n=Integer.parseInt(br.readLine());
            int[] a=new int[n];
            String[] s=br.readLine().split(" ");
            for(int j=0;j<s.length;j++)
                {
                a[j]= Integer.parseInt(s[j]);
                }
            int uj=a[Integer.parseInt(br.readLine())-1];
            Arrays.sort(a);
            int fi=1+(Arrays.binarySearch(a,uj));
            sb.append(fi+"\n");
            }
        System.out.println(String.valueOf(sb).trim());
        }
    }
