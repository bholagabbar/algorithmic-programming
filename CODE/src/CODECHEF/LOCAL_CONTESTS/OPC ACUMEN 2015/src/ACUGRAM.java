import java.util.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class ACUGRAM
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            int n=Integer.parseInt(br.readLine());
            String []a=new String [n];
            for(int j=0;j<n;j++)
            {
                a[j]=br.readLine();
            }
            Arrays.sort(a);
            for(int j=0;j<n;j++)
            {
                System.out.println(a[j]);
            }
        }
    }
}