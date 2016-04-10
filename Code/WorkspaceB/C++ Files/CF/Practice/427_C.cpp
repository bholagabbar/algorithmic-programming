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

const ll MOD= 1e9+7;

vector<int> a[sz];

ll minCost [sz];
ll ways=1;
ll mnCost=0;

//Tarjan Starts

int low[sz];
int disc[sz];
int block[sz];
stack<int> st;
bool instack[sz];
static int cc=0;
static int ind=0;

void tarjanDFS(int u)
{
	int v;
	disc[u] = low[u] = ++ind;
	st.push(u);
	instack[u] = true; 
	for (int v : a[u])
	{
		if (!disc[v])
		{
			tarjanDFS(v);
			low[u] = min(low[u], low[v]);
		}
		else if (instack[v])
			low[u] = min(low[u], disc[v]);
	}
	if (disc[u] == low[u])
	{
		cc++;
		ll mn=LONG_MAX, cntmn=0;
		do
		{
			v = st.top(), instack[v] = false;
			st.pop();
			block[v] =cc;
			//Check min
			if(minCost[v] < mn)
			{
				mn=minCost[v];
				cntmn=1;
			}
			else if(minCost[v]==mn)
				cntmn++;
		}
		while (v != u);
		//Update answer
		mnCost+=mn;
		ways=(ways%MOD * cntmn%MOD)%MOD;
	}
}

void Tarjan(int n)
{
	for(int i=1;i<=n;i++)
	{
		low[i]=disc[i]=0;
		instack[i]=0;
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
	cin>>n;
	for(int i=1; i<=n; i++)
		cin>>minCost[i];	
	cin>>m;
	for(int i=0; i<m; i++)
	{
		cin>>x>>y;
		a[x].pb(y);
	}
	Tarjan(n);
	cout<<mnCost<<" "<<ways;
	return 0;
}