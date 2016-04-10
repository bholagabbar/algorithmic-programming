import java.io.*;
import java.util.*;
class AMMEAT2
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++)
		{
			String[] a=br.readLine().split(" ");
			int n=Integer.parseInt(a[0]);
			int k=Integer.parseInt(a[1]);
			if(k==1&&n==1)
			{
				pw.println("1");
			}
			else
			{
				if(k>(n/2))
				{
					pw.println("-1");
				}
				else
				{
					int x=2;
					int cnt=0;
					while(cnt!=k)
					{
						pw.print(x+" ");
						cnt++;
						x+=2;
					}
					pw.println();
				}
			}
			pw.flush();
		}
	}
}