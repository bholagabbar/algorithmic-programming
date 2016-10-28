// SPOJ: QTREE

//Shreyans Sheth [bholagabbar]
 
#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","v",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set
#define hashmap unordered_map
#define SI(x)  scanf("%d", &x)
#define SL(x)  scanf("%ld", &x)
#define SD(x)  scanf("%lf", &x)
#define SS(x)  scanf("%s", x)
#define PI(x)  printf("%d", x)
#define PL(x)  printf("%ld", x)
#define PS(x)  printf("%s", x);
#define SLL(x) scanf("%lld", &x)
#define PLL(x) printf("%ld", x)
#define pb push_back
#define mp make_pair
#define N 10001
#define LN 14
#define F first
#define S second
#define endl '\n'
 
typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

vector<int> adj[N];
vector<int> edges[N];
vector<int> idx[N];
 
int subSize[N];
int depth[N];
 
int lca[LN][N];
 
int segTree[N<<2];
int lazy[N<<2];
 
int pos;
int chainNo;
int chainHead[N];
int chainIndex[N];
int arr[N];
int basePos[N];
int endNode[N];
 
void Dfs(int node, int parent, int level) {
    depth[node] = level;
    lca[0][node] = parent;
    subSize[node] = 1;
    int x = adj[node].size();
    while (x--) {
        int next = adj[node][x];
        if (next != parent){
            endNode[idx[node][x]] = next;
            Dfs(next, node, level+1);
            subSize[node] += subSize[next];
        }
    }
}
 
void heavyLightDecomposition(int node, int cost, int parent) {
    if (chainHead[chainNo] == -1) {
        chainHead[chainNo] = node;
    }
    pos++;
    chainIndex[node] = chainNo;
    basePos[node] = pos;
    arr[pos] = cost;
    int specialChild = -1, edgeCost = 0;
    int x = adj[node].size();
    while (x--) {
        int next = adj[node][x];
        if (next != parent) {
            if (specialChild == -1 || subSize[next] > subSize[specialChild]) {
                specialChild = next;
                edgeCost = edges[node][x];
            }
        }
    }
    if (specialChild != -1) {
        heavyLightDecomposition(specialChild, edgeCost, node);
    }
    x = adj[node].size();
    while (x--) {
        int next = adj[node][x];
        if (next != parent && next != specialChild) {
            chainNo++;
            heavyLightDecomposition(next, edges[node][x], node);
        }
    }
}
 
void initializeLCA(int n) {
    for (int j = 1; j < LN; j++) {
        for (int i = 1; i <= n; i++) {
            lca[j][i] = lca[j - 1][lca[j - 1][i]];
        }
    }
}
 
int LCA(int x, int y) {
    if (depth[x] < depth[y]) {
        std::swap(x, y);
    }
    for (int i = LN - 1; i >= 0; i--) {
        if (depth[x] - (1 << i) >= depth[y]) {
            x = lca[i][x];
        }
    }
    if (x == y) {
        return x;
    }
    for (int i = LN - 1; i >= 0; i--) {
        if (lca[i][x] != lca[i][y]) {
            x = lca[i][x];
            y = lca[i][y];
        }
    }
    return lca[0][x];
}

void buildSegTree(int node, int a, int b) {
    if(a > b) {
        return;
    }
    if(a == b) {
        segTree[node] = arr[a];
        return;
    }
    buildSegTree((node << 1), a, (a + b) >> 1);
    buildSegTree((node << 1) + 1, 1+((a + b) >> 1), b);
    segTree[node] = std::max(segTree[node << 1], segTree[(node << 1) + 1]);
}

void updateSegTree(int node, int a, int b, int i, int j, int val) {
 
    if(lazy[node] != 0) {
        segTree[node] = lazy[node];
        if(a != b) {
            lazy[node<<1] = lazy[node];
            lazy[(node<<1)+1] = lazy[node];
        }
        lazy[node] = 0;
    }
    if(a > b || a > j || b < i) {
        return;
    }
    if(a >= i && b <= j) {
        segTree[node] = val;
        if(a != b) {
            lazy[node<<1] = val;
            lazy[(node<<1)+1] = val;
        }
        return;
    }
    updateSegTree(node << 1, a, (a + b) >> 1, i, j, val);
    updateSegTree((node << 1) + 1, 1 + ((a + b) >> 1), b, i, j, val);
    segTree[node] = std::max(segTree[node << 1], segTree[(node << 1) + 1]);
}

int querySegTree(int node, int a, int b, int i, int j) {
 
    if(a > b || a > j || b < i) {
        return INT_MIN;
    }
    if(lazy[node] != 0) {
        segTree[node] = lazy[node];
        if(a != b) {
            lazy[node << 1] = lazy[node];
            lazy[(node << 1) + 1] = lazy[node];
        }
        lazy[node] = 0;
    }
    if(a >= i && b <= j) {
        return segTree[node];
    }
    return std::max(querySegTree((node << 1), a, (a+b) >> 1, i, j), querySegTree((node << 1) + 1, 1 + ((a + b) >> 1), b, i, j));
}

int queryUp(int u,int v) {
    if(u == v) {
        return 0;
    }
    int lchain, rchain = chainIndex[v], ans = -1;
    while (1) {
        lchain = chainIndex[u];
        if(lchain == rchain) {
            if(u == v) {
                break;
            }
            int currAns = querySegTree(1, 1, pos, basePos[v] + 1, basePos[u]);
            ans = std::max(ans, currAns);
            break;
        }
        int currAns = querySegTree(1, 1, pos, basePos[chainHead[lchain]], basePos[u]);
        ans = std::max(ans, currAns);
        u = chainHead[lchain];
        u = lca[0][u];
    }
    return ans;
}

void Initialize(int n) {
    for (int i = 0; i <= n; i++) {
        adj[i].clear();
        edges[i].clear();
        idx[i].clear();
        chainHead[i] = -1;
        for (int j = 0; j < LN; j++) {
            lca[j][i]=-1;
        }
    }
}

int queryPath(int u, int v) {
    int lca = LCA(u, v);
    int a = queryUp(u, lca);
    int b = queryUp(v, lca);
    return std::max(a, b);
}

void Update(int i, int val) {
    int node = endNode[i];
    updateSegTree(1, 1, pos, basePos[node], basePos[node], val);
}

int main() {
    int t;
    SI(t);
    while (t--) {
        int n;
        SI(n);
        Initialize(n);
        for (int i=1;i<n;i++) {
            int u, v, w;
            SI(u), SI(v), SI(w);
            adj[u].pb(v);
            edges[u].pb(w);
            idx[u].pb(i);
            adj[v].pb(u);
            edges[v].pb(w);
            idx[v].pb(i);
        }
        Dfs(1, 0, 0);
        initializeLCA(n);
        pos = -1;
        chainNo = 1;
        heavyLightDecomposition(1, 0, 0);
        buildSegTree(1, 1,pos);
        char str[10];
        scanf("%s", str);
        while (str[0] != 'D') {
            int u ,v;
            SI(u), SI(v);
            if (str[0] == 'Q') {
                PI(queryPath(u, v));
                printf("\n");
            } else {
                Update(u, v);
            }
            scanf("%s", str);
        }
    }
    return 0;
}