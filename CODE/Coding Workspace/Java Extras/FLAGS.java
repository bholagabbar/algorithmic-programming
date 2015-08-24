import java.io.*;
import java.util.*;
import java.math.*;
class FLAGS
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++)
		{
			long n=Long.parseLong(br.readLine());
			pw.println((2*n*(n-1)*(n-1))+(n*(n-1)*(n-2))+(2*(((n*(n-1)*(n-2))+((n*(n-1)*(n-2)*(n-3)))))));
			pw.flush();
		}
		pw.close();
	}
}