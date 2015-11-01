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

int main()
{
	//readFile
	boostIO;
	int a[4]={192, 442, 692, 942};
	ll tc;
	cin>>tc;
	while(tc--)
	{
		ll k;
		cin>>k;
		k--;
		ll n1=k/4;
		if(n1!=0)
			cout<<n1;
		cout<<a[k%4]<<endl;
	}
	return 0;
}