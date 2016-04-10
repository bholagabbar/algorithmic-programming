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
		long n,k;
		cin>>n>>k;
		long long a[n];
		long long sum=0;
		for(long i=0;i<n;i++)
		{
			cin>>a[i];
			if(a[i]>=k)
			{
				long long m=a[i]%k;
				sum+=min(m,(k-m));
			}
			else
			{
				sum+=(k-a[i]);
			}
		}
		cout<<sum<<endl;
	}	
	return 0;
}