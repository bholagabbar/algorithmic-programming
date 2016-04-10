#include <iostream>
#include <vector>
#include <queue>
#include <stack>
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
int previous[100001];

void init(int n)
{
	for(int i=1;i<=n;i++)
	{
		visited[i]=false;
		a[i].clear();
		dist[i]=INT_MAX;
		previous[i]=-1;
	}
}

class prioritize
{
public:
	bool operator ()(pii&p1 ,pii&p2)
	{
		return p1.s>p2.s;
	}
};

void Dijkstra();

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	//while(tc--)
	{
		int v1,v2,w,n,m;
		cin>>n>>m;
		init(n);//resetting data
		for(int i=0;i<m;i++)
		{
			cin>>v1>>v2>>w;
			a[v1].pb(mp(v2,w));
			a[v2].pb(mp(v1,w));
		}
		s=1,d=n;
		Dijkstra();
		int cnt=d,c=0;
		stack<int> path;
		while(cnt!=s)
		{
			path.push(cnt);
			cnt=previous[cnt];
			if(cnt==-1)
			{
				cout<<"-1";
				return 0;
			}
		}
		path.push(s);
		while(!path.empty())
		{
			cout<<path.top()<<" ";
			path.pop();
		}
	}			
}

void Dijkstra()
{
	int pr=s;
	priority_queue<pii, vector<pii> , prioritize> pq;//Datatype, Container, Comparator
	pq.push(mp(s,0));
	while(!pq.empty())
	{
		pii cur=pq.top();
		pq.pop();
		int cv=cur.f,cw=cur.s
		visited[cv]=true;
		for(pii x:a[cv])
		{
			if(!visited[x.f])
			{
				int nv=x.f,nw=x.s;
				if(cw+nw<dist[nv])
				{

					previous[nv]=cv;
					dist[nv]=cw+nw;
					pq.push(mp(nv,dist[nv]));
				}
			}
		}
	}
}