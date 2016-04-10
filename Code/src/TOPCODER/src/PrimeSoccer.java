/**
 * PROBLEM STATEMENT
 * You are watching a soccer match, and you wonder what the probability is that at least one of the
 * two teams will score a prime number of goals.  The game lasts 90 minutes, and to simplify the
 * analysis, we will split the match into five-minute intervals.  The first interval is the first
 * five minutes, the second interval is the next five minutes, and so on.  During each interval,
 * there is a Sa percent probability that team A will score a goal, and a Sb
 * percent probability that teamB will score a goal.  Assume that each team will score at most one
 * goal within each interval.  Return the probability that at least one team will have a prime number
 * as its final score.
 * <p/>
 * DEFINITION
 * Class:PrimeSoccer
 * Method:getProbability
 * Parameters:int, int
 * Returns:double
 * Method signature:double getProbability(int Sa, int Sb)
 * <p/>
 * <p/>
 * NOTES
 * -The returned value must be accurate to within a relative or absolute value of 1E-9.
 * -A prime number is a number that has exactly two divisors, 1 and itself. Note that 0 and 1 are not
 * prime.
 * <p/>
 * <p/>
 * CONSTRAINTS
 * -Sa will be between 0 and 100, inclusive.
 * -Sb will be between 0 and 100, inclusive.
 * <p/>
 * <p/>
 * EXAMPLES
 * <p/>
 * 0)
 * 50
 * 50
 * <p/>
 * Returns: 0.5265618908306351
 * <p/>
 * <p/>
 * <p/>
 * 1)
 * 100
 * 100
 * <p/>
 * Returns: 0.0
 * <p/>
 * Both teams will score a goal in each interval, so the final result will be 18 to 18.
 * <p/>
 * 2)
 * 12
 * 89
 * <p/>
 * Returns: 0.6772047168840167
 **/

import java.util.Arrays;

/**
 Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
 **/

public class PrimeSoccer {
	static boolean[] p = new boolean[55];
	static double[][] C = new double[20][20];
	
	
	static void Sieve() {
		Arrays.fill(p, true);
		p[0] = p[1] = false;
		for (int i = 2; i <= Math.sqrt(50); i++) {
			if (p[i]) {
				for (int j = i * i; j <= 50; j += i) {
					p[j] = false;
				}
			}
		}
	}
	
	static void COMB() {
		for (int i = 0; i <= 18; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					C[i][j] = 1;
				} else {
					C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
				}
			}
		}
	}
	
	
	public static double getProbability(int SkillOfTeamA, int SkillOfTeamB) {
		Sieve();
		COMB();
		double a = 0;
		double b = 0;
		double Sa = SkillOfTeamA / 100.0;
		double Sb = SkillOfTeamB / 100.0;
		System.out.println(Sa + " " + Sb);
		for (int i = 2; i <= 18; i++) {
			if (p[i]) {
				a += Math.pow(Sa, i) * Math.pow(1.0 - Sa, 18 - i) * C[18][i];
				b += Math.pow(Sb, i) * Math.pow(1.0 - Sb, 18 - i) * C[18][i];
				//System.out.println(a+" "+b+" "+Math.pow(Sa,i)+" "+Math.pow(1.0-Sa,18-i)+" "+C[18][i]);
			}
		}
		System.out.println(a + " " + b);
		double ans = 1.0 - ((1.0 - a) * (1.0 - b));
		System.out.println(ans);
		return ans;
	}
	
	public static void main(String args[]) {
		getProbability(50, 50);
	}
}
