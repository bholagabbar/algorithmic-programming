/*input
9
1 2 1 3 2 2 2 2 3
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

ll a[sz], cnt[sz]={0}, memo[sz];

ll solveDP(ll s)
{
	if(s<=0)
		return 0;
	if(s==1)
		return cnt[1];
	if(memo[s]==-1)
		memo[s]=max(solveDP(s-1),solveDP(s-2)+s*cnt[s]);
	return memo[s];
}

int main()
{
	boostIO;
	ll n, max=-1;
	fill(memo,memo+sz,-1);
	cin>>n;
	for(int i=0;i<n;i++)
	{
		cin>>a[i];
		max=std::max(a[i],max);
		cnt[a[i]]++;
	}
	cout<<solveDP(max);
	return 0;
}