package CODECHEF.PRACTICE.EASY.src;import java.util.*;

class HS08TEST
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int wit;
        double bal;
        wit=sc.nextInt();
        bal=sc.nextFloat();
        if(((wit>0)&&(wit<=2000))&&((bal>=0)&&(bal<=2000)))
        {
            if((bal>=((wit+0.5))&&(wit%5==0)))
            {
                double ans=Math.round(((bal-wit)-(0.50))*100.0)/100.0;
                System.out.println(ans);
            }
            else if(((wit+0.5)>bal))
            {
                bal=Math.round(bal*100.0)/100.0;
                System.out.println(bal);
            }
            else if(((int)wit%5!=0))
            {
                bal=Math.round(bal*100.0)/100.0;
                System.out.println(bal);
            }
        }
    }
}