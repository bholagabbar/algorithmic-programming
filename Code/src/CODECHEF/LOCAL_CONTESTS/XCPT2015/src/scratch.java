package CODECHEF.LOCAL_CONTESTS.XCPT2015.src;

public class scratch {
	
	private static Long fctrl(Long num) {
		Long ans = 1L;
		for (Long i = num * 1L; i > 0 * 1L; i--) {
			ans = ans * 1L * i;
		}
		return ans * 1L;
	}
	
	private static Long nchoosex(Long n, Long x) {
		Long y = n * 1L - x * 1L;
		if (y > x) {
			Long temp = y;
			y = x;
			x = temp;
		}
		Long ans = 1L;
		for (Long i = n; i > x; i--) {
			ans = ans * 1L * i;
		}
		return ((ans * 1L) / (fctrl(y) * 1L)) * 1L;
	}
	
	public static Long checkchoose(Long m, Long n) {
		Long N = n;
		Long combos = 0L;
		Long x = 1L; // starting out at 1 and going up
		// compute "n choose x" call it combos
		combos = nchoosex(N, x);
		System.out.println(n + " choose " + x + " equals " + combos + "; m equals " + m);
		if (combos == m) {
			return x;
		}
		while ((combos > 1) && (combos < m)) {
			x = x + 1L;
			combos = nchoosex(N, x);
			System.out.println(n + " choose " + x + " equals " + combos + "; m equals " + m);
			if (combos == m) {
				return x;
			}
		}
		System.out.println("Didn't find anything");
		return -1L;
	}
	
	public static void main(String[] args) {
		Long p = 155117520L;
		Long q = 30L;
		Long r = checkchoose(p, q);
		System.out.println("For inputs " + q + " and " + p + " the function returned " + r);
	}
}