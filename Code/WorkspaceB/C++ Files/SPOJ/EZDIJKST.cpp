/*input
3
3 2
1 2 5
2 3 7
1 3
3 3
1 2 4
1 3 7
2 3 1
1 3
3 1
1 2 4
1 3
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define pii pair<int,int>
#define f first
#define s second
#define mp make_pair
#define pb emplace_back

int s,d;
bool visited[100001];
int dist[100001];
vector <pii> a[100001]; 

void init(int n)
{
	for(int i=1;i<=n;i++)
	{
		visited[i]=false;
		a[i].clear();
		dist[i]=INT_MAX;
	}
}

inline bool Dijkstra();

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
	ios_base::sync_with_stdio(false);//FAST IO
	int tc;
	cin>>tc;
	while(tc--)
	{
		int v1,v2,w,n,m;
		cin>>n>>m;
		init(n);//resetting data
		for(int i=0;i<m;i++)
		{
			cin>>v1>>v2>>w;
			a[v1].pb(mp(v2,w));
		}
		cin>>s>>d;
		if(Dijkstra())
		{
			cout<<dist[d]<<endl;
		}
		else
		{
			cout<<"NO\n";
		}
	}			
}

inline bool Dijkstra()
{
	//Prioriy Queue is a heap based structure which stores only the max element at top. Not in sorted order
	priority_queue<pii, vector<pii> , prioritize> pq;//Datatype, Container, Comparator
	pq.push(mp(s,0));
	while(!pq.empty())
	{
		pii cur=pq.top();
		pq.pop();
		int cv=cur.f,cw=cur.s;//This node will be highest priority of all instances of this node
		if(visited[cv])
			continue;
		visited[cv]=true;//Now future instances of this node with higher weight ignored as already visited
		if(cv==d)
		{
			break;
		}
		for(pii x:a[cv])//Iterating through vertices of current vertex
		{
			if(!visited[x.f])//Node not visited before.
			{
				int nv=x.f,nw=x.s;
				if(cw+nw<dist[nv])///New dist is shorter
				{
					dist[nv]=cw+nw;
					pq.push(mp(nv,dist[nv]));
				}
			}
		}
	}
	if(dist[d]==INT_MAX) {return false;}
	return true;
}