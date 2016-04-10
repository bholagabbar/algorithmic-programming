#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define printPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(false)
#define CLR(s) memset(&s, 0, sizeof s)
#define PI(x) printf("%d", x)
#define PL(x) printf("%lld", x)
#define SI(x) scanf("%d", &x)
#define SD(x) scanf("%lf", &x)
#define SL(x) scanf("%lld", &x)
#define hashset unordered_set
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define sz 100005
#define F first
#define S second
#define endl '\n'

typedef pair<int, int> pii;
typedef long long int ll;
typedef pair<ll, ll> pll;
typedef long double ld;

//Shreyans Sheth [bholagabbar]

int main()
{
	//readFile
	boostIO;
	ll n;
	cin>>n;
	if(n>0 && (n&(n-1))==0)//Property that it is a power of 2
		cout<<"TAK\n";
	else
		cout<<"NIE\n";
	
	return 0;
}