/**
 * PROBLEM STATEMENT
 * A rotation of a string S is the operation of moving its first character to the end.
 * For example, if we rotate the string "abcde" we get the string "bcdea".
 * <p>
 * A cyclic shift of a string S is any string that can be obtained from S by a sequence of zero or
 * more rotations.
 * For example, the strings "abcde", "cdeab", and "eabcd" are some of the cyclic shifts of the string
 * "abcde".
 * <p>
 * Given two equally long strings, the smaller one is the one with a smaller character at the first
 * index where they differ.
 * For example, "cable" < "cards" because 'b' < 'r'.
 * <p>
 * You are given a String s of lowercase letters and an int k.
 * You are allowed to change at most k letters of s into some other lowercase letters.
 * Your goal is to create a string that will have the smallest possible cyclic shift.
 * Compute and return that cyclic shift.
 * <p>
 * DEFINITION
 * Class:Cyclemin
 * Method:bestmod
 * Parameters:String, int
 * Returns:String
 * Method signature:String bestmod(String s, int k)
 * <p>
 * <p>
 * CONSTRAINTS
 * -s will contain between 1 and 50 characters, inclusive.
 * -Each character in s will be between 'a' and 'z', inclusive.
 * -k will be between 0 and the length of s, inclusive.
 * <p>
 * <p>
 * EXAMPLES
 * <p>
 * 0)
 * "aba"
 * 1
 * <p>
 * Returns: "aaa"
 * <p>
 * We are allowed to change at most 1 character. Clearly, the optimal change is to change the 'b'
 * into an 'a'.
 * <p>
 * 1)
 * "aba"
 * 0
 * <p>
 * Returns: "aab"
 * <p>
 * We are not allowed to change anything. In this case, the answer is the smallest cyclic shift of
 * the given string s.
 * <p>
 * 2)
 * "bbb"
 * 2
 * <p>
 * Returns: "aab"
 * <p>
 * <p>
 * <p>
 * 3)
 * "sgsgaw"
 * 1
 * <p>
 * Returns: "aasgsg"
 * <p>
 * The optimal solution is to change the 'w' into an 'a', and then to take the cyclic shift that
 * starts with the last two letters of s.
 * <p>
 * 4)
 * "abacaba"
 * 1
 * <p>
 * Returns: "aaaabac"
 * <p>
 * <p>
 * <p>
 * 5)
 * "isgbiao"
 * 2
 * <p>
 * Returns: "aaaisgb"
 **/

import java.util.TreeSet;

/**
 Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
 **/

public class Cyclemin {
	public static String bestmod(String s, int k) {
		StringBuilder ts = new StringBuilder(s);
		TreeSet<String> ss = new TreeSet<String>();
		for (int i = 0; i < ts.length(); i++) {
			StringBuilder ts1 = new StringBuilder(ts.substring(i, ts.length())).append(ts.substring(0, i));
			char a = 'a';
			int k1 = k;
			if (k1 > 0) {
				for (int j = 0; j < ts1.length(); j++) {
					if (ts1.charAt(j) != a) {
						ts1.replace(j, j + 1, Character.toString(a));
						k1--;
					}
					if (k1 == 0) {
						break;
					}
				}
			}
			ss.add(String.valueOf(ts1));
		}
		return String.valueOf(ss.first());
	}
	
	public static void main(String args[]) {
		
	}
}
