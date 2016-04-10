package CODECHEF.PRACTICE.EASY.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by shreyans on 26/1/15 at 11:54 AM using IntelliJ IDEA
 */
class ROWCOLOP
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] in=br.readLine().split(" ");
        int s=Integer.parseInt(in[0]);
        int o=Integer.parseInt(in[1]);
        int[]r =new int[s];
        int[]c =new int[s];
        int maxr=0,maxc=0;
        for(int i=0;i<o;i++)
        {
            String[] a=br.readLine().split(" ");
            int x=Integer.parseInt(a[1])-1;
            int v=Integer.parseInt(a[2]);
            if(a[0].equals("RowAdd"))
            {
                r[x]+=v;
                if(r[x]>maxr)
                {
                    maxr=r[x];
                }
            }
            else
            {
                c[x]+=v;
                if(c[x]>maxc)
                {
                    maxc=c[x];
                }
            }
        }
        System.out.println(maxr+maxc);
        //Hence in a grid, increment of rows is independant to increment in columns.
        // You have to add the max to cget the correct answer. This applies to find the max element in the grid.
    }
}





/* TOO MUCH MEMORY

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ROWCOLOP
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] in=br.readLine().split(" ");
        int s=Integer.parseInt(in[0]);
        int c=Integer.parseInt(in[1]);
        int[][] g=new int[s][s];
        int max=0;
        for(int i=0;i<c;i++)
        {
            String[] a=br.readLine().split(" ");
            int roc=Integer.parseInt(a[1])-1;
            int v=Integer.parseInt(a[2]);
            if(a[0].equals("RowAdd"))
            {
                for(int j=0;j<s;j++)
                {
                    g[roc][j]+=v;
                    if(g[roc][j]>max)
                    {
                        max=g[roc][j];
                    }
                }
            }
            else
            {
                for(int j=0;j<s;j++)
                {
                    g[j][roc]+=v;
                    if(g[j][roc]>max)
                    {
                        max=g[j][roc];
                    }
                }
            }
        }
        System.out.println(max);
    }
} */
