/**
 * PROBLEM STATEMENT
 * Fox Ciel is writing an AI for the game Starcraft and she needs your help.
 * <p/>
 * <p/>
 * In Starcraft, one of the available units is a mutalisk.
 * Mutalisks are very useful for harassing Terran bases.
 * Fox Ciel has one mutalisk.
 * The enemy base contains one or more Space Construction Vehicles (SCVs).
 * Each SCV has some amount of hit points.
 * <p/>
 * <p/>
 * When the mutalisk attacks, it can target up to three different SCVs.
 * <p/>
 * The first targeted SCV will lose 9 hit points.
 * The second targeted SCV (if any) will lose 3 hit points.
 * The third targeted SCV (if any) will lose 1 hit point.
 * <p/>
 * If the hit points of a SCV drop to 0 or lower, the SCV is destroyed.
 * Note that you may not target the same SCV twice in the same attack.
 * <p/>
 * <p/>
 * You are given a int[] HP containing the current hit points of your enemy's SCVs.
 * Return the smallest number of attacks in which you can destroy all these SCVs.
 * <p/>
 * DEFINITION
 * Class:MutaliskEasy
 * Method:minimalAttacks
 * Parameters:int[]
 * Returns:int
 * Method signature:int minimalAttacks(int[] x)
 * <p/>
 * <p/>
 * CONSTRAINTS
 * -x will contain between 1 and 3 elements, inclusive.
 * -Each element in x will be between 1 and 60, inclusive.
 * <p/>
 * <p/>
 * EXAMPLES
 * <p/>
 * 0)
 * {12,10,4}
 * <p/>
 * Returns: 2
 * <p/>
 * You can destroy all SCVs in two attacks as follows:
 * <p/>
 * Target the SCVs in the order 0, 2, 1. Their hit points after the attack will be {12-9, 10-1, 4-3}
 * = {3, 9, 1}.
 * Target the SCVs in the order 1, 0, 2. Their hit points will drop exactly to {0, 0, 0}.
 * <p/>
 * <p/>
 * 1)
 * {54,18,6}
 * <p/>
 * Returns: 6
 * <p/>
 * You should attack 6 times, always in the order 0, 1, 2.
 * <p/>
 * 2)
 * {55,60,53}
 * <p/>
 * Returns: 13
 * <p/>
 * <p/>
 * <p/>
 * 3)
 * {1,1,1}
 * <p/>
 * Returns: 1
 * <p/>
 * <p/>
 * <p/>
 * 4)
 * {60, 40}
 * <p/>
 * Returns: 9
 * <p/>
 * <p/>
 * <p/>
 * 5)
 * {60}
 * <p/>
 * Returns: 7
 **/

/**
 Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
 **/

public class MutaliskEasy {
	public static int minimalAttacks(int[] x) {
		//Code here
		return 0;
	}
	
	public static void main(String args[]) {
		
	}
}
