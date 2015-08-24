#include <bits/stdc++.h>
using namespace std;

//Created by Shreyans Sheth [bholagabbar] using Sublime 3

int main()
{
	ios_base::sync_with_stdio(false);cin.tie(NULL);//FAST IO
	int tc;
	cin>>tc;
	while(tc--)
	{
		long long a;
		long long b;
		cin>>a>>b;
		if(b==1)
		{
			cout<<"Yes\n";
			continue;
		}
		else if(a==1)
		{
			cout<<"No\n";
			continue;
		}
		long long x=a;
		int flag=1;
		while(x>1)
		{
			x=__gcd(x,b);
			b/=x;
			if(x==1&&b>1)
			{
				flag=0;
				break;
			}
		}
		if(flag==1)
		{
			cout<<"Yes\n";
		}
		else 
		{
			cout<<"No\n";
		}
	}
	return 0;
}