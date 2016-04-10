/*input
5
1 100
2 50
51 99
52 98
10 60
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

pll a[sz];
ll u[sz+1];

int FIND(int x)
{
    if(u[x]!=u[u[x]])
        u[x]=FIND(u[x]);
    return u[x];
}

bool UNION(int x, int y)
{
    int px=FIND(x),py=FIND(y);
    if(px==py)
        return false;
    u[px]=py;
    return true;
}

int main()
{
	boostIO;
	int n;
	ll x,y;
	cin>>n;
	for(int i=0;i<n;i++)
	{
		u[i]=i;
		cin>>x>>y;
		a[i].F=x;
		a[i].S=y;
	}
	sort(a,a+n);
	int cnt=0;
	for(int i=1; i<n; i++)
	{
		if(a[i].S<a[FIND(i-1)].S)
			UNION(i,i-1);
	}
	hashset<int> hs;
	for(int i=0; i<n; i++)
	{
		int curr=u[i];
		if(hs.find(curr) != hs.end())
			cnt++;
		hs.insert(curr);
	}
	cout<<cnt;
	return 0;
}