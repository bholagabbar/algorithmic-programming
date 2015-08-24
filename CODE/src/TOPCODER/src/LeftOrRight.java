/**
PROBLEM STATEMENT
The Very Heterogeneous State of Feudalia's army is designing a new spy robot. Currently, the robot 
can only accept two commands: L and R. L moves the robot one unit of distance to the left, and R 
moves the robot one unit to the right. A program for the robot is a sequence of commands. For a 
given program, its reach is the distance between the starting point and the farthest point visited 
during the execution of the program. For example, the reach of the program "LLLR" is 3, because 
after the first three steps we reach a location 3 units away from the starting point.

Unfortunately, Feudalia is world famous for the ineptitude of its public officials. Some coffee 
was spilled all over the program before it could be installed to the robot. Therefore, some of the 
commands may now be illegible.
Your task is to repair the program by replacing each illegible command with an L or an R. 
If there are multiple ways to repair the program, you have to pick one that maximizes its reach.

You are given a String program which describes the program in its current state. The i-th 
character in program represents the i-th command that is executed and will be 'L', 'R' or '?' 
(quotes for clarity). 'L' represents a legible move left, 'R' a legible move right and '?' a 
command that is illegible so you can choose 'L' or 'R' in its place. Return the largest reach a 
repaired program can have.

DEFINITION
Class:LeftOrRight
Method:maxDistance
Parameters:String
Returns:int
Method signature:int maxDistance(String program)


CONSTRAINTS
-program will contain between 1 and 50 characters, inclusive.
-Each character of program will be 'L', 'R' or '?' (quotes for clarity).


EXAMPLES

0)
"LLLRLRRR"

Returns: 3

All commands are legible. The reach of this program is 3: both after three steps and after five 
steps we are 3 units to the left of the starting location.

1)
"R???L"

Returns: 4

We can replace all of the question marks with a right command.

2)
"??????"

Returns: 6



3)
"LL???RRRRRRR???"

Returns: 11



4)
"L?L?"

Returns: 4




**/

/**
Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
**/

public class LeftOrRight
{
    public static int maxDistance(String program)
    {
        int max=0;
        for(int i=program.length()-1;i>=0;i--)
        {
            if(program.charAt(i)=='R')
            {
                int cnt=1;
                int lim=0;
                for(int j=i-1;j>=0;j--)
                {
                    if(program.charAt(j)=='L')
                    {
                        lim=j;
                        System.out.print(program.charAt(i));
                        break;
                    }
                    else
                    {
                        cnt++;
                    }
                }
                if(cnt>max)
                {
                    max=cnt;
                }
                if(lim==0)
                {
                    break;
                }
                i=cnt+1;
            }
            else if(program.charAt(i)=='L')
            {
                int cnt=1;
                int lim=0;
                for(int j=i-1;j>=0;j--)
                {
                    if(program.charAt(j)=='R')
                    {
                        lim=j;
                        break;
                    }
                    else
                    {
                        System.out.print(program.charAt(i));
                        cnt++;
                    }
                }
                if(cnt>max)
                {
                    max=cnt;
                }
                if(lim==0)
                {
                    break;
                }
               i=cnt+1;
            }
            else
            {
                int cnt=1;
                char sym='?';
                int flag=0;
                int lim=0;
                for(int j=i-1;j>=0;j--)
                {
                    if(flag==0&&program.charAt(j)=='L'||program.charAt(j)=='R')
                    {
                        sym=program.charAt(j);
                        flag=1;
                    }
                    if(program.charAt(j)!='?'||program.charAt(j)!=sym)
                    {
                        lim=j;
                        break;
                    }
                    else
                    {
                        System.out.print(program.charAt(i));
                        cnt++;
                    }
                }
                if(cnt>max)
                {
                    max=cnt;
                }
                if(lim==0)
                {
                    break;
                }
               i=cnt+1;
            }
            System.out.println();
        }
        return max;
    }

    public static void main(String args[])
    {
        System.out.println(maxDistance("LL???RRRRRRR???"));
    }
}
