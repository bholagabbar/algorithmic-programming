/**
PROBLEM STATEMENT
A rotation of a string S is the operation of moving its first character to the end.
For example, if we rotate the string "abcde" we get the string "bcdea".

A cyclic shift of a string S is any string that can be obtained from S by a sequence of zero or 
more rotations.
For example, the strings "abcde", "cdeab", and "eabcd" are some of the cyclic shifts of the string 
"abcde".

Given two equally long strings, the smaller one is the one with a smaller character at the first 
index where they differ.
For example, "cable" < "cards" because 'b' < 'r'.

You are given a String s of lowercase letters and an int k.
You are allowed to change at most k letters of s into some other lowercase letters.
Your goal is to create a string that will have the smallest possible cyclic shift.
Compute and return that cyclic shift.

DEFINITION
Class:Cyclemin
Method:bestmod
Parameters:String, int
Returns:String
Method signature:String bestmod(String s, int k)


CONSTRAINTS
-s will contain between 1 and 50 characters, inclusive.
-Each character in s will be between 'a' and 'z', inclusive.
-k will be between 0 and the length of s, inclusive.


EXAMPLES

0)
"aba"
1

Returns: "aaa"

We are allowed to change at most 1 character. Clearly, the optimal change is to change the 'b' 
into an 'a'.

1)
"aba"
0

Returns: "aab"

We are not allowed to change anything. In this case, the answer is the smallest cyclic shift of 
the given string s.

2)
"bbb"
2

Returns: "aab"



3)
"sgsgaw"
1

Returns: "aasgsg"

The optimal solution is to change the 'w' into an 'a', and then to take the cyclic shift that 
starts with the last two letters of s.

4)
"abacaba"
1

Returns: "aaaabac"



5)
"isgbiao"
2

Returns: "aaaisgb"




**/

/**
Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
**/

public class Cyclemin
{
    public static String bestmod(String s, int k)
    {
        //Code here
    }

    public static void main(String args[])
    {
        
    }
}
