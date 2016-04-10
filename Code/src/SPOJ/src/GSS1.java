package SPOJ.src;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by Shreyans Sheth [bholagabbar] on 6/1/2015 at 2:35 PM using IntelliJ IDEA (Fast IO Template)
 */


class GSS1 {
	static int[] a = new int[50001];//Input Array
	static int[] st = new int[4 * 50001];//Segment Tree
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		String[] s1 = br.readLine().split(" ");
		for (int i = 0; i < s1.length; i++) {
			a[i] = Integer.parseInt(s1[i]);
		}
		build(1, 0, n - 1);
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			String s2[] = br.readLine().split(" ");
			pw.println(RMaxQ(1, 0, n - 1, Integer.parseInt(s2[0]) - 1, Integer.parseInt(s2[1]) - 1));
		}
		
		{
			pw.close();
		}
	}
	
	public static void build(int pos, int lo, int hi) {
		if (lo > hi) {
			return;//Wrong values
		}
		//Left Child: 2*pos, Right child: 2*pos+1
		if (lo == hi) {
			st[pos] = a[lo];
			return;
		}
		build(2 * pos, lo, (lo + hi) / 2);
		build(2 * pos + 1, 1 + (lo + hi) / 2, hi);
		
		st[pos] = Math.max(st[2 * pos], st[1 + 2 * pos]);
	}
	
	public static int RMaxQ(int pos, int lo, int hi, int i, int j)//Range Maximum Query between i,j
	{
		if (i > hi || j < lo) {
			return Integer.MIN_VALUE;
		}
		
		if (i <= lo && j >= hi) {
			return st[pos];
		}
		
		return Math.max(RMaxQ(2 * pos, lo, (lo + hi) / 2, i, j), RMaxQ(2 * pos + 1, 1 + (lo + hi) / 2, hi, i, j));//returns minimum in range from l,r
	}
}