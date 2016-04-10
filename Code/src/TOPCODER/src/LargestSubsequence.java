/**
PROBLEM STATEMENT

For Strings x and y, we say y is a subsequence of x if y can be obtained from x by erasing some 
(possibly all or none) of the letters in x. For example, "tpcdr" is a subsequence of "topcoder", 
while "rt" is not. 

Given a String s, return the lexicographically largest subsequence of s. 


DEFINITION
Class:LargestSubsequence
Method:getLargest
Parameters:String
Returns:String
Method signature:String getLargest(String s)


NOTES
-For strings x and y, x is said to be lexicographically larger than y if y is a prefix of x or y 
has a smaller character than x at the first position where they differ. Order of characters is 
defined as the order of ASCII codes: 'a' < 'b' < ... < 'z'. 


CONSTRAINTS
-s will contain between 1 and 50 characters, inclusive. 
-Each character in s will be a lowercase letter ('a'-'z').


EXAMPLES

0)
"test"

Returns: "tt"

All subsequences listed in lexicographical order are "" (empty string), "e", "es", "est", "et", 
"s", "st", "t", "te", "tes", "test", "tet", "ts", "tst" and "tt". So return "tt".

1)
"a"

Returns: "a"

There are only two subsequences, "" and "a". 

2)
"example"

Returns: "xple"



3)
"aquickbrownfoxjumpsoverthelazydog"

Returns: "zyog"




**/

/**
Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
**/

public class LargestSubsequence
{
    public static String getLargest(String s)
    {
        char l=64;
        int pos=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)>l)
            {
                l=s.charAt(i);
                pos=i;
            }
        String ans="";
        ans+=s.charAt(s.length()-1);
        char prev=s.charAt(s.length()-1);
        for(int j=s.length()-2;j>=pos;j--)
        {
            if(s.charAt(j)>=prev)
            {
                ans+=s.charAt(j);
                prev=s.charAt(j);
            }
        }
        ans=new StringBuilder(ans).reverse().toString();
        System.out.println(ans);
        return ans;
    }

    public static void main(String args[])
    {
        LargestSubsequence l=new LargestSubsequence();
        l.getLargest("a");
    }
}
