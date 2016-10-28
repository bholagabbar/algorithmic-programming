//Created by Shreyans Sheth [bholagabbar] using Sublime 3

#include <bits/stdc++.h>
using namespace std;
//MACROS
#define endl '\n'

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	//cin.tie(NULL);//Untie streams before submission
	int t;
	cin>>t;
	while(t--)
	{
		int n,m;
		cin>>n>>m;
		int h[m+1];
		int c[m+1];
		for(int i=1;i<=m;i++)
		{
			cin>>h[i]>>c[i];
		}
		int dp[m+1][n+1];
		for(int i=0;i<=m;i++)
		{
			dp[i][0]=0;
		}
		for(int i=0;i<=n;i++)
		{
			dp[0][i]=0;
		}
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(h[i]<=j)
				{
					dp[i][j]=max(dp[i-1][j], c[i]+dp[i-1][j-h[i]]);
				}
				else
				{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		cout<<dp[m][n]<<endl;
	}	
	return 0;
}