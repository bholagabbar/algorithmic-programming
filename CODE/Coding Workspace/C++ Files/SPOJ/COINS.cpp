#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define printPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(false)
#define CLEAR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl '\n'
typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

//Shreyans Sheth [bholagabbar]

hashmap<ll,ll> memo;

ll getMax(ll n)
{
	if(n==0)
		return 0;
	if(!memo[n])
		memo[n]=max(n,getMax(n/2)+getMax(n/3)+getMax(n/4));
	return memo[n];
}

int main()
{
	//readFile
	//boostIO;
	ll n;
	while(scanf("%lld",&n)!=EOF)
	{
		memo.clear();
		printf("%lld\n",getMax(n));
	}
	return 0;
}