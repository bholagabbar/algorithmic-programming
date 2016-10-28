#include <bits/stdc++.h>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(false);cin.tie(0);//FAST IO
	int n;
	cin>>n;
	int a[n];
	for(int i=0;i<n;i++)
	{
		cin>>a[i];
	}
	int dp[n];
	int max=-1;
	for(int i=0;i<n;i++)
	{
		dp[i]=1;
		for(int j=i-1;j>=0;j--)
		{
			if(a[j]<a[i]&&dp[j]>dp[i]-1)
			{
				dp[i]=dp[j]+1;
			}
		}
		if(dp[i]>max)
		{
			max=dp[i];
		}
	}
	cout<<max;
	return 0;
}