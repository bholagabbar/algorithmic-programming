import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by Shreyans on 1/31/2015 at 4:03 PM using IntelliJ IDEA
 */

class KNIGHTMV
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<t;i++)
        {
            String yo=br.readLine();
            char []a=yo.toCharArray();
            if(a.length==5&&(a[2]=='-')&&((int)a[0]>=97&&(int)a[0]<=104)&&((int)a[3]>=97&&(int)a[3]<=104)&&((int)a[1]>=49&&(int)a[1]<=56)&&((int)a[4]>=49&&(int)a[4]<=56))
            {
                int a1=a[1]-48,a2=a[4]-48;
                char b1=a[0],b2=a[3];
                int ax[]={a1+1,a1+2,a1+2,a1+1,a1-1,a1-2,a1-2,a1-1};
                char by[]={(char) (b1-2),(char)(b1-1),(char)(b1+1),(char)(b1+2),(char)(b1+2),(char)(b1+1),(char)(b1-1),(char)(b1-2)};
                int flag=0;
                //System.out.println("a2="+a2+" b2="+b2);
                for(int j=0;j<8;j++)
                {
                    //System.out.println("ch="+by[j]+" in="+ax[j]);
                    if(ax[j]==a2&&by[j]==b2)
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==1)
                {
                    sb.append("Yes\n");
                }
                else
                {
                    sb.append("No\n");
                }
            }
            else
            {
                sb.append("Error\n");
            }
        }
        pw.println(sb);
        pw.close();
    }
}
