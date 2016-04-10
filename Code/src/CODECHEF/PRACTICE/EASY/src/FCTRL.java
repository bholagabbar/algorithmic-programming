package CODECHEF.PRACTICE.EASY.src;
        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
class FCTRL
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine());
        int st[]=new int[a];
        int cnt1=0;
        for(int i=0;i<a;i++)
        {
            int cnt=0,f=5,f1=1;
            int nos=Integer.parseInt(br.readLine());
            while(f1>0)
            {
                f1=(int)(nos/f);
                cnt=cnt+f1;
                f*=5;
            }
            st[cnt1]=cnt;
            cnt1++;
        }
        for(int i=0;i<a;i++)
        {
            System.out.println(st[i]);
        }
    }
}
