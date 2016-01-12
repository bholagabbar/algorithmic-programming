#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define pii pair<int,int>
#define F first
#define S second
#define mp make_pair
#define pb emplace_back

bool vis[100001];
int dis[100001];
vector<pii> a[100001];

int Dijkstra(int s, int n)
{
	for(int i=0;i<=n;i++)
		vis[i]=false, dis[i]=INT_MAX;
	class prioritize{public: bool operator ()(pii &p1 ,pii &p2){return p1.S>p2.S;}};
	priority_queue<pii, vector<pii>, prioritize> pq;
	pq.push(mp(s,dis[s]=0));
	while(!pq.empty())
	{
		pii cur=pq.top(); pq.pop();
		int cv=cur.F,cw=cur.S;
        if(vis[cv]) continue;
		vis[cv]=true;
		for(pii x:a[cv])
			if(!vis[x.F] && cw+x.S<dis[x.F])
				pq.push(mp(x.F,dis[x.F]=cw+x.S));
	}
}

int main()
{
	int tc;
	cin>>tc;
	while(tc--)
	{
		int v1,v2,w,n,m;
		cin>>n>>m;
		for(int i=0;i<=n;i++)
			a[i].clear();
		for(int i=0;i<m;i++)
		{
			cin>>v1>>v2>>w;
			a[v1].pb(mp(v2,w));
		}
		int s;
		cin>>s;
		Dijkstra(s,n);
		for(int i=1;i<=n;i++)
		{
			if(dis[i]!=INT_MAX)
				cout<<dis[i]<<" ";
			else
				cout<<"-1 ";
		}
	}			
}
