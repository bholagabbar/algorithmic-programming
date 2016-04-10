package CODECHEF.PRACTICE.EASY.src;import java.util.Scanner;
class HOLES
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int in=sc.nextInt();
        int st[]=new int[in];
        int cnt=0,cnt1=0;
        for(int i=0;i<in;i++)
        {
            String s=sc.next();
            for(int j=0;j<(s.length());j++)
            {
                char ch=s.charAt(j);
                ch=Character.toUpperCase(ch);
                if(ch=='A'||ch=='D'||ch=='O'||ch=='P'||ch=='Q'||ch=='R')
                {
                    cnt+=1;
                }
                else if(ch=='B')
                {
                    cnt+=2;
                }
            }
            st[cnt1]=cnt;
            cnt1++;
            cnt=0;
        }
        for(int i=0;i<cnt1;i++)
        {
            System.out.println(st[i]);
        }
    }
}