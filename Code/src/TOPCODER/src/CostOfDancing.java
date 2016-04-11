import java.util.Arrays;

/**
 * PROBLEM STATEMENT
 * Gustavo studies at the Byteversity (one of the best universities in
 * Byteland). He's also very keen on dancing, so he decided to enroll
 * at a dance school.
 * <p>
 * The school offers many different courses, each teaching one dance.
 * Different courses may have different costs. You are given a int[]
 * danceCost. The elements of danceCost are the costs of all courses
 * offered at the dance school.
 * <p>
 * Gustavo would like to learn exactly K of those dances. He is a poor
 * student, so his only priority is to pay as little as possible for
 * the courses.
 * <p>
 * You are given the int K and the int[] danceCost. Compute and return
 * the smallest possible total cost of learning K dances.
 * <p>
 * DEFINITION
 * Class:CostOfDancing
 * Method:minimum
 * Parameters:int, int[]
 * Returns:int
 * Method signature:int minimum(int K, int[] danceCost)
 * <p>
 * <p>
 * CONSTRAINTS
 * -danceCost will contain between 1 and 1,000 elements, inclusive.
 * -Each element of danceCost will be between 1 and 1,000, inclusive.
 * -K will be between 1 and the number of elements in danceCost,
 * inclusive.
 * <p>
 * <p>
 * EXAMPLES
 * <p>
 * 0)
 * 2
 * {1, 5, 3, 4}
 * <p>
 * Returns: 4
 * <p>
 * Gustavo must pay for exactly two out of the four given courses. The
 * cheapest possibility is to pay 1 for one course and then 3 for
 * another course. The total cost is 1+3 = 4.
 * <p>
 * 1)
 * 3
 * {1, 5, 4}
 * <p>
 * Returns: 10
 * <p>
 * Gustavo has no choice here. He has to pay for all three courses,
 * which costs 1+5+4 = 10.
 * <p>
 * 2)
 * 1
 * {2, 2, 4, 5, 3}
 * <p>
 * Returns: 2
 * <p>
 * Among all 5 possible courses he can take, the cheapest one is either
 * the course #0 or course #1 (0-based).
 * <p>
 * 3)
 * 39
 * {973, 793, 722, 573, 521, 568, 845, 674, 595, 310, 284, 794, 913,
 * 93, 129, 758, 108, 433, 181, 163, 96, 932,
 * 703, 989, 884, 420, 615, 991, 364, 657, 421, 336, 801, 142, 908,
 * 321, 709, 752, 346, 656, 413, 629, 801}
 * <p>
 * Returns: 20431
 * <p>
 * <p>
 * <p>
 * <p>
 * Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
 **/

public class CostOfDancing {
	public static int minimum(int K, int[] danceCost) {
		Arrays.sort(danceCost);
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += danceCost[i];
		}
		return sum;
	}
}
