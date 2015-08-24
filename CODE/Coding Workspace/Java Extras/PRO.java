import java.io.*;
import java.util.*;
import java.math.*;
class PRO
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		int n=Integer.parseInt(br.readLine());
		TreeSet <Integer> ts=new TreeSet <Integer>();
		long sum=0;
		for(int i=0;i<n;i++)
		{
			String[] a=br.readLine().split(" ");
			for(int j=0;j<a.length;j++)
			{
				ts.add(Integer.parseInt(a[j]));
			} 
			sum+=(ts.pollLast()-ts.pollFirst());
		}
		pw.println(sum);
	}
}