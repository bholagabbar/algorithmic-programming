import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Single Round Match 545 Round 1 - Division II, Level One
 * <p>
 * PROBLEM STATEMENT
 * An AND-equation is an equation that looks like this:
 * <p>
 * X[0] AND X[1] AND ... AND X[N-1] = Y
 * <p>
 * Here X[i] and Y are non-negative integers and the bitwise AND
 * operation is defined in the Notes.
 * <p>
 * In C++, C#, and Java the operator AND is denoted "&". So for example
 * (P & Q & R) is the bitwise AND of numbers P, Q, and R.
 * In VB the same operator is denoted "And".
 * <p>
 * You are given a int[] A that contains exactly N+1 elements. Your
 * task is to construct an AND-equation using each element of A exactly
 * once. (That is, N of them will be on the left hand side of the AND-
 * equation and the remaining one will be on the right hand side.) If
 * this is possible, return the value of Y in this AND-equation. If no
 * AND-equation can be constructed, return -1. (It can be shown that
 * for each A there is at most one possible value Y, so the return
 * value is always defined correctly.)
 * <p>
 * DEFINITION
 * Class:ANDEquation
 * Method:restoreY
 * Parameters:int[]
 * Returns:int
 * Method signature:int restoreY(int[] A)
 * <p>
 * <p>
 * NOTES
 * -AND is a binary operation, performed on two numbers in binary
 * notation. First, the shorter number is prepended with leading zeroes
 * until both numbers have the same number of digits (in binary). Then,
 * the result is calculated as follows: for each position where both
 * numbers have 1 in their binary representations, the result also has
 * 1. It has 0 in all other positions.
 * -For example 42 AND 7 is performed as follows. First, the numbers
 * are converted to binary: 42 is 101010 and 7 is 111. Then the shorter
 * number is prepended with leading zeros until both numbers have the
 * same number of digits. This means 7 becomes 000111. Then 101010 AND
 * 000111 = 000010 (the result has ones only in the positions where
 * both numbers have ones). Then the result can be converted back to
 * decimal notation. In this case 000010 = 2, so 42 AND 7 = 2.
 * -One of the ways to calculate the AND of more than two numbers X[0],
 * X[1], ..., X[N-1] is "X[0] AND (X[1] AND (... AND X[N-1]))..))".
 * Since the function is commutative and associative, you can also
 * express it as "X[0] AND X[1] AND ... AND X[N-1]" and group the
 * operands in any way you like.
 * <p>
 * <p>
 * CONSTRAINTS
 * -A will contain between 2 and 50 elements, inclusive.
 * -Each element of A will be between 0 and 1048575, inclusive.
 * <p>
 * <p>
 * EXAMPLES
 * <p>
 * 0)
 * {1, 3, 5}
 * <p>
 * <p>
 * Returns: 1
 * <p>
 * 5 AND 3 = 1
 * <p>
 * <p>
 * 1)
 * {31, 7}
 * <p>
 * <p>
 * Returns: -1
 * <p>
 * Clearly, no AND-equation is possible in this case.
 * <p>
 * <p>
 * 2)
 * {31, 7, 7}
 * <p>
 * <p>
 * Returns: 7
 * <p>
 * 7 AND 31 = 7
 * <p>
 * Note that duplicate elements are possible in the input. If an
 * element appears several times in A, it must be used the same number
 * of times in the equation.
 * <p>
 * 3)
 * {1,0,0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0,
 * 0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,1}
 * <p>
 * Returns: 0
 * <p>
 * Zeros are possible in the input.
 * <p>
 * 4)
 * {191411,256951,191411,191411,191411,256951,195507,191411,192435,191411,
 * <p>
 * <p>
 * 191411,195511,191419,191411,256947,191415,191475,195579,191415,191411,
 * <p>
 * 191483,191411,191419,191475,256947,191411,191411,191411,191419,256947,
 * 191411,191411,191411}
 * <p>
 * Returns: 191411
 * <p>
 * <p>
 * <p>
 * 5)
 * {1362,1066,1659,2010,1912,1720,1851,1593,1799,1805,1139,1493,1141,1163,1211}
 * <p>
 * <p>
 * Returns: -1
 * <p>
 * 6)
 * {2, 3, 7, 19}
 * <p>
 * Returns: -1
 * <p>
 * <p>
 * <p>
 * <p>
 * Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
 **/

public class ANDEquation {
	public static int restoreY(int[] A) {
		Set<Integer> ts = new TreeSet<Integer>();
		for (int i : A) {
			ts.add(i);
		}
		Iterator<Integer> it = ts.iterator();
		int cnt = 0;
		Integer compare = 0;
		while (it.hasNext()) {
			Integer x = it.next();
			if (cnt == 0) {
				compare = x;
			} else {
				compare = compare ^ x;
			}
			if (compare == 0) {
				break;
			}
			cnt++;
		}
		return compare;
	}
}
