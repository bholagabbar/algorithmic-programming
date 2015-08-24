import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/8/2015 using IntelliJ IDEA
 */

class TOTR
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String a[]=br.readLine().split(" ");
        int n=Integer.parseInt(a[0]);
        String sm="";
        String cap="";
        for(int j=65;j<=90;j++)
        {
            sm+=(char)(j+32);
            cap+=(char)(j);
        }
        String nb="";
        //System.out.println(sm+" "+cap);
        for(int j=0;j<n;j++)
        {
            String b=br.readLine();
            for(int k=0;k<b.length();k++)
            {
                if((int)b.charAt(k)>=97&&(int)b.charAt(k)<=122)
                {
                    nb += a[1].charAt(sm.indexOf(b.charAt(k)));
                }
                else if((int)b.charAt(k)>=65&&(int)b.charAt(k)<=90)
                {
                    nb += Character.toUpperCase(a[1].charAt(cap.indexOf(b.charAt(k))));
                }

                else if(b.charAt(k)=='_')
                {
                    nb+=" ";
                }
                else
                {
                    nb+=b.charAt(k);
                }
            }
            System.out.println(nb);
            nb="";
        }
    }
}