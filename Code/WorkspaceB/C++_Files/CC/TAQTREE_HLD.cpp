/*input
5
1 2 2
2 3 4
4 2 3
5 4 1
3
2 5 3
1 3 1
2 5 3
*/
//Shreyans Sheth [bholagabbar]

#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set    //JAVA Feels :')
#define hashmap unordered_map
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

vector<int> adj[N];  //adj list
int subSize[N];  //size of the subtree rooted at i
int depth[N];  //depth from root

vector<int> edges[N]; //cost of edges
vector<int> idx[N]; //Indexes of edges

int lca[LN][N]; //for LCA

int segTree[N<<3]; //segTree
int lazy[N<<3] = {0}; //lazy propogation (not needed here, just part of segtree implementation)

int pos; //order in Dfs
int chainNo; //current chain number
int chainHead[N]; //stores the head of the head
int chainIndex[N]; //index of the current chain
int arr[N]; //Base array for segTree
int basePos[N]; //store the position of the node in arr
int endNode[N]; //store the node at the other end of the edge

void Dfs(int node, int parent, int level) {
    depth[node] = level;
    lca[0][node] = parent;
    subSize[node] = 1;
    int x = adj[node].size();
    while (x--) {
        int next  =  adj[node][x];
        if (next != parent){
            endNode[idx[node][x]] = next;
            Dfs(next,node,level+1);
            subSize[node] += subSize[next];
        }
    }
}

void initializeLCA(int n)
{
    for (int j = 1; j < LN; j++) {
        for (int i = 1; i <= n; i++) {
            lca[j][i] = lca[j - 1][lca[j - 1][i]];
        }
    }
}

int LCA(int x, int y)
{
    if (depth[x] < depth[y]) {
        std::swap(x, y);
    }
    for (int i  =  LN - 1; i >= 0; i--) {
        if (depth[x] - (1 << i) >= depth[y]) {
            x  =  lca[i][x];
        }
    }
    if (x  ==  y) {
        return x;
    }
    for (int i  =  LN - 1; i >= 0; i--) {
        if (lca[i][x] != lca[i][y]) {
            x  =  lca[i][x];
            y  =  lca[i][y];
        }
    }
    return lca[0][x];
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

int queryUp(int l, int r) {
    if (l == r) {
        return 0;
    }
    int lchain, rchain = chainIndex[r];
    int ans = 0;
    while (1) {
        lchain = chainIndex[l];
        if (lchain == rchain) {
            if (l == r) {
                break;
            }
            int currAns = querySegTree(1, 1, pos, basePos[r]+1, basePos[l]);
            ans = sum(ans, currAns);
            break;
        }
        int currAns = querySegTree(1, 1, pos, basePos[chainHead[lchain]], basePos[l]);
        ans = sum(ans, currAns);
        l = chainHead[lchain];
        l = lca[0][l];
    }
    return ans;
}

void setup(int n) {
    for (int i = 0;i <= n;i++) {
        adj[i].clear();
        edges[i].clear();
        idx[i].clear();
        chainHead[i] = -1;
        for (int j = 0; j < LN; j++) {
            lca[j][i] = -1;
        }
    }
}

int queryPathSum(int l, int r){
    int lca = LCA(l, r);
    int a = queryUp(l, lca);
    int b = queryUp(r, lca);
    return sum(a, b);
}

void updateEdge(int indice,int val){
    int node = endNode[indice];
    updateSegTree(1, 1, pos, basePos[node], basePos[node], val);
}

int main()
{
    boostIO;
    int n;
    cin >> n;
    setup(n);
    for (int i = 1; i < n; i++) {
        int v1, v2, w;
        cin >> v1 >> v2 >> w;
        adj[v1].pb(v2);
        edges[v1].pb(w);
        idx[v1].pb(i);
        adj[v2].pb(v1);
        edges[v2].pb(w);
        idx[v2].pb(i);
    }
    pos = 1;
    Dfs(1,0,0);
    initializeLCA(n);
    pos = -1;
    chainNo = 1;
    heavyLightDecomposition(1,0,0);
    buildSegTree(1, 1, pos);
    int q;
    cin >> q;
    while (q--) {
        int type, l ,r;
        cin >> type >> l >> r;
        if (type == 2) {
            cout << queryPathSum(l, r) << endl;
        } else {
            updateEdge(l, r);
        }
    }
    return 0;
} 