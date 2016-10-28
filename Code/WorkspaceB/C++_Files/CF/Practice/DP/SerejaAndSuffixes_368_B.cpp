
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

int main()
{
	boostIO;
	int n,m;
	cin>>n>>m;
	int a[n+1], ans[n+1];
	for(int i=1;i<=n;i++)
		cin>>a[i];
	hashset<int> hs;
	ans[n]=1;
	hs.insert(a[n]);
	for(int i=n-1;i>=1;i--)
	{
		if(hs.find(a[i])==hs.end())
		{
			ans[i]=1+ans[i+1];
			hs.insert(a[i]);
		}
		else
			ans[i]=ans[i+1];
	}
	for(int i=0;i<m;i++)
	{
		int q;
		cin>>q;
		cout<<ans[q]<<endl;
	}
	return 0;
}