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
#define sz 10005
#define F first
#define S second
#define endl '\n'

typedef pair<int, int> pii;
typedef long long int ll;
typedef pair<ll, ll> pll;
typedef long double ld;

//Shreyans Sheth [bholagabbar]

bool vis[sz];
int dis[sz];
vector<pii> a[sz]; 

class prioritize//Comparator
{
public:
	bool operator ()(pii&p1 ,pii&p2)
	{
		return p1.S>p2.S;
	}
};

int Dijkstra(int s, int d, int n)
{
	priority_queue<pii, vector<pii> , prioritize> pq;
	dis[s]=0;
	pq.push(mp(s,0));
	while(!pq.empty())
	{
		pii cur=pq.top(); pq.pop();
		int cv=cur.F,cw=cur.S;
		if(cv==d)
			return cw;
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
	int tc;cin>>tc;
	while(tc--)
	{
		int n;cin>>n;
		for(int i=1;i<=n;i++)
			a[i].clear();
		hashmap<string,int> hm;
		for(int i=1;i<=n;i++)
		{
			string city;cin>>city;
			hm[city]=i;
			int p;cin>>p;
			for(int j=0;j<p;j++)
			{
				int v2,w;
				cin>>v2>>w;
				a[i].pb(mp(v2,w));
			}
		}
		int q;cin>>q;
		while(q--)
		{
			string x1,x2;
			cin>>x1>>x2;
			CLR(vis);
			fill(dis+1,dis+n+1,INT_MAX);
			int ans=Dijkstra(hm[x1],hm[x2],n);
			cout<<ans<<endl;
		}
	}
	return 0;
}