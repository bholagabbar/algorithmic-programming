/*input
2
3 3
1 2
2 3
1 3
4 2
1 2
3 4
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
 
vector<int> adj[2001];
int color[2001];
bool vis[2001]={0};
 
bool BfsColor(int s)
{
	queue<pii> q;
	q.push({s,0});
	vis[s]=1;
	while(!q.empty())
	{
		pii curr=q.front(); q.pop();
		int cv=curr.F, cc=curr.S;
		color[cv]=cc;
		for(int i: adj[cv])
		{
			if(!vis[i])
				vis[i]=1, q.push({i,1-cc});
			else if (vis[i] && color[i]==cc)
				return false;
		}
	}
	return true;
}
 
int main()
{
	boostIO;
	int tc;
	cin>>tc;
	st:for(int tx=1;tx<=tc;tx++)
	{
		int n,a,b;
		ll m;
		cin>>n>>m;
		for(int i=1;i<=n;i++)
		{
			color[i]=-1;
			vis[i]=false;
			adj[i].clear();
		}
		for(ll i=0;i<m;i++)
		{
			cin>>a>>b;
			adj[a].pb(b);
			adj[b].pb(a);
		}
		cout<<"Scenario #"<<tx<<":\n";
		int flag=1;
		for(int i=1;i<=n;i++)
			if(!vis[i] && )
				if(!BfsColor(i))
				{
					flag=0;
					break;
				}
		if(flag==1)
			cout<<"No suspicious bugs found!\n";
		else
			cout<<"Suspicious bugs found!\n";
	}
	return 0;
}