import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class STONES
    {
    public static void main(String[] args) throws IOException
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<t;i++)
            {
            String a=br.readLine();
            String b=br.readLine();
            int cnt=0;
            for(int j=0;j<b.length();j++)
                {
                for(int k=0;k<a.length();k++)
                    {
                    if(a.charAt(k)==b.charAt(j))
                        {
                        cnt++;
                        break;
                        }
                    }
                }
            sb.append(cnt+"\n");
            }
        System.out.println(sb);
        }
    }