#include <bits/stdc++.h>
using namespace std;

typedef long long int ll;
const ll MOD=(ll)(1e9+7);

ll l[1001]={0},u[1001]={0},sum[1002]={0};
ll dp[1001][1001]={0};

int main()
{
	ios_base::sync_with_stdio(false);
	int n,m,c,x;
	cin>>n>>m>>c;
	for(int i=0;i<n;i++)
	{
		cin>>x;
		l[x]++;
	}
	for(int i=0;i<m;i++)
	{
		cin>>x;
		u[x]++;
	}
	dp[0][1000]=sum[1000]=u[1000]*l[1000];
	for(int i=999;i>=1;i--)
	{
		sum[i]=u[i]*l[i];
		dp[0][i]=(dp[0][i+1]%MOD+(sum[i])%MOD)%MOD;
	}
	for(int i=1;i<=c;i++)
	{
		for(int j=1000-i;j>=1;j--)
			dp[i][j]=(dp[i][j+1]%MOD+(sum[j]%MOD*dp[i-1][j+1]%MOD)%MOD)%MOD;
		cout<<dp[i][1]<<" ";
	}
	return 0;
}