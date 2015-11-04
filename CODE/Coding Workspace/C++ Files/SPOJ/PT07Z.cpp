/*input
3
1 2
2 3
*/

//Diameter of the graph
#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define printPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(false)
#define CLR(s) memset(&s, 0, sizeof s)
#define PI(x) printf("%d", x)
#define PL(x) printf("%lld", x)
#define SI(x) scanf("%d", &x)
#define SD(x) scanf("%lf", &x)
#define SL(x) scanf("%lld", &x)
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

vector<int> a[sz];
bool vis[sz]={0};
int depth=0,deepestNode=0;

int DFS(int s, int num)
{
	vis[s]=1;
	for(int i:a[s])
		if(!vis[i])
			DFS(i,num+1);
	if(num>depth)
		depth=num, deepestNode=s;
}

int main()
{
	//readFile
	boostIO;
	int n,x,y;
	cin>>n;
	for(int i=0;i<n;i++)
	{
		cin>>x>>y;
		a[x].pb(y);
		a[y].pb(x);
	}
	DFS(1,0);//Finding the deepest node
	CLR(vis);
	int ns=deepestNode;//new source
	deepestNode=depth=0;
	DFS(ns,0);//Finding farthest node from farthest/deepest vertex
	cout<<depth;//number of vertices on the diameter of the graph
	return 0;
}