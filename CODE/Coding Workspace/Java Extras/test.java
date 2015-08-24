import java.io.*;
import java.util.*;
import java.math.*;
class test
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		int result[]=new int[10];
		Add(result);
		for(int i:result)
		{
			System.out.println(i);
		}
	}
	public static void Sort(int[] a)
	{
		int n=a.length/2;
		if(n<2)
			return;
		else
		{
			int[] l=new int[n/2];
			for(int i=0;i<n/2;i++)
				l[i]=a[i];
			int[] r=new int[n-(n/2)];
			for(int i=(n/2)+1;i<n;i++)
				r[]
		}
	}
}