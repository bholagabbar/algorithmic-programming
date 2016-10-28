import java.util.*;
import java.io.*;
import java.math.*;

class CANDY3
{
	public static void main (String[] args) throws  IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		long t;
		t=Integer.parseInt(br.readLine());
		for(long i1=0;i1<t;i1++)
		{
			br.readLine();
			long x=Long.parseLong(br.readLine());
			BigInteger mo=new BigInteger(Long.toString(x));
			BigInteger ans=BigInteger.ZERO;
			for(long i=0;i<x;i++)
			{
				ans=ans.add(new BigInteger(br.readLine()));
			}
			if(ans.mod(mo).equals(BigInteger.ZERO))
			{
				pw.println("YES");
			}
			else
			{
				pw.println("NO");
			}
			pw.flush();
		}
		pw.close();
	}
}//YEAH BITCH NO GODDAMN TYPO HAHAHAHAHA