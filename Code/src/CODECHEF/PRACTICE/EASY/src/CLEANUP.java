package CODECHEF.PRACTICE.EASY.src;import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Shreyans on 12/4/2014 in IntelliJ
 */
class CLEANUP
    {
    public static void main(String[] args)
        {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] fs=new String[t];
        for (int i = 0; i < t; i++)
            {
            int tj = sc.nextInt();
            int cj = sc.nextInt();
            int[] a1 = new int[cj];
            for (int j = 0; j <cj; j++)
                {
                a1[j] = sc.nextInt();
                }
            Arrays.sort(a1);
            int[] nj = new int[tj - cj];
            int cnt = 0;
            for (int j = 1; j <= tj; j++)
                {
                int rv = Arrays.binarySearch(a1, j);
                if (rv<0)
                    {
                    nj[cnt] = j;
                    cnt++;
                    }
                }
            String s1="",s2="";
            for (int j = 0; j < cnt; j += 2)
                {
                s1+=(nj[j] + " ");
                if (j != (cnt - 1))
                    {
                    s2+=(nj[j + 1] + " ");
                    }
                }
            s1=s1.trim();
            s2=s2.trim();
            fs[i]=(s1+"\n"+s2);
            }
        for(int i=0;i<t;i++)
            {
            System.out.println(fs[i]);
            }
        }
    }




/* SAME STORY

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class CLEANUP
    {
    public static void main(String[] args) throws Exception
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] fs=new String[t];
        for (int i = 0; i < t; i++)
            {
            String s1[] = (br.readLine()).split(" ");
            int tj = Integer.parseInt(s1[0]);
            int cj = Integer.parseInt(s1[1]);
            String s2[] = (br.readLine()).split(" ");
            int[] a1 = new int[s2.length];
            for (int j = 0; j < s2.length; j++)
                {
                a1[j] = Integer.parseInt(s2[j]);
                }
            int l2 = a1.length;
            Arrays.sort(a1);
            int[] nj = new int[tj - cj];
            int cnt = 0;
            for (int j = 1; j <= tj; j++)
                {
                int rv = Arrays.binarySearch(a1, j);
                if (rv<0)
                    {
                    nj[cnt] = j;
                    cnt++;
                    }
                }
            String s3="",s4="";
            for (int j = 0; j < cnt; j += 2)
                {
                s3+=(nj[j] + " ");
                if (j != (cnt - 1))
                    {
                    s4+=(nj[j + 1] + " ");
                    }
                }
            s3=s3.trim();
            s4=s4.trim();
            fs[i]=(s3+"\n"+s4);
            }
        for(int i=0;i<t;i++)
            {
            System.out.println(fs[i]);
            }
        }
    }
    */