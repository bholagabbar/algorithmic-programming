/**
 * PROBLEM STATEMENT
 * When text is encoded using Huffman codes, each symbol is replaced by a string of 0s and 1s called
 * a bit string representation.  The replacement is done in such a way that the bit string
 * representation of a symbol is never the prefix of the bit string representation of any other
 * symbol.  This property allows us to unambiguously decode the encoded text.
 * You will be given a String archive and a String[] dictionary. The i-th element of dictionary will
 * be the bit string representation of the i-th uppercase letter. Decode archive using dictionary and
 * return the result as a single String.
 * <p>
 * DEFINITION
 * Class:HuffmanDecoding
 * Method:decode
 * Parameters:String, String[]
 * Returns:String
 * Method signature:String decode(String archive, String[] dictionary)
 * <p>
 * <p>
 * CONSTRAINTS
 * -archive will contain between 1 and 50 characters, inclusive.
 * -archive will contain only the characters '0' (zero) and '1' (one).
 * -dictionary will contain between 1 and 26 elements, inclusive.
 * -Each element of dictionary will contain between 1 and 50 characters, inclusive.
 * -Each element of dictionary will contain only the characters '0' (zero) and '1' (one).
 * -No element of dictionary will be a prefix of any other element of dictionary.
 * -archive will be decodable using dictionary
 * <p>
 * <p>
 * EXAMPLES
 * <p>
 * 0)
 * "101101"
 * {"00","10","01","11"}
 * <p>
 * Returns: "BDC"
 * <p>
 * Because there are no elements in dictionary that are prefixes of other elements, only one element
 * of dictionary will be a prefix of archive.  In this case, it is the second element ("10") which
 * represents 'B'.  The rest of the text can be decoded using the same logic.
 * <p>
 * 1)
 * "10111010"
 * {"0","111","10"}
 * <p>
 * Returns: "CBAC"
 * <p>
 * Note that elements of dictionary can be of different lengths.
 * <p>
 * 2)
 * "0001001100100111001"
 * {"1","0"}
 * <p>
 * Returns: "BBBABBAABBABBAAABBA"
 * <p>
 * '1' is replaced by 'A', '0' is replaced by 'B'.
 * <p>
 * 3)
 * "111011011000100110"
 * {"010","00","0110","0111","11","100","101"}
 * <p>
 * Returns: "EGGFAC"
 * <p>
 * 4)
 * "001101100101100110111101011001011001010"
 * {"110","011","10","0011","00011","111","00010","0010","010","0000"}
 * <p>
 * Returns: "DBHABBACAIAIC"
 **/

import java.util.HashMap;

/**
 Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
 **/

public class HuffmanDecoding {
	public static String decode(String archive, String[] dictionary) {
		HashMap<String, Character> hm = new HashMap<String, Character>();
		for (int i = 0; i < dictionary.length; i++) {
			hm.put(dictionary[i], (char) (i + 65));
		}
		String ans = "";
		for (int i = 0; i < archive.length(); i++) {
			for (int j = i + 1; j <= archive.length(); j++) {
				String cur = archive.substring(i, j);
				if (hm.containsKey(cur)) {
					System.out.println(cur);
					ans += hm.get(cur);
					i = j;
				}
			}
		}
		System.out.println(ans);
		return ans;
	}
	
	public static void main(String args[]) {
		
	}
}
