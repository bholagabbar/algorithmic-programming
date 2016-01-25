
//Shreyans Sheth [bholagabbar]
 
#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","v",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set
#define hashmap unordered_map
#define PI(x) printf("%d", x)
#define PL(x) printf("%ld", x)
#define SI(x) scanf("%d", &x)
#define SD(x) scanf("%lf", &x)
#define SL(x) scanf("%lld", &x)
#define pb push_back
#define mp make_pair
#define N 100001
#define LN 17
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

template <typename T>
T sum(T t1, T t2) {
    return t1 + t2;
}
 
vector<int> adj[N];
 
int subSize[N];
int depth[N];
 
int lca[LN][N];
 
int segTree[N<<2];
int lazy[N<<2];

int vertexCost[N];
 
int pos;
int chainNo;
int chainHead[N];
int chainIndex[N];
int arr[N];
int basePos[N];
 
void Dfs(int node, int parent, int level) {
    depth[node] = level;
    lca[0][node] = parent;
    subSize[node] = 1;
    int x = adj[node].size();
    while (x--) {
        int next = adj[node][x];
        if (next != parent){
            Dfs(next, node, level+1);
            subSize[node] += subSize[next];
        }
    }
}
 
void HLD(int node, int cost, int parent) {
    if (chainHead[chainNo] == -1) {
        chainHead[chainNo] = node;
    }
    pos++;
    chainIndex[node] = chainNo;
    basePos[node] = pos;
    arr[pos] = cost;
    int specialChild = -1, specialChildCost = 0;
    int x = adj[node].size();
    while (x--) {
        int next = adj[node][x];
        if (next != parent) {
            if (specialChild == -1 || subSize[next] > subSize[specialChild]) {
                specialChild = next;
                specialChildCost = vertexCost[next];
            }
        }
    }
    if (specialChild != -1) {
        HLD(specialChild, specialChildCost, node);
    }
    x = adj[node].size();
    while (x--) {
        int next = adj[node][x];
        if (next != parent && next != specialChild) {
            chainNo++;
            HLD(next, vertexCost[next], node);
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
    segTree[node] = sum(segTree[node << 1], segTree[(node << 1) + 1]);
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
    segTree[node] = sum(segTree[node << 1], segTree[(node << 1) + 1]);
}

int querySegTree(int node, int a, int b, int i, int j) {
 
    if(a > b || a > j || b < i) {
        return 0;
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
    return sum(querySegTree((node << 1), a, (a+b) >> 1, i, j), querySegTree((node << 1) + 1, 1 + ((a + b) >> 1), b, i, j));
}
 
int queryUp(int u, int v, bool include) {
    int lchain, rchain = chainIndex[v], ans = 0;
    while (1) {
        lchain = chainIndex[u];
        if(lchain == rchain) {
            int currAns = 0;
            //if 'include' is true, then count LCA, else don't (avoid overcounting)
            if(include) {
                currAns = querySegTree(1, 1, pos, basePos[v], basePos[u]);
            } else {
                currAns = querySegTree(1, 1, pos, basePos[v]+1, basePos[u]);
            }
            ans += currAns;
            break;
        }
        int currAns = querySegTree(1, 1, pos, basePos[chainHead[lchain]], basePos[u]);
        ans += currAns;
        u = chainHead[lchain];
        u = lca[0][u];
    }
    return ans;
}
 
void Initialize(int n) {
    for (int i = 0; i <= n; i++) {
        adj[i].clear();
        vertexCost[i] = 0;
        chainHead[i] = -1;
        for (int j = 0; j < LN; j++) {
            lca[j][i] = -1;
        }
    }
}
 
long queryPath(int u, int v) {
    int lca = LCA(u, v);
    long a = queryUp(u, lca, 1);
    long b = queryUp(v, lca, 0);
    int ans = a+b;
    return ans;
}
 
void Update(int i, int val) {
    updateSegTree(1, 1, pos, basePos[i], basePos[i], val);
}
 
int main() {
    int t;
    SI(t);
    int tcnt = 1;
    while (t--) {
        int n;
        SI(n);
        Initialize(n);
        for (int i = 1; i <= n; i++) {
            SI(vertexCost[i]);
        }
        for (int i=1;i<n;i++) {
            int u, v;
            SI(u), SI(v);
            u++, v++;
            adj[u].pb(v);
            adj[v].pb(u);
        }
        Dfs(1, 0, 0);
        initializeLCA(n);
        pos = 0;
        chainNo = 1;
        HLD(1, vertexCost[1], 0);
        buildSegTree(1, 1, pos);
        printf("Case %d:\n", tcnt++);
        int q;
        cin >> q;
        while (q--) {
            int type, u ,v;
            SI(type), SI(u), SI(v);
            if (type == 0) {
                u++, v++;
                printf("%ld\n", queryPath(u, v));
            } else {
                u++;
                Update(u, v);
            }
        }
    }
    return 0;
}
