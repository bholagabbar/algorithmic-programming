import java.io.*;
import java.util.*;
class ACUGRAY
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++)
		{
			char[] a=br.readLine().toCharArray();
			String ans="";
			ans+=a[0];
			for(int j=0;j<a.length-1;j++)
			{
				int x=(a[j]-48)^(a[j+1]-48);
				ans+=x;
			}
			System.out.println(ans);
		}

	}
}