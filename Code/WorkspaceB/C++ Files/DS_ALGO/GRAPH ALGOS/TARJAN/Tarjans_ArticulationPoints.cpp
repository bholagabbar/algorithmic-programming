/*input
7 6
0 1
1 2
3 4
2 4
2 6
5 2
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define pb emplace_back
#define sz 3005 //In the current scenario, I need only a maximum on 3000 vertices

typedef long long int ll;

//Created by Shreyans Sheth [bholagabbar]

bool visited [sz]; //whether the node has been discoverd in the DFS run or not
int low [sz]; //time of the earliest discovered vertex reachable from the vertex
int disc [sz]; //time at which vertex was explored
int parent [sz]; //stores the parents of each vertex
vector<int> a[sz]; //Adjacency List for graph //Time
vector<int> ap; //Stored the articulation points
int rtime; //Discovery time for each node

void DFS(int s)
{
    visited[s]=1;
    low[s]=disc[s]=++rtime;
    int nchild=0;
    int isArticulation = 0;
    for(auto i:a[s])
    {
        if(!visited[i])
        {
            nchild++;//INcrement children of the current vertex
            parent[i]=s;
            DFS(i);
            low[s]=min(low[s],low[i]);
            /* s is an articulation point iff
             1. It the the root and has more than 1 child.
             2. It is not the root and no vertex in the subtree rooted at one of its
                children has a back-link to its ancestor.
                A child has a back-link to an ancestor of its parent when its low
                value is less than the discovery time of its parent.*/
                if (low[i] >= disc[s] || (parent[s]!=-1 && low[i]>=disc[s]))
                    isArticulation = 1;
        }
        else if(i != parent[s])
            low[s] = min(low[s], disc[i]);
    }
    if (isArticulation)
        ap.pb(s); 
} 

void ArticulationPoints(int n)//Driver Funtion
{
	ap.clear();
	rtime=0;//The time for each cycle of DFS
	for(int i=0;i<n;i++)
	{
		parent[i]=-1;//Initializing parents as -1. True for roots
		visited[i]=0;//All points not visited
		low[i]=disc[i]=INT_MAX;
	}
	for(int i=0;i<n;i++)
		if(!visited[i])//Vertex not discoverdd
			DFS(i);
}

int main()
{
	int n,m;//number of vertices, edges
	cin>>n>>m;
	for(int i=0;i<m;i++)//Building Graph
	{
		int x,y;
		cin>>x>>y;
		a[x].pb(y);
		a[y].pb(x);
	}
	ArticulationPoints(n);//Calculating Articulation points
	cout<<"Articulation Points are:\n";
	for(int i:ap)
		cout<<i<<endl;
	return 0;
}