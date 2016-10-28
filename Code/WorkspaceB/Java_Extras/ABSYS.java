/*input
3

23 + 47 = machula

3247 + 5machula2 = 3749

machula13 + 75425 = 77038
*/
import java.io.*;
import java.util.*;
import java.math.*;
class ABSYS
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		int n=Integer.parseInt(br.readLine());
		String d=br.readLine();
		for(int i=0;i<n;i++)
		{
			String s1=br.readLine().trim();
			String[]a=s1.split(" ");
			if(a[0].contains("machula"))
			{
				int ans=Integer.parseInt(a[4])-Integer.parseInt(a[2]);
				pw.println(ans+" + "+a[2]+" = "+a[4]);
			}
			else if(a[2].contains("machula"))
			{
				int ans=Integer.parseInt(a[4])-Integer.parseInt(a[0]);
				pw.println(a[0]+" + "+ans+" = "+a[4]);	
			}
			else if(a[4].contains("machula"))
			{
				int ans=Integer.parseInt(a[0])+Integer.parseInt(a[2]);
				pw.println(a[0]+" + "+a[2]+" = "+ans);	
			}
			pw.flush();
			d=br.readLine();
		}
	}
}