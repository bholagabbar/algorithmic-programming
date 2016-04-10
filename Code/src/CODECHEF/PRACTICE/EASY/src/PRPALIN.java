package CODECHEF.PRACTICE.EASY.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shreyans on 11/22/2014 in IntelliJ
 */
class PRPALIN {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean isprimef[] = SOE();
		if (n > 98689) {
			System.out.println(1003001);
		} else {
			for (int i = n; i <= 98689; i++) {
				if (isprimef[i - 1]) {
					//ALTERNATE CONVENTIONAL REVERSING TECHNIQUE WITH A SLIGHTLY FASTER RUNTIME
	                 /*  int t = i;
                    int rev = 0;
                    while (t != 0)
                        {
                        int rem = t % 10;
                        rev = (rev * 10) + rem;
                        t = t / 10;
                        }
                    if (rev==i)
                        {
                        System.out.println(i);
                        break;
                        }*/
					StringBuffer a1 = new StringBuffer();
					a1.append(Integer.toString(i));
					if (String.valueOf(a1).compareTo(String.valueOf(a1.reverse())) == 0) {
						System.out.print(a1);
						break;
					}
				}
			}
		}
	}
	
	public static boolean[] SOE() {
		int max = 10000001;
		final boolean[] primeCandidates = new boolean[max]; // defaults to false
		for (int i = 2; i < max; i++) {
			primeCandidates[i] = true;
		}
		
		final double maxRoot = Math.sqrt(max);
		for (int candidate = 2; candidate < maxRoot; candidate++) {
			if (primeCandidates[candidate]) {
				for (int j = 2 * candidate; j < max; j += candidate) {
					primeCandidates[j] = false;
				}
			}
			
		}
		return primeCandidates;
	}
}

//SIEVE OF ATKINS NOT WORKING
    /*import java.util.Arrays;

class SieveOfAtkin
    {
    private static int limit = 1000;
    private static boolean[] sieve = new boolean[limit + 1];
    private static int limitSqrt = (int)Math.sqrt((double)limit);

    public static void main(String[] args)
        {
// there may be more efficient data structure
// arrangements than this (there are!) but
// this is the algorithm in Wikipedia
// initialize results array
        Arrays.fill(sieve, false);
// the sieve works only for integers > 3, so
// set these trivially to their proper values
        sieve[0] = false;
        sieve[1] = false;
        sieve[2] = true;
        sieve[3] = true;

// loop through all possible integer values for x and y
// up to the square root of the max prime for the sieve
// we don't need any larger values for x or y since the
// max value for x or y will be the square root of n
// in the quadratics
// the theorem showed that the quadratics will produce all
// primes that also satisfy their wheel factorizations, so
// we can produce the value of n from the quadratic first
// and then filter n through the wheel quadratic
// there may be more efficient ways to do this, but this
// is the design in the Wikipedia article
// loop through all integers for x and y for calculating
// the quadratics
        for (int x = 1; x <= limitSqrt; x++) {
        for (int y = 1; y <= limitSqrt; y++) {
// first quadratic using m = 12 and r in R1 = {r : 1, 5}
        int n = (4 * x * x) + (y * y);
        if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
        sieve[n] = !sieve[n];
        }
// second quadratic using m = 12 and r in R2 = {r : 7}
        n = (3 * x * x) + (y * y);
        if (n <= limit && (n % 12 == 7)) {
        sieve[n] = !sieve[n];
        }
// third quadratic using m = 12 and r in R3 = {r : 11}
        n = (3 * x * x) - (y * y);
        if (x > y && n <= limit && (n % 12 == 11)) {
        sieve[n] = !sieve[n];
        } // end if
// note that R1 union R2 union R3 is the set R
// R = {r : 1, 5, 7, 11}
// which is all values 0 < r < 12 where r is
// a relative prime of 12
// Thus all primes become candidates
        } // end for
        } // end for
// remove all perfect squares since the quadratic
// wheel factorization filter removes only some of them
        for (int n = 5; n <= limitSqrt; n++) {
        if (sieve[n]) {
        int x = n * n;
        for (int i = x; i <= limit; i += x) {
        sieve[i] = false;
        } // end for
        } // end if
        } // end for
// put the results to the System.out device
// in 10x10 blocks
        for (int i = 0, j = 0; i <= limit; i++) {
        if (sieve[i]) {
        System.out.printf("%,8d", i);
        if (++j % 10 == 0) {
        System.out.println();
        } // end if
        if (j % 100 == 0) {
        System.out.println();
        } // end if
        } // end if
        } // end for
        } // end main
    } // end class SieveOfAtkin*/