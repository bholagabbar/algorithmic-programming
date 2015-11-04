#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define endl '\n'
#define pii pair<int,int>
#define F first
#define S second
#define mp make_pair
#define pb emplace_back

bool vis[100001];
int dis[100001];
vector<pii> a[100001]; 

void init(int n)
{
	for(int i=1;i<=n;i++)
	{
		vis[i]=false;
		a[i].clear();
		dis[i]=INT_MAX;
	}
}

class prioritize//Comparator
{
public:
	bool operator ()(pii&p1 ,pii&p2)
	{
		return p1.S>p2.S;
	}
};

int Dijkstra(int s)
{
	priority_queue<pii, vector<pii> , prioritize> pq;
	dis[s]=0;
	pq.push(mp(s,0));
	while(!pq.empty())
	{
		pii cur=pq.top();
		pq.pop();
		int cv=cur.F,cw=cur.S;
		vis[cv]=1;
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
		init(n);
		for(int i=0;i<m;i++)
		{
			cin>>v1>>v2>>w;
			a[v1].pb(mp(v2,w));
		}
		int s;
		cin>>s;
		Dijkstra(s);
		for(int i=1;i<=n;i++)
		{
			if(dis[i]!=INT_MAX)
				cout<<dis[i]<<" ";
			else
				cout<<"-1 ";
		}
	}			
}
