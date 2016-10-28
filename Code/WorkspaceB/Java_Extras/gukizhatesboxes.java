import java.util.Scanner;

public class Main {

    private Scanner scanner;

    private Main(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        Main main = new Main(new Scanner(System.in));
        main.solve();
    }

    private void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        long s = 0;
        for (int i = 0; i < n; i++) 
            s += a[i] = scanner.nextInt();
        long l = 2, r = s + n;
        while (l < r) 
        {
            long z = (l+r)/2;
            int[] b = a.clone();
            int p = 0;
            for (int i = 0; i < m; i++) 
            {
                while(p<n && b[p]==0) //Non zero entries not to be counted
                    p++;
                long t = z -(p+1); //Subtract the time taken to reach the last box. THat is the minimum time you need atleast
                if (t <= 0) break;
                while (p < n && b[p] <= t) 
                {
                	t -= b[p++];//In range
                }
                if (p <n) b[p] -= t;//Subtracting leftover
            }
			//System.out.println(l+" "+r);
            if (p<=n-1) l=z+1;
            else
                r=z;
        }
        System.out.println(l);
    }
}