/**
 * SRM 288
 * PROBLEM STATEMENT
 * You are given the coordinates of several vertices in space.  Each
 * vertex is colored 'R', 'G' or 'B'.  You are to determine the maximum
 * possible area of a triangle such that all three of its vertices are
 * the same color, or all three of its vertices are different colors.
 * <p>
 * You are given a String[] points describing the vertices.  Each
 * element of points will be in the form "color x y z", where color is
 * 'R', 'G', or 'B', and x, y, z are integers with no leading zeroes.
 * <p>
 * <p>
 * DEFINITION
 * Class:FindTriangle
 * Method:largestArea
 * Parameters:String[]
 * Returns:double
 * Method signature:double largestArea(String[] points)
 * <p>
 * <p>
 * NOTES
 * -A triangle with all three vertices colinear, or two vertices
 * overlapping, has area 0.
 * -Returned value must be within 1.0e-9 absolute or relative error.
 * <p>
 * <p>
 * CONSTRAINTS
 * -points will have between 5 and 50 elements, inclusive.
 * -Each element of points will be formatted as "color x y z" (quotes
 * added for clarity).
 * -Each color will be 'R', 'G', or 'B'.
 * -Each x, y and z will be an integer between 0 and 999, inclusive,
 * with no leading zeros.
 * <p>
 * <p>
 * EXAMPLES
 * <p>
 * 0)
 * {"R 0 0 0",
 * "R 0 4 0",
 * "R 0 0 3",
 * "G 92 14 7",
 * "G 12 16 8"}
 * <p>
 * Returns: 6.0
 * <p>
 * The coloring restrictions mean that we can only consider the first
 * three points, which form a classic 3-4-5 triangle with an area of 6.
 * <p>
 * 1)
 * {"R 0 0 0",
 * "R 0 4 0",
 * "R 0 0 3",
 * "G 0 5 0",
 * "B 0 0 12"}
 * <p>
 * Returns: 30.0
 * <p>
 * Our bet here is to take the red point at the origin, the green
 * point, and the blue point.  These actually form a 5-12-13 triangle.
 * Area = 30.
 * <p>
 * 2)
 * {"R 0 0 0",
 * "R 0 4 0",
 * "R 0 0 3",
 * "R 90 0 3",
 * "G 2 14 7",
 * "G 2 18 7",
 * "G 29 14 3",
 * "B 12 16 8"}
 * <p>
 * Returns: 225.0
 * <p>
 * We have a lot more choices here.
 * <p>
 * <p>
 * 3)
 * {"R 0 0 0",
 * "R 1 1 0",
 * "R 4 4 0",
 * "G 10 10 10",
 * "G 0 1 2"}
 * <p>
 * <p>
 * Returns: 0.0
 * <p>
 * All three red points are colinear.
 * <p>
 * <p>
 * Created by Shreyans using IntelliJ IDEA and FileEdit Plugin [TOPCODER]
 **/

public class FindTriangle {
	public static double largestArea(String[] points) {
		String[] a = points;
		int n = a.length;
		double ans = 0;
		for (int j = 1; j < Math.pow(2, n); j++) {
			int cnt = 0;
			String[] c = new String[3];
			for (int k = 0; k < n; k++) {
				if ((j & (1 << k)) > 0) {
					cnt++;
					if (cnt <= 3) {
						c[cnt - 1] = a[k];
					} else if (cnt > 3) {
						break;
					}
				}
			}
			if (cnt == 3) {
				String c1 = c[0];
				String c2 = c[1];
				String c3 = c[2];
				if ((c1.charAt(0) == c2.charAt(0) && c1.charAt(0) == c3.charAt(0) && c2.charAt(0) == c3.charAt(0)) || (c1.charAt(0) != c2.charAt(0) && c1.charAt(0) != c3.charAt(0) && c2.charAt(0) != c3.charAt(0))) {
					String[] c4 = c1.split(" ");
					String[] c5 = c2.split(" ");
					String[] c6 = c3.split(" ");
					double x1 = Double.parseDouble(c4[1]), y1 = Double.parseDouble(c4[2]), z1 = Double.parseDouble(c4[3]), x2 = Double.parseDouble(c5[1]), y2 = Double.parseDouble(c5[2]), z2 = Double.parseDouble(c5[3]), x3 = Double.parseDouble(c6[1]), y3 = Double.parseDouble(c6[2]), z3 = Double.parseDouble(c6[3]);
					double A = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));
					double B = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2) + Math.pow(z1 - z3, 2));
					double C = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2) + Math.pow(z2 - z3, 2));
					double p = (A + B + C) / 2;
					double area = Math.sqrt(p * (p - A) * (p - B) * (p - C));
					if (area > ans) {
						ans = area;
					}
				}
			}
		}
		if (ans <= 0.1) {
			return 0;
		} else {
			return ans;
		}
	}
}
