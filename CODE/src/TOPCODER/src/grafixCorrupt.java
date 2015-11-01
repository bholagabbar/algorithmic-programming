/**
PROBLEM STATEMENT


In the grafix file format, a bitmap is encoded as a
sequence of lowercase alphabetic words. All of these words are drawn from
a dictionary that has been built specially for the bitmap by a compression
algorithm. Each word in the dictionary has the same length.





It can occur that words in a grafix file are corrupted by poor
transmission or storage media. In such cases, grafix attempts to
reconstruct the original file by matching each corrupted word to a
dictionary word that contains one or more of the same characters at the same
positions.




You are given a String[], dictionary, containing
every word in a grafix file's dictionary, and a String,
candidate, which is a possibly corrupted word in that file. If
there is no dictionary word that has at least one character in the
same position as candidate, then return the int
value -1. Otherwise, return the zero-based index of the dictionary word
that has the greatest number of characters at the same positions as
candidate. In the event of a tie, favor the lowest index.




DEFINITION
Class:grafixCorrupt
Method:selectWord
Parameters:String[], String
Returns:int
Method signature:int selectWord(String[] dictionary, String candidate)


CONSTRAINTS
-dictionary contains between 1 and 50 elements, inclusive
-candidate is between 1 and 20 characters long, inclusive
-each element of dictionary has the same length as candidate
-only the characters 'a' to 'z' are permitted in candidate and dictionary


EXAMPLES

0)
{"cat", "cab", "lab"}
"dab"

Returns: 1

The word "dab" has two letters in the same position as both "cab" and "lab", but "cab" comes first.

1)
{"cat", "cab", "lab"}
"lag"

Returns: 2

Here, "lab" is the best fit.

2)
{"cat", "cab", "lab"}
"bic"

Returns: -1

The word "bic" contains a 'c' and a 'b', but neither character is at the same position in any 
dictionary word.

3)
{"zkv", "izs", "fed", "waa", "ttx", "bgt", "quy", "dtq", "dgo", "yrs",
 "cid", "nln", "pvz", "txt", "zun", "erd", "jen", "klh", "kxy", "emf",
 "mqt", "lza", "dzb", "ndx", "vfr", "jhs", "dkm", "elb"}
"cwd"

Returns: 10

4)
{"zhadjsg", "vzptftx", "fbaslxs", "ejejncm", "xpxkeae", "ixrrtzw",
 "ovctbzx", "sfzekhh", "lxzixjk", "jixdpik", "bkianck", "laclyin",
 "uqmdkfx", "dimswqo", "fojhetr", "grntrce", "obdtqwx", "bhojwcy",
 "zuuuvst", "mvqtoly", "aftmupx", "govuidx", "qklpret", "yptccki",
 "uxdnslh", "wudrusz", "uwxbvou", "ouytqun", "pjdexqe", "xraaqdw",
 "lxmoncl", "sjnjfgb", "qrlqgvc", "fgvoadm", "yohsrxw", "udpvrsr",
 "mklucgt"}
"vklikgf"

Returns: 36


**/

/**
Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
**/

public class grafixCorrupt
{
    public static int selectWord(String[] dictionary, String candidate)
    {
        int ans=0,ret=-1;
        for(int j=0;j<dictionary.length;j++)
        {
            String s=dictionary[j];
            int cnt=0;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)==candidate.charAt(i))
                    cnt++;
            }
            if(cnt>ans)
            {
                ans=cnt;
                ret=j;
            }
        }
        return ret;
    }

    public static void main(String args[])
    {
        String[] a= {"cat", "cab", "lab"};
        System.out.println(selectWord(a,"dab"));
    }
}
