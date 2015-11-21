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

comp(pii a, pii b)
{
	if((a.F>=a.S && a.F>=b.F && a.F>=b.S)||(a.S>=a.F && a.S>=b.F && a.S>=b.S))
		return a.F<a.S;
	else if((a.S>=a.F && a.S>=b.F && a.S>=b.S))
		return a.S<a.F;
	else if((b.S>=b.F && b.S>=a.F && b.S>=a.S))
		return b.S<b.F;
	else
		return b.F<b.S;
}

int main()
{
	boostIO;
	pii a[3];
	a[0]={4,8};
	a[1]={1,5};
	a[2]={2,7};
	sort(a,a+3,comp);
	for(auto i:a)
		cout<<i.F<<" "<<i.S<<endl;
	
	return 0;
}