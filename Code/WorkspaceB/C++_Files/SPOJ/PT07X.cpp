/*input
5
1 2
1 3
3 4
3 5
*/
//Shreyans Sheth [bholagabbar]

#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set	//JAVA Feels :')
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define sz 100001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

int n;
vector<int> adj[sz]; //for left

namespace HopcroftKarp
{
	int pairU [sz], pairV[sz], dist[sz];

	bool maxMatchBfs()
	{
	    queue<int> Q;
	    for (int u=1; u<=n; u++)
	    {
	        if (pairU[u]==0)
	        {
	            dist[u] = 0;
	            Q.push(u);
	        }
	        else
	            dist[u] = INT_MAX;
	    }
	    dist[0] = INT_MAX;
	    while (!Q.empty())
	    {
	        int u = Q.front();
	        Q.pop();
	        if (dist[u] < dist[0])
	            for (int v:adj[u])
	                if (dist[pairV[v]] == INT_MAX)
	                {
	                    dist[pairV[v]] = dist[u]+1;
	                    Q.push(pairV[v]);
	                }
	    }
	    return (dist[0] != INT_MAX);
	}

	bool maxMatchDfs(int u)
	{
	    if (u != 0)
	    {
	        for (int v: adj[u])
	            if (dist[pairV[v]] == dist[u]+1 && maxMatchDfs(pairV[v]))
	            {
	                pairV[v] = u;
	                pairU[u] = v;
	                return true;
	            }
	        dist[u] = INT_MAX;
	        return false;
	    }
	    return true;
	}

	int MaximalMatching()
	{
	    for (int u=0; u<=n; u++)
	        pairU[u] = pairV[u]= 0;
	    int maxMatching = 0;

	    while (maxMatchBfs())
	        for (int u=1; u<=n; u++)
	            if (pairU[u]==0 && maxMatchDfs(u))
	                maxMatching++;
	    return maxMatching;
	}
}

int color[sz];
bool vis1[sz]={0};

void BfsColor(int s) //Color alternating levels to get Bipartite graph
{
	queue<pii> q;
	q.push({s,0});
	vis1[s]=1;
	while(!q.empty())
	{
		pii curr=q.front(); q.pop();
		int cv=curr.F, cc=curr.S; //Current vertex, current color
		color[cv]=cc;
		for(int i: adj[cv])
			if(!vis1[i])
				vis1[i]=1, q.push({i,1-cc});
	}
}

int main()
{
	boostIO;
	int a,b;
	cin>>n;
	for(int i=0;i<n-1;i++)		
	{
		cin>>a>>b;
		adj[a].pb(b);
		adj[b].pb(a);
	}
	BfsColor(1);
	int cnt=0;
	for(int i=1;i<=n;i++)
		if(color[i]==1)
			adj[i].clear();
	cout<<HopcroftKarp::MaximalMatching();
	return 0;
}