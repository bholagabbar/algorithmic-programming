/**
 * // PROBLEM STATEMENT
 * // In many computer systems and networks, different users are granted different levels of access to different resources.
 * In this case, you are given a int[] rights, indicating the privilege level of each user to use some system resource.  You are also given a int minPermission, which is the minimum permission a user must have to use this resource.
 * <p>
 * You are to return a String indicating which users can and cannot access this resource.  Each character in the return value corresponds to the element of users with the same index.  'A' indicates the user is allowed access, while 'D' indicates the user is denied access.
 * <p>
 * <p>
 * DEFINITION
 * Class:AccessLevel
 * Method:canAccess
 * Parameters:int[], int
 * Returns:String
 * Method signature:String canAccess(int[] rights, int minPermission)
 * <p>
 * <p>
 * NOTES
 * -If users is empty, then a zero-length String ("") should be returned.
 * <p>
 * <p>
 * CONSTRAINTS
 * -users will contain between 0 and 50 elements, inclusive.
 * -Each element of users will be between 0 and 100, inclusive.
 * -minPermission will be between 0 and 100, inclusive.
 * <p>
 * <p>
 * EXAMPLES
 * <p>
 * 0)
 * {0,1,2,3,4,5}
 * 2
 * <p>
 * Returns: "DDAAAA"
 * <p>
 * Here, the first two users don't have sufficient privileges, but the remainder do.
 * <p>
 * 1)
 * {5,3,2,10,0}
 * 20
 * <p>
 * Returns: "DDDDD"
 * <p>
 * Unfortunately, nobody has sufficient access.
 * <p>
 * 2)
 * {}
 * 20
 * <p>
 * Returns: ""
 * <p>
 * It makes no difference what permission is required, since there are no users to check.
 * <p>
 * 3)
 * {34,78,9,52,11,1}
 * 49
 * <p>
 * Returns: "DADADD"
 **/

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Created by Shreyans using IntelliJ IDEA (Fast IO Template) [TOPCODER]
 */

public class AccessLevel {
	public static String canAccess(int[] rights, int minPermission) {
		String ans = "";
		for (int i = 0; i < rights.length; i++) {
			if (rights[i] < minPermission) {
				ans += "D";
			} else {
				ans += "A";
			}
		}
		return ans;
	}
	
	//FAST IO
	private static class OutputWriter {
		private final PrintWriter writer;
		
		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}
		
		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}
		
		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0) {
					writer.print(' ');
				}
				writer.print(objects[i]);
			}
		}
		
		public void printLine(Object... objects) {
			print(objects);
			writer.println();
		}
		
		public void close() {
			writer.close();
		}
		
		public void flush() {
			writer.flush();
		}
	}
}
