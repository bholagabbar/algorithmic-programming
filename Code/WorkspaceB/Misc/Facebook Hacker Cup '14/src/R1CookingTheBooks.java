import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 1/9/2015 using IntelliJ IDEA
 */

class R1CookingTheBooks
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<t;i++)
        {
            String kk=br.readLine();
            System.out.println("Case #"+(i+1)+": "+LO(kk.split(""))+" "+UP(kk.split("")));
        }

    }
    private static String LO(String[]a1)
    {
        String u="";
        int cnt=0;
        if(a1[0].equals("1"))
        {
            cnt++;
            while (a1[cnt].equals("0"))
            {
                cnt++;
                if(cnt==a1.length)
                {
                    break;
                }
            }
        }
        int lo=0;
        int flag=0;
        while(flag==0&&lo<10)
        {
            for(int j=cnt;j<a1.length;j++)
            {
                if((cnt!=0&&a1[j].equals(Integer.toString(lo)))||(cnt==0&&!a1[j].equals("0")&&a1[j].equals(Integer.toString(lo))))
                {
                    String temp=a1[cnt];
                    a1[cnt]=a1[j];
                    a1[j]=temp;
                    flag=1;
                    break;
                }
            }
            lo++;
        }
        for(String h:a1)
        {
            u+=h;
        }
        return(u);
    }
    private static String UP(String[]a)
    {
        String u="";
        int cnt=0;
        while(a[cnt].equals("9"))
        {
            cnt++;
            if(cnt==a.length)
            {
                break;
            }

        }
        int up=9;
        int flag=0;
        while(flag==0&&up>0)
        {
            for(int j=a.length-1;j>cnt;j--)
            {
                if(a[j].equals(Integer.toString(up)))
                {
                    String temp=a[cnt];
                    a[cnt]=a[j];
                    a[j]=temp;
                    flag=1;
                    break;
                }
            }
            up--;
        }
        for(String h:a)
        {
            u+=h;
        }
        //System.out.println("up="+u);
        return(u);
    }
}