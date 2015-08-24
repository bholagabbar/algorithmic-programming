//NEED TO LEARN COMPARATOR


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Shreyans on 1/1/2015 using IntelliJ IDEA
 */

class POINTS
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++)
        {
            String kk=br.readLine();
            int n = Integer.parseInt(br.readLine());
            Integer[][] theArray = new Integer[n][2];
            for (int j = 0; j < n; j++)
            {
                String[] p = br.readLine().split(" ");
                theArray[j][0] = Integer.parseInt(p[0]);
                theArray[j][1] = Integer.parseInt(p[1]);
            }
            Arrays.sort(theArray, new Comparator<Integer[]>()
            {
                //@Override
                public int compare(Integer[] int1, Integer[] int2)
                {
                    Integer numOfKeys1 = int1[0];
                    Integer numOfKeys2 = int2[0];
                    return numOfKeys1.compareTo(numOfKeys2);
                }
            });
            double dist=0;
            for(int j=1;j<n;j++)
            {
                dist+=Math.sqrt(Math.pow((theArray[j][0].intValue()- theArray[j-1][0].intValue()), 2) + Math.pow((theArray[j][1].intValue()-theArray[j-1][1].intValue()), 2));
            }
            dist=Math.round(dist*100.0)/100.0;
            System.out.println(dist);
        }
    }
}