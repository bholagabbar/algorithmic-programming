#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
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

bool vis[sz];
int dis[sz];
vector<pii> a[sz]; 

int Dijkstra(int s, int d, int n)
{
	for(int i=0;i<=n;i++)
		vis[i]=0, dis[i]=INT_MAX;
	class prioritize{public: bool operator ()(pii&p1 ,pii&p2){return p1.S>p2.S;}};//Comparator
	priority_queue<pii, vector<pii>, prioritize> pq;
	pq.push(mp(s,dis[s]=0));
	while(!pq.empty())
	{
		pii cur=pq.top(); pq.pop();
		int cv=cur.F,cw=cur.S;
		if(cv==d)
			return cw;
		if(vis[cv])
			continue;
		vis[cv]=1;
		for(pii x:a[cv])
			if(!vis[x.F] && cw+x.S<dis[x.F])
				pq.push(mp(x.F,dis[x.F]=cw+x.S));
	}
	return 200000;
}

int main()
{
	//readFile
	boostIO;
	int tc,n,p,q,v2,w;
	string city,x1,x2;
	cin>>tc;
	while(tc--)
	{
		cin>>n;
		for(int i=1;i<=n;i++)
			a[i].clear();
		hashmap<string,int> hm;
		for(int i=1;i<=n;i++)
		{
			cin>>city;
			hm[city]=i;
			cin>>p;
			for(int j=0;j<p;j++)
			{
				cin>>v2>>w;
				a[i].pb(mp(v2,w));
			}
		}
		cin>>q;
		while(q--)
		{
			cin>>x1>>x2;
			cout<<Dijkstra(hm[x1],hm[x2],n)<<endl;
		}
	}
	return 0;
}
