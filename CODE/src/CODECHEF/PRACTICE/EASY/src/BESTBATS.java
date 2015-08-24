import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Shreyans on 12/16/2014 in IntelliJ IDEA
 */
class BESTBATS
    {
    public static void main(String[] args) throws IOException
     {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     int t=Integer.parseInt(br.readLine());
     for(int i=0;i<t;i++)
      {
      String[]s=br.readLine().split(" ");
       int[] a=new int[11];
       for(int j=0;j<11;j++)
       {
        a[j]=Integer.parseInt(s[j]);
       }
       Arrays.sort(a);
       int k=Integer.parseInt(br.readLine());
      int max1=0;
       for(int j=10;j>=(11-k);j--)
       {
       max1+= a[j];
       }
       System.out.println(max1);
       int cnt=0;
      for(int j=(int)Math.pow(2,k);j<Math.pow(2,k+1);j++)
       {
        int sum=0;
        for(int k1=0;k1<11;k1++)
        {
         if((j&(1<<k1))>0)//shifts the bit in binary 1 k number of times to check if it exists in j. If it does then add
         {
          sum+=a[k1];
         }
        }
        if(sum==max1)
        {
         cnt++;
        }
       }
       System.out.println(cnt);
      }
      }
     }

/**
 * A cricket team consists of 11 players and some are good at batting, others are good at bowling and some of them
 * are good at both batting and bowling. The batting coach wants to select exactly K players having maximum possible sum of scores.
 * Given the batting score of each of the 11 players, find the number of ways in which we can select exactly K players such that the
 * sum of their scores is the maximum possible. Two ways are different if there is a player who is selected in one of them is not
 * in the other. See explanation of sample cases for more clarity.
 Input

 First line contains T, number of test cases ( 1 ≤ T ≤ 100 ). T cases follow, each having 2 lines. First line of each case contains
 scores of 11 players ( 1 ≤ score ≤ 100 ) and the second line contains K (1 ≤ K ≤ 11)
 Output

 For each test case, output the answer in a new line.
 Example

 Input:
 2
 1 2 3 4 5 6 7 8 9 10 11
 3
 2 5 1 2 4 1 6 5 2 2 1
 6

 Output:
 1
 6

 Explanation:
 Case 1 : Maximum possible sum of scores = 11 + 10 + 9 = 30 and can be achieved only by selecting the last 3 players. Only one
 possible way.
 Case 2 : Maximum possible sum of scores = 6 + 5 + 5 + 4 + 2 + 2 = 24 and considering the players as p1 p2 p3 ... p11 in that order,
 the ones with maximum possible sum of scores is as follows
 {p1, p2, p4, p5, p7, p8 }
 {p10, p2, p4, p5, p7, p8 }
 {p1, p2, p10, p5, p7, p8 }
 {p9, p2, p4, p5, p7, p8 }
 {p1, p2, p9, p5, p7, p8 }
 {p10, p2, p9, p5, p7, p8 }
 */
