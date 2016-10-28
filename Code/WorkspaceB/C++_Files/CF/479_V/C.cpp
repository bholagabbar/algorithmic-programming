/*input
3
6 1
5 2
4 3
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

int main()
{
	//readFile;
	boostIO;
	int n;
	cin>>n;
	ll x,y;
	pll a[n];
	for(int i=0;i<n;i++)
	{
		cin>>x>>y;
		a[i]=mp(x,y);
	}	
	sort(a,a+n);
	set<ll> s;
	s.insert(min(a[0].F,a[0].S));
	for(int i=1;i<n;i++)
	{
		ll mx=max(a[i].F,a[i].S);
		ll mn=min(a[i].F,a[i].S);
		ll last=*s.rbegin();
		if(mn>=last)
			s.insert(mn);
		else
			s.insert(mx);
	}
	cout<<*s.rbegin();
	return 0;
}