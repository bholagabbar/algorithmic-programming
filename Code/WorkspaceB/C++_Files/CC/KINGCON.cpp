#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define endl '\n'
#define pb emplace_back
#define sz 3005

typedef long long int ll;

//Created by Shreyans Sheth [bholagabbar]

bool visited [sz];
int low [sz];
int disc [sz];
int parent [sz];
vector<int> a[sz];
int rtime;
int ap;

//credits: http://stackoverflow.com/questions/32285754/articulation-points-appearing-repeatedly-in-tarjans-implementation/32286432#32286432

void DFS(int s)
{
	visited[s]=1;
	low[s]=disc[s]=++rtime;
	int nchild=0;
	bool isArticulation=0;
	for(auto i:a[s])
	{
		if(!visited[i])
		{
			nchild++;
			parent[i]=s;
			DFS(i);
			low[s]=min(low[s],low[i]);
			if((parent[s]==-1 && nchild>1)||(parent[s]!=-1 && low[i]>=disc[s]))
				isArticulation=1;
		}
		else if(visited[i] && i!=parent[s])
			low[s]=min(low[s],disc[i]);
	}
	if (isArticulation)
		ap++;
}

void ArticulationPoints(int n)//x is the vertex to be missed
{
	ap=0;
	rtime=0;
	for(int i=0;i<n;i++)
	{
		parent[i]=-1;
		visited[i]=0;
		low[i]=disc[i]=INT_MAX;
	}
	for(int i=0;i<n;i++)
		if(!visited[i])
			DFS(i);
}

int main()
{
	//BoostIO;
	//ReadFile;
	int tc;
	scanf("%d",&tc);
	while(tc--)
	{
		int n,m,k;
		scanf("%d%d%d",&n,&m,&k);
		for(int i=0;i<n;i++)
			a[i].clear();
		for(int i=0;i<m;i++)
		{
			int x,y;
			scanf("%d%d",&x,&y);
			a[x].pb(y);
			a[y].pb(x);
		}
		int cnt=0;
		ArticulationPoints(n);
		cnt=ap*k;
		printf("%d\n",cnt);
	}
	return 0;
}