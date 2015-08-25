#include <bits/stdc++.h>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(false);cin.tie(0);//FAST IO
	int t;
	cin>>t;
	while(t--)
	{
		int K,n;
		cin>>K>>n;
		int c[n+1];
		int k[n+1];
		for(int i=1;i<=n;i++)
		{
			cin>>k[i]>>c[i];
		}
		int dp[n+1][K+1];
		for(int i=0;i<=n;i++)
		{
			dp[i][0]=0;
		}
		for(int i=0;i<=K;i++)
		{
			dp[0][i]=0;
		}
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=K;j++)
			{
				dp[i][j]=dp[i-1][j];
				if(k[i]<=j)
				{
					dp[i][j]=max(dp[i-1][j], c[i]+dp[i-1][j-k[i]]);
				}
			}
		}
		cout<<"Hey stupid robber, you can get "<<dp[n][K]<<".\n";
	}	
	return 0;
}