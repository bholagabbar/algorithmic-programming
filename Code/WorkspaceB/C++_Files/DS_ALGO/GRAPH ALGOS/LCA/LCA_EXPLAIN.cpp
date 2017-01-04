// Algorithm for finding the lowest common ancestor of two nodes in a tree
// with O(N log N) preprocessing and O(log N) query time

#include <bits/stdc++.h>

#define ll long long
#define FOR(i,n) for(int i=0;i<n;++i)
#define pb push_back
#define sz size
#define MAXN 100000
#define LN 17

using namespace std;

vector<ll> g[MAXN];

//We use the array pa[i][j] for determining
//the 2^i. parent of the vertex j
ll pa[LN][MAXN];

//depth[i] stores the distance of the i. vertex from the root
ll depth[MAXN];

//We initialize the pa and the depth array with a depth-first-search
void dfs(ll v, ll parent, ll d) {
	depth[v] = d;
	pa[0][v] = parent;

	FOR(i, g[v].sz()) {
		if (depth[g[v][i]] == -1) dfs(g[v][i], v, d + 1);
	}
}

ll LCA(ll u, ll v) {
	//lets make sure u is deeper than v, and if they are not on the same level in the tree,
	//find an another vertex instead of u which is on the same level with v
	if (depth[u] < depth[v]) swap(u, v);

	//search for a new v vertex
	for (int i = LN; i >= 0; --i) {
		if ( depth[u] - (1 << i) >= depth[v] ) {
			u = pa[i][u];
		}
	}

	if ( u == v ) return u; //if u and v are the same, we are done

	//now find the lowest common ancestor
	for (int i = LN; i >= 0; --i) {
		if ( pa[i][u] != -1 and pa[i][u] != pa[i][v] ) {
			u = pa[i][u];
			v = pa[i][v];
		}
	}

	return pa[0][u];
}

int main(void) {
	//Initialize the depth and pa array
	FOR(i, MAXN) depth[i] = -1;
	FOR(i, LN) FOR(j, MAXN) pa[i][j] = -1;

	//Read the input
	ll n, q; cin >> n >> q;

	FOR(i, n - 1) {
		ll a, b;
		cin >> a >> b;
		a--; b--;
		g[a].pb(b);
		g[b].pb(a);
	}

	//Start the dept-first-search
	dfs(0, -1, 0);

	//Fill the pa array
	for (int i = 1; i < LN; ++i) {
		for (int j = 0; j < n; ++j) {
			if ( pa[i - 1][j] != -1 ) {
				pa[i][j] = pa[i - 1][pa[i - 1][j]];
			}
		}
	}

	//Handle the queries
	FOR(i, q) {
		ll u, v;
		cin >> u >> v;
		u--; v--;
		cout << u + 1 << " " << v + 1 << " " << LCA(u, v) + 1 << endl;
	}

	return 0;
}