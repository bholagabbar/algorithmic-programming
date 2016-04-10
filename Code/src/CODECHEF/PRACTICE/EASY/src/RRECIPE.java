package CODECHEF.PRACTICE.EASY.src;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/8/2015 using IntelliJ IDEA
 */
//MODULO MEANS MODULUS IN EVERY ITERATION?!
class RRECIPE
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<t;i++)
        {
            String a=br.readLine();
            long cnt2=1;
            for(int j=0;j<((a.length()+1)/2);j++)
            {
                //System.out.println(j+" "+(a.length-1-j));
                if(a.charAt(j)=='?'&&a.charAt(a.length()-1-j)!='?'||a.charAt(j)!='?'&&a.charAt(a.length()-1-j)=='?')
                {
                }
                else if(a.charAt(j)=='?'&&a.charAt(a.length()-1-j)=='?')
                {
                    cnt2=cnt2*26;
                }

                else if((a.charAt(j)!='?'||a.charAt(a.length()-1-j)!='?')&&a.charAt(j)!=a.charAt(a.length()-1-j))
                {
                    cnt2=0;
                    break;
                }
                cnt2=cnt2%10000009;
            }
            sb.append(cnt2+"\n");
        }
        System.out.println(sb);
    }
}
 

