import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 12/11/2014 in IntelliJ IDEA
 */
class J7
    {
    public static void main(String[] args) throws IOException
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<t;i++)
            {
            String[] s1 = br.readLine().split(" ");
            double p = Double.parseDouble(s1[0]);
            double s = Double.parseDouble(s1[1]);
            double ans1 = Math.pow((Math.sqrt(24 * s) / 12), 3);
            double ans2 = Math.pow((p / 12), 3);
            ans1=Math.round(ans1*100.0)/100.0;;
            ans2=Math.round(ans2*100.0)/100.0;
            System.out.println(ans1+" "+ans2);
            }
        //System.out.println(sb);
        }
    }
