package CODECHEF.PRACTICE.EASY.src;import java.util.Scanner;

class COMM3
    {
    public static void main(String[] args)
        {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
            {
            int r=sc.nextInt();
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            int x2=sc.nextInt();
            int y2=sc.nextInt();
            int x3=sc.nextInt();
            int y3=sc.nextInt();
            //System.out.println(x1+" "+x2+" "+y1+" "+y2+" "+x3+" "+y3);
            double ab=Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
            double bc=Math.sqrt(Math.pow(x3-x2,2)+Math.pow(y3-y2,2));
            double ac=Math.sqrt(Math.pow(x1-x3,2)+Math.pow(y1-y3,2));
            //System.out.println(ab+" "+ac+" "+bc);
            int flag=1;
            if(ab>r)
                {
                if(ac<=r&&bc<=r)
                    {
                    flag=1;
                    }
                else
                    {
                    flag=0;
                    }
                }
            if(flag==1&&ac>r)
                {
                if(ab<=r&&bc<=r)
                    {
                    flag=1;
                    }
                else
                    {
                    flag=0;
                    }
                }
            if(flag==1&&bc>r)
                {
                if(ab<=r&&ac<=r)
                    {
                    flag=1;
                    }
                else
                    {
                    flag=0;
                    }
                }
            if(flag==1)
                {
                System.out.println("yes");
                }
            else if(flag==0)
                {
                System.out.println("no");
                }
            }
        }
    }