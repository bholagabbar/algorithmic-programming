/**
PROBLEM STATEMENT
Manao has a bitmap H pixels high and W pixels wide. Initially, each of the pixels is white. Manao 
draws several (possibly zero) horizontal and/or vertical strokes. A stroke is a line segment 1 
pixel thick and 1 or more pixels long. Manao only draws horizontal strokes with red color and 
vertical strokes with blue. He can paint a one pixel long stroke with either red or blue color, 
and the stroke will be considered horizontal if red and vertical if blue. Manao never draws two 
horizontal or two vertical strokes that overlap. If a horizontal stroke and a vertical stroke 
cross, the pixel at their intersection becomes green.

You're given a String[] picture denoting the bitmap after Manao's drawing experiments. The x-th 
character of the y-th element of picture describes the color of the pixel at coordinates (x, y) of 
the bitmap, where (0, 0) is the pixel at the top left corner and (W-1, H-1) is the pixel at the 
bottom right corner.  'R' is red, 'G' is green, 'B' is blue and '.' is white. Return the least 
possible number of strokes needed to obtain the given picture.

DEFINITION
Class:ColoredStrokes
Method:getLeast
Parameters:String[]
Returns:int
Method signature:int getLeast(String[] picture)


CONSTRAINTS
-picture will contain between 1 and 50 elements, inclusive.
-Each element of picture will be between 1 and 50 characters long, inclusive.
-All elements of picture will have equal length.
-Each character in picture will be 'R', 'G', 'B' or '.'.


EXAMPLES

0)
{"...",
 "..."}

Returns: 0

The picture is blank, Manao made no strokes.

1)
{"..B.",
 "..B."}

Returns: 1

A single vertical stroke is enough.

2)
{".BB."}

Returns: 2

Since only vertical strokes are painted with blue color, this picture needs two strokes.

3)
{"...B..",
 ".BRGRR",
 ".B.B.."}

Returns: 3

One horizontal and two vertical strokes are necessary for this masterpiece.

4)
{"...B..",
 ".BRBRR",
 ".B.B.."}

Returns: 4

This is the same picture as in the previous case with pixel (3,1) colored blue instead of green. 
Therefore, a single horizontal stroke won't help.

5)
{"GR",
 "BG"}

Returns: 4




**/

/**
Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
**/

public class ColoredStrokes
{
    static int One(int n, int m, char[][]grid, boolean gcount)
    {
        int cnt=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='R' || grid[i][j]=='G')
                {
                    cnt++;
                    int j1=j;
                    while(j1>=0 && (grid[i][j1]=='R')||(grid[i][j1]=='G'))
                    {
                        if(grid[i][j1]=='R')
                            grid[i][j1]='.';
                        else
                            grid[i][j1]='B';
                        j1--;
                        if(j1==-1)
                            break;
                    }
                    j1=j;
                    grid[i][j]='R';
                    while(j1<m && (grid[i][j1]=='R')||(grid[i][j1]=='G'))
                    {
                        //System.out.println(j1);
                        if(grid[i][j1]=='R')
                            grid[i][j1]='.';
                        else
                            grid[i][j1]='B';
                        j1++;
                        if(j1==m)
                            break;
                    }
                    for(int i11=0;i11<n;i11++)
                    {
                        for(int j11=0;j11<m;j11++)
                        {
                            System.out.print(grid[i11][j11]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
                else if(grid[i][j]=='B' ||  grid[i][j]=='G')
                {
                    cnt++;
                    int i1=i;
                    while(i1>=0 && (grid[i1][j]=='B'|| grid[i1][j]=='G'))
                    {
                        if(grid[i1][j]=='B')
                            grid[i1][j]='.';
                        else
                            grid[i1][j]='R';
                        i1--;
                        if(i1==-1)
                            break;
                    }
                    i1=i;
                    grid[i][j]='B';
                    while(i1<n && (grid[i1][j]=='B'|| grid[i1][j]=='G'))
                    {
                        if(grid[i1][j]=='B')
                            grid[i1][j]='.';
                        else
                            grid[i1][j]='R';
                        i1++;
                        if(i1==n)
                            break;
                    }
                    for(int i11=0;i11<n;i11++)
                    {
                        for(int j11=0;j11<m;j11++)
                        {
                            System.out.print(grid[i11][j11]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }
        return cnt;
    }

    public static int getLeast(String[] picture)
    {
        int n=picture.length,m=picture[0].length();
        char[][] grid=new char[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                grid[i][j]=picture[i].charAt(j);
        int ans=One(n, m, grid, false)+One(n, m, grid, true);
        System.out.println(ans);
        return ans;
    }

    public static void main(String args[])
    {
        String[] x={"...B..",
                    ".BRBRR",
                    ".B.B.."};
        getLeast(x);
    }
}
