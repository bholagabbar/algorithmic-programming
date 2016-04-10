/**
PROBLEM STATEMENT

A lucky number is a positive integer consisting of only the digits 4 and 7.



Given an int a, return an int b strictly greater than a, such that a XOR b is a lucky number. (See 
Notes for the definition of XOR.) The number b should be in the range 1 to 100, inclusive. If such 
a number does not exist, return -1. If there are multiple such b, you may return any of them.


DEFINITION
Class:LuckyXor
Method:construct
Parameters:int
Returns:int
Method signature:int construct(int a)


NOTES
-XOR is the bitwise exclusive-or operation. To compute the value of P XOR Q, we first write P and 
Q in binary. Then, each bit of the result is computed by applying XOR to the corresponding bits of 
the two numbers, using the rules 0 XOR 0 = 0, 0 XOR 1 = 1, 1 XOR 0 = 1, and 1 XOR 1 = 0.
-For example, let's compute 21 XOR 6. In binary these two numbers are 10101 and 00110, hence their 
XOR is 10011 in binary, which is 19 in decimal.
-You can read more about the XOR operation here: https://en.wikipedia.org/wiki/Exclusive_or


CONSTRAINTS
-a is between 1 and 100, inclusive.


EXAMPLES

0)
4

Returns: 40

4 XOR 40 = 44, 44 is a lucky number.

1)
19

Returns: 20

19 XOR 20 = 7

2)
88

Returns: 92

88 XOR 92 = 4

3)
36

Returns: -1




**/

/**
Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
**/

public class LuckyXor
{
    public static boolean lucky(int x)
    {
        while(x>0)
        {
            int y=x%10;
            if(y!=4 && y!=7)
                return false;
            x/=10;
        }
        return true;
    }


    public static int construct(int a)
    {
        for(int i=a+1;i<=100;i++)
        {
            int c=a^i;
            if(lucky(c))
                return i;
        }
        return -1;
    }

    public static void main(String args[])
    {
        //System.out.println(construct(4));
    }
}
