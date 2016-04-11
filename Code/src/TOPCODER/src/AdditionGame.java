import java.util.Arrays;

/**
 * PROBLEM STATEMENT
 * Fox Ciel is playing a game called Addition Game.
 * <p>
 * Three numbers A, B and C are written on a blackboard, and Ciel
 * initially has 0 points. She repeats the following operation exactly
 * N times: She chooses one of the three numbers on the blackboard. Let
 * X be the chosen number. She gains X points, and if X >= 1, the
 * number X on the blackboard becomes X-1. Otherwise, the number does
 * not change.
 * <p>
 * Return the maximum number of points she can gain if she plays
 * optimally.
 * <p>
 * <p>
 * DEFINITION
 * Class:AdditionGame
 * Method:getMaximumPoints
 * Parameters:int, int, int, int
 * Returns:int
 * Method signature:int getMaximumPoints(int A, int B, int C, int N)
 * <p>
 * <p>
 * CONSTRAINTS
 * -A, B and C will each be between 1 and 50, inclusive.
 * -N will be between 1 and 150, inclusive.
 * <p>
 * <p>
 * EXAMPLES
 * <p>
 * 0)
 * 3
 * 4
 * 5
 * 3
 * <p>
 * Returns: 13
 * <p>
 * The three numbers written on the blackboard are (3, 4, 5).  One
 * possible optimal strategy is as follows:
 * <p>
 * Ciel chooses 5.  She gains 5 points, and the numbers become (3, 4, 4).
 * Ciel chooses 4.  She gains 4 points, and the numbers become (3, 3, 4).
 * Ciel chooses 4.  She gains 4 points, and the numbers become (3, 3, 3).
 * <p>
 * She gains a total of 5+4+4=13 points.
 * <p>
 * <p>
 * 1)
 * 1
 * 1
 * 1
 * 8
 * <p>
 * Returns: 3
 * <p>
 * One optimal strategy is to choose a 1 in each of the first three
 * turns, for a total of 3 points.  The numbers then become (0, 0, 0).
 * After that, she won't be able to gain any more points.
 * <p>
 * <p>
 * 2)
 * 3
 * 5
 * 48
 * 40
 * <p>
 * Returns: 1140
 * <p>
 * The only optimal strategy is to choose the following numbers: 48,
 * 47, 46, ..., 11, 10, 9.
 * <p>
 * <p>
 * 3)
 * 36
 * 36
 * 36
 * 13
 * <p>
 * Returns: 446
 * <p>
 * <p>
 * <p>
 * 4)
 * 8
 * 2
 * 6
 * 13
 * <p>
 * Returns: 57
 * <p>
 * <p>
 * <p>
 * <p>
 * Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
 **/

public class AdditionGame {
	public static int getMaximumPoints(int A, int B, int C, int N) {
		int sum = 0;
		int a[] = {A, B, C};
		for (int i = 0; i < N; i++) {
			if (a[0] < 1 && a[1] < 1 && a[2] < 1) {
				break;
			}
			Arrays.sort(a);
			sum += a[2];
			a[2] = a[2] - 1;
		}
		return sum;
	}
}
