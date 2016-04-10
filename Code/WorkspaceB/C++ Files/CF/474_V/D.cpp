/*input
3 2
1 3
2 3
4 4
*/
#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Codll g Workspace/STDll PUT.txt","r",stdll );
#define BoostIO ios_base::sync_with_stdio(false)
#define pll pair<long long ll t,long long ll t>
#define CLR(s) memset(&s, 0, sizeof(s))
#define hashset unordered_set
#define hashmap unordered_map
#define pii pair<ll t,ll t>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;

//Created by Shreyans Sheth [bholagabbar]

ll dp[100005];
ll sum[100005];
const ll MOD=(ll)1e9+7;

int main()
{
	//ReadFile;
	BoostIO;
	int t,k,a,b;
	cin>>t>>k;
	dp[0]=sum[0]=0;
	for(int i=1;i<k;i++)
	{
		dp[i]=1;
		sum[i]=sum[i-1]+dp[i];
	}
	dp[k]=2;
	sum[k]=(sum[k-1]+dp[k])%MOD;
	for(int i=k+1;i<=100004;i++)
	{
		dp[i]=(dp[i-1]%MOD+dp[i-k]%MOD)%MOD;
		sum[i]=(sum[i-1]%MOD+dp[i]%MOD)%MOD;
	}
	while(t--)
	{
		cin>>a>>b;
		cout<<((sum[b]-sum[a-1])+MOD)%MOD<<endl;
		
	}
	return 0;
}