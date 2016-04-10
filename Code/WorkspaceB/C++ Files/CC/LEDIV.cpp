/*input
2
3
2 4 8
3
4 7 5
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int tc;
	cin>>tc;
	while(tc--)
	{
		long n;
		cin>>n;
		long a[n];
		for(int i=0;i<n;i++)
		{
			cin>>a[i];
		}
		long f=0;
		int flag=1;
		for(int i=0;i<n;i++)
		{
			f=__gcd(f,a[i]);
			if(f==1)
			{
				flag=0;
				break;
			}
		}
		if(flag==1)
		{
			for(long i=2;i<=sqrt(f);i++)
			{
				if(f%i==0)
				{
					f=i;
					break;
				}
			}
			cout<<f<<endl;
		}
		else
		{
			cout<<"-1\n";
		}
	}
	return 0;
}