/*input
2 3
2 3
*/
//Shreyans Sheth [bholagabbar]

#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set	//JAVA Feels :')
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define sz 100001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

ll d[sz<<1], ans[sz<<1];

int main()
{
	boostIO;
	ll n,a;
	cin>>n>>a;
	ll sum=0, ans;
	for(int i=0;i<n;i++)
	{
		cin>>d[i];
		sum+=d[i];
	}
	for(int i=0;i<n;i++)
	{
		if(1+sum-d[i] >= a)
			ans=0;
		else
			ans=a-(sum-d[i]+1);
		ans+=max((ll)0, d[i]-(a-n+1));
		cout<<ans<<" ";
	}	
	return 0;
}