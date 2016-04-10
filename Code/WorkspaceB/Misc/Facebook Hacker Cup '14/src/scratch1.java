import java.io.IOException;

/**
 * Created by Shreyans on 1/18/2015 using IntelliJ IDEA
 */

class scratch1
{
    public static void main(String[] args) throws IOException
    {
        boolean[] k=SOE();
        for(int i=0;i<=10000001;i++)
        {
            System.out.println(i+ " "+k[i]);
        }
    }
    public static boolean[] SOE()
    {
        int max=10000001;
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


