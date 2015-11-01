/**
PROBLEM STATEMENT
Taro and Hanako have rabbits, and they want to assign a distinct integer to each rabbit so they 
can easily identify them.


The rabbits have expressed their preferences to Taro and Hanako. The i-th rabbit wants an integer 
between 1 and maxNumber[i], inclusive. Taro and Hanako must obey the preferences of all their 
rabbits.


Return the number of ways they can assign numbers to their rabbits, modulo 1,000,000,007. If it's 
impossible to assign distinct integers to the rabbits, return 0.

DEFINITION
Class:RabbitNumbering
Method:theCount
Parameters:int[]
Returns:int
Method signature:int theCount(int[] maxNumber)


CONSTRAINTS
-maxNumber will contain between 1 and 50 elements, inclusive.
-Each element of maxNumber will be between 1 and 1,000, inclusive.


EXAMPLES

0)
{5}

Returns: 5

They can assign any number between 1 and 5, inclusive, to the only rabbit.

1)
{4, 4, 4, 4}

Returns: 24

All permutations of {1, 2, 3, 4} are possible.

2)
{5, 8}

Returns: 35



3)
{2, 1, 2}

Returns: 0



4)
{25, 489, 76, 98, 704, 98, 768, 39, 697, 8, 56, 74, 36, 95, 87, 2, 968, 4, 920, 54, 873, 90}

Returns: 676780400




**/

import java.util.Arrays;

/**
Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
**/

public class RabbitNumbering
{
    public static long theCount(int[] maxNumber)
    {
        final int MOD=(int)(1e9)+7;
        Arrays.sort(maxNumber);
        int cnt=0;
        long ans=1;
        for(int i=0;i<maxNumber.length;i++)
        {
            if(maxNumber[i]-cnt==0)
                return 0;
            ans=(ans%MOD * (maxNumber[i]-cnt++)%MOD)%MOD;
        }
        return (int)ans;
    }

    public static void main(String args[])
    {
        int[] arr={25, 489, 76, 98, 704, 98, 768, 39, 697, 8, 56, 74, 36, 95, 87, 2, 968, 4, 920, 54, 873, 90};
        System.out.println(theCount(arr));
    }
}
