#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(false)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define sz 100005
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
	int n;
	cin>>n;
	ll x1,x2,m,c,y1,y2;
	cin>>x1>>x2;
	pll a[n];
	for(int i=0;i<n;i++)
	{
		cin>>m>>c;
		y1=m*x1+c;
		y2=m*x2+c;
		a[i]={y1,y2};
	}
	sort(a,a+n);
	for(int i=1;i<n;i++)
		if(a[i-1].F<a[i].F && a[i-1].S>a[i].S)
		{
			cout<<"YES";
			return 0;
		}
	cout<<"NO";
	return 0;
}