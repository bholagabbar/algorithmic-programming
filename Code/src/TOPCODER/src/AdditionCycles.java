/**
PROBLEM STATEMENT
Start with any integer between 00 and 99, inclusive, written as two 
digits (use a leading zero if the number is less than 10).  Add the 
two digits together.  Now concatenate the rightmost digit of the 
first number with the rightmost digit of the sum to get a new 
number.  If you repeat this process enough times, you'll end up back 
at the original number.  For example:

			    Combine Second Digits of
Start With    Add Digits    the Original and the Sum
------------------------------------------------------
    26     :   2+6 = 08   :   "6" and "8" = 68 
    68     :   6+8 = 14   :   "8" and "4" = 84
    84     :   8+4 = 12   :   "4" and "2" = 42
    42     :   4+2 = 06   :   "2" and "6" = 26

In this case, it took us 4 steps to get back to where we started, so 
we would return 4.  Starting with n, return the number of steps it 
takes to get back to n.

DEFINITION
Class:AdditionCycles
Method:cycleLength
Parameters:int
Returns:int
Method signature:int cycleLength(int n)


CONSTRAINTS
-n will be between 0 and 99, inclusive.


EXAMPLES

0)
26

Returns: 4

The example from the problem statement.  It goes 26->68->84->42->26, 
so there's 4 steps for the cycle.

1)
55

Returns: 3

The cycle is 55->50->05->55.  Remember to treat numbers under 10 as 
though there was a leading zero.

2)
0

Returns: 1

Zero comes back to zero at every step - so the length of the cycle 
is one (00->00)

3)
71

Returns: 12




Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
**/

public class AdditionCycles
{
    public static int cycleLength(int n)
    {
        String ans="-1";
        int f=n;
        int cnt=0;
        while(Integer.parseInt(ans)!=n)
        {
            String x=Integer.toString(f);
            if(x.length()==1)
            {
                x="0"+x;
            }
            int sum=x.charAt(0)-48+x.charAt(1)-48;
            ans=x.charAt(1)+(Integer.toString(sum % 10));
            f=Integer.parseInt(ans);
            //System.out.println(ans);
            cnt++;
        }
        //System.out.println(cnt);
        return cnt;
    }
}
