package DSA;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class SEGMENT_TREES {
	static int[] a;//Input Array
	static int[] st;//Segment Tree
	static int[] lazy;//Array for lazy
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("E:/Shreyans/Documents/Code/CODE/SPOJ/Stdin_File_Read.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//Size of input array
		int st_size = 4 * n + 1;//Worst case
		a = new int[n];
		for (int i = 0; i < n; i++)//Populating Array
		{
			a[i] = sc.nextInt();
		}
		st = new int[st_size];//Max size. No jhanjat
		lazy = new int[st_size];
		
		build(1, 0, n - 1);//Building Segment Tree
		
		
		int rmq1 = RMaxQ(1, 0, n - 1, 1, 3);//RMQ between 2 and 3
		int rmq2 = RMaxQ(1, 0, n - 1, 0, 3);//RMQ between 1 and 4
		System.out.println("\n\nRMQ= " + rmq1 + " " + rmq2 + "\n\n");
		
		int val = 50;
		
	}
	
	//SEGMENT TREE FUNCTIONS
	
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
