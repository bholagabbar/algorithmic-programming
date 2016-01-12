import java.io.IOException;
import java.util.*;

class Test1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int tc=sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt(), m = sc.nextInt();
            int[] f = new int[n];
            int[] s=new int[n];
            for (int i=0; i<n; i++) {
                f[i] = sc.nextInt();
            }
            for (int i=0; i<n; i++) {
                s[i]=sc.nextInt();
                f[i] = Math.max(f[i], s[i])- Math.min(f[i], s[i]);
            }
            TreeMap<Integer, Integer> tm=new TreeMap<Integer, Integer>();
            for (int i=0; i<k; i++) {
                int curr=sc.nextInt();
                if(!tm.containsKey(curr)) {
                    tm.put(curr, 1);
                } else {
                    tm.put(curr, tm.get(curr)+1);
                }
            }
            for (int i=0; i<m; i++) {
                int curr=sc.nextInt();
                if(!tm.containsKey(curr)) {
                    tm.put(curr, 1);
                } else {
                    tm.put(curr, tm.get(curr)+1);
                }
            }
            Arrays.sort(f);
            long ans=0;
            for (int i=n-1; i>=0; i--) {
                int now=f[i];
                ans+=now;
                Integer find=tm.floorKey(now);
                if(find != null) {
                    ans -= find;
                    if(tm.get(find) == 1) {
                        tm.remove(find);
                    } else {
                        tm.put(find, tm.get(find)-1);
                    }
                }
            }
            System.out.println(ans);
        }
    }
}