/*input
4
0 2 1 3
1 0 4 5
3 1 0 3
1 1 1 0
4
0 2 1
0 2 2
3 1 2
3 0 1
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define pii pair<int,int>
#define pb emplace_back
#define mp make_pair
#define f first
#define s second
 
 
bool visited[100001];
int dist[100001];
vector <pii> a[100001]; 
 
inline void init(int n)
{
	for(int i=0;i<n;i++)
	{
		visited[i]=false;
		//a[i].clear();
		dist[i]=INT_MAX;
	}
}
 
inline int Dijkstra(int s, int d);
 
class prioritize//Comparator
{
public:
	bool operator ()(pii&p1 ,pii&p2)
	{
		return p1.s>p2.s;
	}
};
 
int main()
{
	ios_base::sync_with_stdio(false);cin.tie(NULL);//FAST IO
	int n,tm;
	cin>>n;
	int store[n][n];
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			cin>>tm;
			a[i].pb(mp(j,tm));
			store[i][j]=INT_MAX;
		}
	}
	int q;
	cin>>q;
	while(q--)
	{
		int st,g,d,d1,d2;
		cin>>st>>g>>d;
		
		init(n);
		
		if(store[st][g]==INT_MAX)
		{
			store[st][g]=Dijkstra(st,g);
		}
		d1=store[st][g];

		init(n);

		if(store[g][d]==INT_MAX)
		{
			store[g][d]=Dijkstra(g,d);
		}

		d2=store[g][d];

		int ans=d1+d2;

		cout<<ans<<" "<<(ans- a[st][d].s)<<endl;
	}
	return 0;
}
 
 
inline int Dijkstra(int s, int d)
{
	priority_queue<pii, vector<pii> , prioritize> pq;
	dist[s]=0;
	pq.push(mp(s,0));
	while(!pq.empty())
	{
		pii cur=pq.top();
		pq.pop();
		int cv=cur.f,cw=cur.s;
		visited[cv]=true;
		if(cv==d)
		{
			break;
		}
		for(pii x:a[cv])
		{
			if(!visited[x.f])
			{
				int nv=x.f,nw=x.s;
				if(cw+nw<dist[nv])
				{
					dist[nv]=cw+nw;
					pq.push(mp(nv,dist[nv]));
				}
			}
		}
	}
	return dist[d];
} 