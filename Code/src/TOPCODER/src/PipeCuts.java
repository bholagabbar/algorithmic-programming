/**
 * PROBLEM STATEMENT
 * A 100 meter long pipe must be cut in two places.  It can only be cut at certain places, where it
 * was originally welded from smaller pipes.  If the two cut locations are chosen at random (each
 * potential location has equal probability of being chosen), find the probability of a resulting
 * pipe being longer than L meters.
 * <p/>
 * <p/>
 * Create a method named probability that accepts a int[] weldLocations and int L as parameters.  It
 * should calculate the probability of one or more resulting pipes being strictly longer than L if
 * the two cut locations are chosen at random from weldLocations.  Each element in weldLocations
 * represents the number of meters from the left end of the pipe.
 * <p/>
 * DEFINITION
 * Class:PipeCuts
 * Method:probability
 * Parameters:int[], int
 * Returns:double
 * Method signature:double probability(int[] weldLocations, int L)
 * <p/>
 * <p/>
 * NOTES
 * -Your return value must have a relative or absolute error less than 1e-9.
 * <p/>
 * <p/>
 * CONSTRAINTS
 * -weldLocations will have between 2 and 50 elements, inclusive.
 * -Each element in weldLocations will be between 1 and 99, inclusive.
 * -weldLocations will not contain duplicate elements.
 * -L will be between 1 and 100, inclusive.
 * <p/>
 * <p/>
 * EXAMPLES
 * <p/>
 * 0)
 * {25, 50, 75}
 * 25
 * <p/>
 * Returns: 1.0
 * <p/>
 * Any random set of cuts results in a pipe being longer than 25 meters.
 * <p/>
 * 1)
 * {25, 50, 75}
 * 50
 * <p/>
 * Returns: 0.0
 * <p/>
 * This time, it is impossible to cut the pipe such that some resulting pipe is longer than 50 meters.
 * <p/>
 * 2)
 * {25, 50, 75}
 * 24
 * <p/>
 * Returns: 1.0
 * <p/>
 * 3)
 * {99, 88, 77, 66, 55, 44, 33, 22, 11}
 * 50
 * <p/>
 * Returns: 0.7222222222222222
 **/

/**
 Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
 **/

public class PipeCuts {
	static int a[][] = new int[101][100];
	
	public static void COMB() {
		for (int i = 0; i <= 50; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					a[i][j] = 1;
				} else {
					a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
				}
			}
		}
	}
	
	
	public static double probability(int[] weldLocations, int L) {
		COMB();
		int cnt = 0;
		for (int i = 0; i < weldLocations.length; i++) {
			for (int j = i + 1; j < weldLocations.length; j++) {
				int x = Math.min(weldLocations[i], weldLocations[j]);
				int y = Math.max(weldLocations[i], weldLocations[j]);
				int z = y - x;
				if (x <= L && 100 - y <= L && z <= L) {
					cnt++;
				}
				//else
				//System.out.println(weldLocations[i]+" "+weldLocations[j]);
			}
		}
		double ans = 1.0 - (double) cnt / (double) a[weldLocations.length][2];
		System.out.println(1 - ans);
		return ans;
	}
	
	public static void main(String args[]) {
		COMB();
		int[] a = {25, 75, 50};
		probability(a, 50);
	}
}
