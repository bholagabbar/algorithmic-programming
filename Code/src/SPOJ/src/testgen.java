package SPOJ.src;/* package whatever; // don't place package name! */

import java.util.Random;

/* Name of the class has to be "Main" only if the class is public. */
class testgen
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("10");
        Random randomGenerator = new Random();
        for(int i=0;i<10;i++)
        {
            int y=randomGenerator.nextInt((5000));
            System.out.println(y);
            for(int j=0;j<y;j++)
            {
                int x=2+randomGenerator.nextInt((10000000-2)+2);
                if(j<y-1)
                {
                    System.out.print(x+" ");
                }
                else
                {
                    System.out.print(x+"\n");
                }
            }
        }
    }
}