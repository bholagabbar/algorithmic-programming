#include <iostream>
#include <vector>
#include <queue>
#include <limits.h>
using namespace std;
#define endl '\n'
#define pii pair<int,int>
#define f first
#define s second
#define mp make_pair
#define pb emplace_back//faster than push_back. Your choice though

int s;//source vertex
bool visited[100001];//visited array
int dist[100001];//storing shortest distance from source to every vertex
vector <pii> a[100001]; //Adjacency List. source vertex->destination vertex,weight

void init(int n)//resets data
{
	for(int i=1;i<=n;i++)
	{
		visited[i]=false;
		a[i].clear();
		dist[i]=INT_MAX;
	}
}

void Dijkstra();

class prioritize//Comparator to sort edges. The shortest edge is removed first
{
public:
	bool operator ()(pii&p1 ,pii&p2)
	{
		return p1.s>p2.s;
	}
};

int main()
{
	int v1,v2,w,n,m;
	cin>>n>>m;//number of vertics,edges
	init(n);//resetting data
	for(int i=0;i<m;i++)
	{
		cin>>v1>>v2>>w;//inputting data
		a[v1].pb(mp(v2,w));
	}
	cin>>s;//inputting source
	Dijkstra();
	cout<<"Printing shortest distance from Source "<<s<<" to all other vertices\n";
	for(int i=1;i<=n;i++)
	{
		cout<<s<<" to "<<i<<" ";
		if(dist[i]!=INT_MAX)
			cout<<dist[i]<<endl;
		else
			cout<<"Unreachable\n";
	}				
}

void Dijkstra()
{
	//Prioriy Queue is a heap based structure which stores only the max element at top. Not in sorted order
	priority_queue<pii, vector<pii> , prioritize> pq;//Datatype, Container, Comparator
	dist[s]=0;
	pq.push(mp(s,0));//pushing source,0 as dist from source to itself is 0. Duh
	while(!pq.empty())
	{
		pii cur=pq.top();
		pq.pop();
		int cv=cur.f,cw=cur.s;//This node will be highest priority of all instances of this node
		visited[cv]=true;//Now future instances of this node with higher weight ignored as already visited
		for(pii x:a[cv])//Iterating through vertices of current vertex
		{
			if(!visited[x.f])//Node not visited before.
			{
				int nv=x.f,nw=x.s;//current vertex and its weight
				if(cw+nw<dist[nv])///New dist is shorter
				{
					dist[nv]=cw+nw;
					pq.push(mp(nv,dist[nv]));//Adding to priority queue
				}
			}
		}
	}
}