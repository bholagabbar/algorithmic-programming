/*input
12
2
*/
//Shreyans Sheth [bholagabbar]

#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define SI(x) scanf("%d", &x)
#define PI(x) printf("%d", x)
#define SD(x) scanf("%lf", &x)
#define SL(x) scanf("%lld", &x)
#define PL(x) printf("%lld", x)
#define NL printf("\n")
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

hashmap<ll,ll> memo;
ll n;

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
	while(SL(n)!=EOF)
	{
		memo.clear();
		PL(getMax(n));
		NL;
	}
	return 0;
}