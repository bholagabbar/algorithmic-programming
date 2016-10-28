#include <bits/stdc++.h>
using namespace std;
#define pb emplace_back

vector<int> g[6];
bool visited[6]={0};

void DFS(int x, int n)
{
	visited[x]=1;
	cout<<x<<" ";
	for(int i:g[x])
		if(!visited[i])
			DFS(i,n);
}

int main()
{
	g[1].pb(5);
	g[1].pb(2);
	g[1].pb(3);
	g[2].pb(5);
	g[2].pb(4);
	g[3].pb(1);
	g[3].pb(5);
	g[3].pb(4);
	g[4].pb(1);
	g[4].pb(3);
	g[4].pb(5);
	g[5].pb(4);
	g[5].pb(1);
	DFS(1,5);
	return 0;
}