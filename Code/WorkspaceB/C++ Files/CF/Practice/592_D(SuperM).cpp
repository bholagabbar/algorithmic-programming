/*input
7 2
1 2
1 3
1 4
3 5
3 6
3 7
2 7
*/
#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(false)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define sz 100005
#define F first
#define S second
#define endl '\n'

typedef pair<int, int> pii;
typedef long long int ll;
typedef pair<ll, ll> pll;
typedef long double ld;

//Shreyans Sheth [bholagabbar]

const int MAX=200000;
bool attackedCity[MAX]={0},vis[MAX]={0};
int deepestNode=MAX,maxDepth=-1,len=0;
vector<int> a[MAX];

bool DFS(int s, int depth)
{
	vis[s]=1;
	bool attacked=attackedCity[s];//If it is an attacked city
	if(attacked)//If this city is one of those attacked
	{
		if(depth>maxDepth)//find max depth
		{
			maxDepth=depth;
			deepestNode=s;
		}
		else if(depth==maxDepth)
			deepestNode=min(deepestNode,s);//Store the minimum indexed deepest node
	}
	for(int i:a[s])
		if(!vis[i])
			attacked=attacked|DFS(i,depth+1);//IMP: if attacked is true and next DFS also returns true,
	if(attacked)							// then the vertex is part of the subtree
		len++; //Increment the length of the subgraph since a valid edge is found
	return attacked;
}


int main()
{
	//readFile
	boostIO;
	int n,m,x,y;
	cin>>n>>m;
	for(int i=0;i<n-1;i++)
	{
		cin>>x>>y;
		a[x].pb(y);
		a[y].pb(x);
	}
	for(int i=0;i<m;i++)
	{
		cin>>x;
		attackedCity[x]=1;
	}
	DFS(x,0);//Caculate subgraph length and deepest node. Take any city as the starting node
	x=deepestNode;
	maxDepth=0,len=0;
	CLR(vis);
	DFS(x,0);//Caculate diameter of the subgraph
	x=min(x,deepestNode);//Again, smallest index of the 2
	int diameter=maxDepth;//max depth from deepest node in subgraph
	ll ans=2*(len-1)-diameter;//2*all edges- diameter
	cout<<x<<endl<<ans;
	return 0;
}