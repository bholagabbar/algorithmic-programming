/*input
3 4
1 2
2 3
2 4
4 1
*/
//Cycles in undirected graph
#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define printPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(false)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl '\n'
typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

//Shreyans Sheth [bholagabbar]

const int sz=100005;
vector<int> graph[sz];
bool vis[sz]={0}, hasCycle=0;

void DFS(int s,int p)//source, parent
{
	vis[s]=true;
	for(int i:graph[s])
	{
		if(!vis[i] && !hasCycle)
			DFS(i,s);
		else if(i!=p)//and IF you find a neighbor of the node which is VISITED and NOT its parent, CYCLE exists
		{
			hasCycle=1;
			return;
		}
	}
}


int main()
{
	//readFile
	boostIO;
	int n,m,x,y;
	cin>>n>>m;
	for(int i=0;i<m;i++)
	{
		cin>>x>>y;
		graph[x].pb(y);
		graph[y].pb(x);
	}
	for(int i=1;i<=n;i++)
	{
		if(!vis[i])
			DFS(i,i);
		if(hasCycle)
			break;
	}
	if(!hasCycle)
		cout<<"YES";
	else
		cout<<"NO";
	return 0;
}