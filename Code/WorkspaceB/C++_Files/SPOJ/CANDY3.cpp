#include <bits/stdc++.h>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(false);cin.tie(0);//FAST IO
	unsigned long long t;
	cin>>t;
	while(t--)
	{
		unsigned long long n=0;
		cin>>n;
		unsigned long long sum=0;
		for(int i=0;i<n;i++)
		{
			int x;
			cin>>x;
			sum+=x;
			if(sum%n==0)
			{
				sum=sum/n;
			}
		}
		if(sum%n==0)
		{
			cout<<"YES";
		}
		else
		{
			cout<<"NO";
		}
	}	
	return 0;
}