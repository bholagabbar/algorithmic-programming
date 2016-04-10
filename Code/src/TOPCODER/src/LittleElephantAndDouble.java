/**
PROBLEM STATEMENT

Little Elephant from the Zoo of Lviv likes integers.




You are given an int[] A. On a single turn, Little Elephant can double (i.e., multiply by 2) any 
element of A. He may double the same element more than once, if he wants to. He wants to obtain an 
array in which all elements are equal. Return "YES" (quotes for clarity) if it is possible to do 
that and "NO" otherwise.



DEFINITION
Class:LittleElephantAndDouble
Method:getAnswer
Parameters:int[]
Returns:String
Method signature:String getAnswer(int[] A)


NOTES
-The return value is case-sensitive. Make sure that you return the exact strings "YES" and "NO".


CONSTRAINTS
-A will contain between 1 and 50 elements, inclusive.
-Each element of A will be between 1 and 1,000,000,000, inclusive.


EXAMPLES

0)
{1, 2}

Returns: "YES"

One possible way of making all elements equal is to double the element at index 0.

1)
{1, 2, 3}

Returns: "NO"

It's impossible to make all three elements equal in this case.

2)
{4, 8, 2, 1, 16}

Returns: "YES"



3)
{94, 752, 94, 376, 1504}

Returns: "YES"



4)
{148, 298, 1184}

Returns: "NO"



5)
{7, 7, 7, 7}

Returns: "YES"




**/

import java.util.Arrays;

/**
Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
**/

public class LittleElephantAndDouble
{
    public static String getAnswer(int[] A)
    {
        Arrays.sort(A);
        int a=A[A.length-1];
        int flag=1;
        for(int i=0;i<A.length-1;i++)
        {
            while(A[i]<a)
            {
                A[i]=A[i]*2;
            }
            if(A[i]!=a)
            {
                flag=0;
                break;
            }
        }
        if(flag==1)
        {
            return("YES");
        }
        else
        {
            return ("NO");
        }
    }

    public static void main(String args[])
    {
        //
    }
}
