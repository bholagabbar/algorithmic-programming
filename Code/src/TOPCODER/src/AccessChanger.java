/**
 * PROBLEM STATEMENT
 * You are converting old code for a new compiler version. Each "->"
 * string should be replaced by ".", but this replacement shouldn't be
 * done inside comments. A comment is a string that starts with "//"
 * and terminates at the end of the line.
 * You will be given a String[] program containing the old code.
 * Return a String[] containing the converted version of the code.
 * <p>
 * <p>
 * DEFINITION
 * Class:AccessChanger
 * Method:convert
 * Parameters:String[]
 * Returns:String[]
 * Method signature:String[] convert(String[] program)
 * <p>
 * <p>
 * CONSTRAINTS
 * -program will have between 1 and 50 elements, inclusive.
 * -Each element of program will contain between 1 and 50 characters,
 * inclusive.
 * -Each character in program will have ASCII value between 32 and 127,
 * inclusive.
 * <p>
 * <p>
 * EXAMPLES
 * <p>
 * 0)
 * {"Test* t = new Test();",
 * "t->a = 1;",
 * "t->b = 2;",
 * "t->go(); // a=1, b=2 --> a=2, b=3"}
 * <p>
 * Returns: {"Test* t = new Test();", "t.a = 1;", "t.b = 2;", "t.go();
 * // a=1, b=2 --> a=2, b=3" }
 * <p>
 * 1)
 * {"---> // the arrow --->",
 * "---",
 * "> // the parted arrow"}
 * <p>
 * Returns: {"--. // the arrow --->", "---", "> // the parted arrow" }
 * <p>
 * 2)
 * {"->-> // two successive arrows ->->"}
 * <p>
 * Returns: {".. // two successive arrows ->->" }
 * <p>
 * <p>
 * Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
 **/

public class AccessChanger {
	public static String[] convert(String[] program) {
		
		String ans[] = new String[program.length];
		for (int i = 0; i < ans.length; i++) {
			String x = "";
			for (int j = 0; j < program[i].length(); j++) {
				if (j < program[i].length() - 1 && program[i].charAt(j) == '-' && program[i].charAt(j + 1) == '>') {
					x += '.';
					j++;
				} else if (j < program[i].length() - 1 && program[i].charAt(j) == '/' && program[i].charAt(j + 1) == '/') {
					for (int k = j; k < program[i].length(); k++) {
						x += program[i].charAt(k);
					}
					break;
				} else {
					x += program[i].charAt(j);
				}
			}
			ans[i] = x;
		}
		return ans;
	}
}
