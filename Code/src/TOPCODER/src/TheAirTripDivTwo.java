/**
 * PROBLEM STATEMENT
 * John and Brus have their own airplane. They are going to take
 * several consecutive flights.
 * The i-th element of flights is the number of liters of fuel needed
 * for the i-th flight.
 * The flights can be performed only in the same order as they are
 * described in flights.
 * <p>
 * Initially there are fuel liters of fuel in the airplane. In order to
 * perform a flight, the amount of fuel in the airplane must be at
 * least as much as the amount of fuel needed for this flight. Return
 * the maximum number of flights they will be able to make without a
 * refuel.
 * <p>
 * <p>
 * DEFINITION
 * Class:TheAirTripDivTwo
 * Method:find
 * Parameters:int[], int
 * Returns:int
 * Method signature:int find(int[] flights, int fuel)
 * <p>
 * <p>
 * CONSTRAINTS
 * -flights will contain between 1 and 47 elements, inclusive.
 * -Each element of flights will be between 1 and 1000, inclusive.
 * -fuel will be between 1 and 1000, inclusive.
 * <p>
 * <p>
 * EXAMPLES
 * <p>
 * 0)
 * {1, 2, 3, 4, 5, 6, 7}
 * 10
 * <p>
 * Returns: 4
 * <p>
 * Exactly 10 liters of fuel are required to perform the first four
 * flights.
 * <p>
 * 1)
 * {7, 6, 5, 4, 3, 2, 1}
 * 10
 * <p>
 * Returns: 1
 * <p>
 * These are the same flights as in the previous example, but in
 * different order.
 * <p>
 * 2)
 * {1}
 * 1000
 * <p>
 * Returns: 1
 * <p>
 * A single flight here.
 * <p>
 * 3)
 * {8, 7, 7, 1, 5, 7, 9}
 * 21
 * <p>
 * Returns: 2
 * <p>
 * <p>
 * Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
 **/

public class TheAirTripDivTwo {
	public static int find(int[] flights, int fuel) {
		int n = 0;
		int sum = 0;
		for (int k = 0; k < flights.length; k++) {
			sum += flights[k];
			if (sum <= fuel) {
				n++;
			} else {
				break;
			}
		}
		return n;
	}
	
	public static void main(String args[]) {
		//
	}
}
