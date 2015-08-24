import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 12/12/2014 in IntelliJ IDEA
 */
class DECSTR
    {
    public static void main(String[] args) throws IOException
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
            {
            int k=Integer.parseInt(br.readLine());
            String a="";
            int cnt=0;
            int k2=k;
            if((k==50)||(k==75)||(k==100))
                {
                while (a.length() != k + 1)
                    {
                    a += (char) (97 + cnt);
                    cnt++;
                    if (cnt == 26)
                        {
                        break;
                        }
                    }
                if(k==50)
                    {
                    a=a+a;
                    }
                else if(k==75)
                    {
                    a=a+a+a;
                    }
                else if(k==100)
                    {
                    a=a+a+a+a;
                    }
                }
            else
                {
                while (a.length() != k + 1)
                    {
                    a += (char) (97 + cnt);
                    cnt++;
                    if (cnt == 26)
                        {
                        if (k2 % 25 == 0)
                            {
                            cnt = 0;
                            } else
                            {
                            cnt = 0;
                            k++;
                            }
                        }
                    }
                }
            StringBuffer sb = new StringBuffer(a);
            System.out.println(sb.reverse());
            }
        }
    }
