package CODECHEF.PRACTICE.EASY.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 12/11/2014 in IntelliJ IDEA
 */
class SNAPE
    {
    public static void main(String[] args) throws IOException
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<t;i++)
            {
            String s1[]=(br.readLine()).split(" ");
            double base=Double.parseDouble(s1[0]);
            double lhs= Double.parseDouble(s1[1]);
            double rhs0=Math.sqrt((lhs*lhs)-(base*base));
            double rhs1=Math.sqrt((lhs*lhs)+(base*base));
            rhs0=Math.round(rhs0*10000.0)/10000.0;
            rhs1=Math.round(rhs1*10000.0)/10000.0;
            sb.append(rhs0+" "+rhs1+"\n");
            }
        System.out.println(sb);
        }
    }
