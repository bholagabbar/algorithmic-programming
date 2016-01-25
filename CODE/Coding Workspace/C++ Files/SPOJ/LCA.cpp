/*input
1
7
3 2 3 4
0
3 5 6 7
0
0
0
0
2
5 7
2 7
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
#define sz 1001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

vector<int> adj [sz];

//LCA starts

const int logn = 20;
int lca[logn][sz], depth[sz];

void setDepthDFS(int s, int parent, int ind)
{
	depth[s] = ind;
	lca[0][s] = parent;
	for(int i : adj[s]) {
		if(depth[i] == -1) {
			setDepthDFS(i, s, ind+1);
		}
	}
}

void initializeLCA(int n)
{
	for(int i=1; i<=n; i++) {
		depth[i]=-1;
	}
	setDepthDFS(1, -1, 0);
	for (int j = 1; j < logn; j++) {
		for (int i = 1; i <= n; i++) {
			lca[j][i] = lca[j - 1][lca[j - 1][i]];
		}
	}
}

int LCA(int x, int y)
{
	if (depth[x] < depth[y]) {
		swap(x, y);
	}
	for (int i = logn-1; i >= 0; i--) {
		if (depth[x] - (1 << i) >= depth[y]) {
			x = lca[i][x];
		}
	}
	if (x == y) {
		return x;
	}
	for (int i = logn - 1; i >= 0; i--) {
		if (lca[i][x] != lca[i][y]) {
			x = lca[i][x], y = lca[i][y];
		}
	}
	return lca[0][x];
}

//LCA ends

int main()
{
	boostIO;
	int nt, n, m, l, r, v2;
	cin>>nt;
	for(int tc=1; tc<=nt; tc++) {
		cin>>n;
		for(int i=1; i<=n; i++) {
			adj[i].clear();
		}
		for(int v1=1; v1<=n; v1++) {
			cin>>m;
			for(int j=0; j<m; j++) {
				cin>>v2;
				adj[v1].pb(v2);
				adj[v2].pb(v1);
			}
		}
		initializeLCA(n);
		cin>>m;
		cout<<"Case "<<tc<<":\n";
		while(m--) {
			cin>>l>>r;
			cout<<LCA(l,r)<<endl;
		}
	}
	return 0;
}