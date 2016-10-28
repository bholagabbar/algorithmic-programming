/*input
2
2 4
4 2
*/
#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define boostIO ios_base::sync_with_stdio(false)
#define ld long double
#define ll long long int
#define CLR(s) memset(&s, 0, sizeof(s))
#define scani(s) scanf("%d",&s)
#define scanl(s) scanf("%lld",&s)
#define hashset unordered_set //JAVA feels :')
#define hashmap unordered_map
#define pll pair<ll,ll>
#define pii pair<int,int>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl '\n'

const ll MOD=1000000007;
ll dp[100005];

int main()
{
	//readFile;
	boostIO;
	int tc;
	cin>>tc;
	while(tc--)
	{
		int n,cnt;
		ll k,val=1;
		cin>>n>>k;
		n%2==0?cnt=1:cnt=-1;
		for(int i=1;i<n;i++)
		{
			val=(val%MOD*k)%MOD;
			dp[i]=(dp[i-1]%MOD+(val*cnt))%MOD;
			if(dp[i]<0)// oh bc
				dp[i]=(dp[i]+MOD)%MOD;
			cnt*=-1;
		}
		cout<<dp[n-1]%MOD<<endl;
	}
	return 0;
}