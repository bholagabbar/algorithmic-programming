/*input
3 3
1 2
2 3
3 2
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

vector<int> a[sz]; //graph

//Tarjan Starts

int low[sz], disc[sz], ind=0;
int block[sz]; //Stores index of CC
stack<int> st;
bool inStack[sz];
static int cc=0; //total number of CC's

void tarjanDFS(int u)
{
	int v;
	disc[u] = low[u] = ++ind;
	st.push(u);
	inStack[u] = true; 
	for (int v : a[u])
	{
		if (!disc[v])
		{
			tarjanDFS(v);
			low[u] = min(low[u], low[v]);
		}
		else if (inStack[v])
			low[u] = min(low[u], disc[v]);
	}
	if (disc[u] == low[u])
	{
		cc++;
		do
		{
			v = st.top(); st.pop();
			block[v] =cc;
			inStack[v] = false;
		}
		while (v != u);
	}
}

void Tarjan(int n)
{
	for(int i=1;i<=n;i++)
	{
		low[i]=disc[i];
		inStack[i]=false;
	}

	for(int i=1;i<=n;i++)
		if(disc[i]==0)
			tarjanDFS(i);
}

//Tarjan Ends

int main()
{
	boostIO;
	int n, m, x, y;
	cin>>n>>m; //number pf vertices, edges
	for(int i=0; i<m; i++)
	{
		cin>>x>>y;
		a[x].pb(y);
	}
	Tarjan(n);
	cout<<cc<<endl; //Prints number of cc's
	for(int i=1; i<=n; i++) //Prints the cc of each vertex
		cout<<i<<" "<<block[i]<<endl;
	return 0;
}