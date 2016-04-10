import java.io.IOException;

/**
PROBLEM STATEMENT
You are given a int[] marks containing the grades you have received 
so far in a class. Each grade is between 0 and 10, inclusive.  
Assuming that you will receive a 10 on all future assignments, 
determine the minimum number of future assignments that are needed 
for you to receive a final grade of 10.  You will receive a final 
grade of 10 if your average grade is 9.5 or higher.


DEFINITION
Class:AimToTen
Method:need
Parameters:int[]
Returns:int
Method signature:int need(int[] marks)


CONSTRAINTS
-marks has between 1 and 50 elements, inclusive.
-Each element of marks is between 0 and 10, inclusive.


EXAMPLES

0)
{9, 10, 10, 9}

Returns: 0

Your average is already 9.5, so no future assignments are needed.

1)
{8, 9}

Returns: 4

In this case you need 4 more assignments. With each completed 
assignment, your average could increase to 9, 9.25, 9.4 and 9.5, 
respectively.

2)
{0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}

Returns: 950

3)
{10, 10, 10, 10}

Returns: 0


Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
**/

public class AimToTen
{
    public static int need(int[] marks)
    {
        int sum=0;
        for(int i=0;i<marks.length;i++)
        {
            sum+=marks[i];
        }
        double avg=(float)sum/marks.length;
        System.out.println(avg);
        if(avg<9.5)
        {
            double ans=19*marks.length-2*sum;
            return (int)ans;
        }
        else
        {
            return 0;
        }
    }

    public static void main(String[] args) throws IOException
    {
        int[]a={10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0, 5};
        System.out.println(need(a));
    }
}
