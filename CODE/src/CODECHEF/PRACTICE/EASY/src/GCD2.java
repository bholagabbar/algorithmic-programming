import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by Shreyans on 12/11/2014 in IntelliJ IDEA
 */
class GCD2
    {
    public static void main(String[] args) throws IOException
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t= Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
            {
            String[]s=(br.readLine()).split(" ");
            BigInteger b1=new BigInteger(s[0]);
            BigInteger b2=new BigInteger(s[1]);
            BigInteger b3;
            b3=GCD(b1, b2);
            System.out.println(b3);
            }
        }
        private static BigInteger GCD(BigInteger a1,BigInteger a2)
        {
            BigInteger a=new BigInteger(String.valueOf(a1));
            BigInteger b=new BigInteger(String.valueOf(a2));
            while((a.mod(b)).compareTo(BigInteger.ZERO)>0)
            {
                BigInteger r=new BigInteger(String.valueOf(a.mod(b)));
                a=b;
                b=r;
            }
            return(b);
        }
    }
/* SOLUTION in NICE since JAVA not allowed for the problem

import java.io.*;
import java.math.*;
import java.util.*;
import java.lang.*;
void main(String[] args)
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int t= Integer.parseInt(br.readLine());
StringTokenizer s;
for(int i=0;i {
s = new StringTokenizer(br.readLine());
BigInteger a = new BigInteger(s.nextToken());
BigInteger b = new BigInteger(s.nextToken());
while((a.mod(b)).compareTo(BigInteger.ZERO)>0)
        {BigInteger r=new BigInteger(String.valueOf(a.mod(b)));
        a=b;
        b=r;}
        System.out.println(b);}
}

*/
/*
while((a1.mod(b1)).compareTo(BigInteger.ZERO)>0)
            {
                BigInteger r=new BigInteger(String.valueOf(a1.mod(b1)));
                a1=b1;
                b1=r;
            }
            return(b1);
 */