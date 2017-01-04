# Team TrieHard

## Datastructure and Algorithms for ICPC

### C++ Template


```
//Shreyans Sheth [bholagabbar | http://shreyanssheth.com]

#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("INPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define SLL(x) scanf("%lld", &x)
#define PLL(x) printf("%ld", x)
#define SI(x)  scanf("%d", &x)
#define SL(x)  scanf("%ld", &x)
#define SD(x)  scanf("%lf", &x)
#define SS(x)  scanf("%s", x)
#define PI(x)  printf("%d", x)
#define PL(x)  printf("%ld", x)
#define PS(x)  printf("%s", x);
#define hashset unordered_set
#define hashmap unordered_map
#define PB push_back
#define MP make_pair
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

int main() {
    boostIO;
    
    
    return 0;
}
```


### Segment Tree

```
/*input
7
2 3 6 7 8 9 20
*/
#include <bits/stdc++.h>
using namespace std;
#define sz 100005

int arr[sz];

int segTree[sz << 2];
int lazy[sz << 2];

void buildSegTree(int node, int a, int b) {
    if (a > b) {
        return;
    }
    if (a == b) {
        segTree[node] = arr[a];
        return;
    }
    buildSegTree((node << 1), a, (a + b) >> 1);
    buildSegTree((node << 1) + 1, 1 + ((a + b) >> 1), b);
    segTree[node] = std::max(segTree[node << 1], segTree[(node << 1) + 1]);
}

void updateSegTree(int node, int a, int b, int i, int j, int val) {

    if (lazy[node] != 0) {
        segTree[node] += lazy[node];
        if (a != b) {
            lazy[node << 1] += lazy[node];
            lazy[(node << 1) + 1] += lazy[node];
        }
        lazy[node] = 0;
    }
    if (a > b || a > j || b < i) {
        return;
    }
    if (a >= i && b <= j) {
        segTree[node] += val;
        if (a != b) {
            lazy[node << 1] += val;
            lazy[(node << 1) + 1] += val;
        }
        return;
    }
    updateSegTree(node << 1, a, (a + b) >> 1, i, j, val);
    updateSegTree((node << 1) + 1, 1 + ((a + b) >> 1), b, i, j, val);
    segTree[node] = std::max(segTree[node << 1], segTree[(node << 1) + 1]);
}

int querySegTree(int node, int a, int b, int i, int j) {

    if (a > b || a > j || b < i) {
        return INT_MIN;
    }
    if (lazy[node] != 0) {
        segTree[node] += lazy[node];
        if (a != b) {
            lazy[node << 1] += lazy[node];
            lazy[(node << 1) + 1] += lazy[node];
        }
        lazy[node] = 0;
    }
    if (a >= i && b <= j) {
        return segTree[node];
    }
    return std::max(querySegTree((node << 1), a, (a + b) >> 1, i, j), querySegTree((node << 1) + 1, 1 + ((a + b) >> 1), b, i, j));
}

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    buildSegTree(1, 0, n - 1);
    cout << querySegTree(1, 0, n - 1, 0, 4) << endl;
    cout << querySegTree(1, 0, n - 1, 2, 5) << endl;
    updateSegTree(1, 0, n - 1, 2, 5, 10);
    cout << querySegTree(1, 0, n - 1, 2, 5) << endl;
    return 0;
}
```


### BIT (Regular)

```
//MARBLEGF codechef
/*input
5 3
1000 1002 1003 1004 1005
S 0 2
G 0 3
S 0 2
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define sz 100001

//Created by Shreyans Sheth [bholagabbar]

typedef long long int ll;

int a[sz];

//BIT Start

ll BIT[sz] = {0};

void BuildBIT(int N) {
	for (int i = 1; i <= N; i++) {
		ll value = a[i - 1];
		int k = i;
		while (k <= N) {
			BIT[k] += value;
			k += (k & (-k));
		}
	}
}

ll QueryBIT(int b) {
	ll sum = 0;
	b += 1;
	while (b > 0) {
		sum += BIT[b];
		b -= (b & (-b));
	}
	return sum;
}

void UpdateBIT(int k, ll v, int N) {
	k += 1;
	while (k <= N) {
		BIT[k] += v;
		k += (k & (-k));
	}
}

//BIT end

int main() {
	ios_base::sync_with_stdio(false);
	int q;
	cin >> N >> q;
	for (int i = 0; i < N; i++)
		cin >> a[i];
	BuildBIT();
	char ch;
	int a, b;
	while (q--) {
		cin >> ch >> a >> b;
		if (ch == 'S')
			cout << (QueryBIT(b) - QueryBIT(a - 1)) << endl;
		else if (ch == 'G')
			UpdateBIT(a, b);
		else
			UpdateBIT(a, -b);
	}
	return 0;
}
```

### Trie (Sparse)
```
int next[27][MaxN];
int end[MaxN];
bool created[MaxN];

void insert (string &s) {
	int v = 0;

	for (int i = 0; i < s.size(); ++i) {
		int c = s[i] - 'a';
		if (!created[next[c][v]]) {
			next[c][v] = ++sz;
			created[sz] = true;
		}
		v = next[c][v];
	}
	++end[v];
}

bool search (string tmp) {
	int v = 0;
	
	for (int i = 0; i < tmp.size(); ++i) {
		int c = tmp[i] - 'a';
		if (!created[next[c][v]])
			return false;
		v = next[c][v];
	}
	return end[v] > 0;
}

int main () {
	string keys[] = {"hi", "hello", "you", "ekta", "me"};
	string output[] = {"NO", "YES"};

	for (int i = 0; i < 5; ++i)
		insert (keys[i]);

	cout << output[search ("my")] << endl;
	cout << output[search ("me")] << endl;
	
	return 0;
}
```


### Prime Sieve (SoE)
```
bool prime[sz];

void Sieve() {
	prime[0] = prime[1] = 0;
	for (ll i = 2; i <= sz; i++) {
		prime[i] = 1;
	}
	for (ll i = 2; i * i <= sz; i++) {
		if (prime[i]) {
			for (ll j = i * i; j < size; j += i) {
				prime[j] = 0;
			}
		}
	}
}

```


### Pascal's Triangle for NcR
```
const ll MOD = 1e9 + 7;

ll C[5001][5001];

void getCombinations(int n, int r) {
	for (int i = 0; i <= n; i++) {
		for (int k = 0; k <= r && k <= i; k++) {
			C[i][k] = (k == 0 || k == i) ? 1 : (C[i - 1][k - 1] % MOD + C[i - 1][k] % MOD) % MOD;
		}
	}
}

int main() {
	getCombinations(5000, 5000);
	cout << C[4][2] << endl;
	return 0;
}
```

### Disjoint Set Union
```
inline int Find(int x) {
    if (u[x] != u[u[x]]) {
        u[x] = Find(u[x]);
    }
    return u[x];
}

bool Union(int x, int y) {
    int px = Find(x), py = Find(y);
    if (px == py) {
        return false;
    }
    if (r[px] > r[py]) {
        std::swap(px, py);
    } else if (r[px] == r[py]) {
        r[py]++;
    }
    u[px] = py;
    return true;
}

void initializeDSU(int l) {
    for (int i = 1; i <= l; i++) {
        u[i] = i;
        r[i] = 1;
    }
}

```


### Lowest Common Ancestor (LCA)
```
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
```



### Kruskal MST
```

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
#define sz 100001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

class Node {
public:
    int v1, v2, w;
    Node(int V1, int V2, int W) {
        this->v1 = V1;
        this->v2 = V2;
        this->w = W;
    }
    bool operator<( const Node &e ) const { return e.w < w; }
};

int u[100001];
int r[100001];

inline int FIND(int x) {
    if (u[x] != u[u[x]]) {
        u[x] = FIND(u[x]);
    }
    return u[x];
}

bool UNION (int x, int y) {
    int px = FIND(x), py = FIND(y);
    if (px == py) {
        return false;
    }
    if (r[px] > r[py]) {
        swap(px, py);
    } else if (r[px] == r[py]) {
        r[py]++;
    }
    u[px] = py;
    return true;
}

void initializeDSU(int l) {
    for (int i = 1; i <= l; i++) {
        u[i] = i;
        r[i] = 1;
    }
}

int main() {
    int n, m;
    cin >> n >> m;
    vector<Node> edges;
    initializeDSU(n);
    for (int i = 0; i < m; i++) {
        int x1, y1, w1;
        cin >> x1 >> y1 >> w1;
        edges.pb(Node(x1, y1, w1));
    }
    sort(edges.begin(), edges.end());

    ll sum = 0;
    int ecnt = 0;

    while (ecnt != n - 1) {
        Node cur = edges[edges.size() - 1];
        edges.pop_back();
        if (UNION(cur.v1, cur.v2)) {
            ecnt++;
            sum += cur.w;
        }
    }
    cout << sum << endl;
    return 0;
}
```



### Dijikstra

```
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define pii pair<int,int>
#define F first
#define S second
#define mp make_pair
#define pb emplace_back

bool vis[100001];
int dis[100001];
vector<pii> a[100001];

class prioritize {
public: bool operator ()(pii &p1 , pii &p2) {
		return p1.S > p2.S;
	}
};

int Dijkstra(int s, int n) {
	for (int i = 0; i <= n; i++) {
		vis[i] = false;
		dis[i] = INT_MAX;
	}
	priority_queue<pii, vector<pii>, prioritize> pq;
	pq.push(mp(s, dis[s] = 0));
	while (!pq.empty()) {
		pii cur = pq.top(); pq.pop();
		int cv = cur.F, cw = cur.S;
		if (vis[cv]) continue;
		vis[cv] = true;
		for (pii x : a[cv]) {
			if (!vis[x.F] && (cw + x.S) < dis[x.F]) {
				pq.push(mp(x.F, dis[x.F] = cw + x.S));
			}
		}
	}
}

int main() {
	int tc;
	cin >> tc;
	while (tc--) {
		int v1, v2, w, n, m;
		cin >> n >> m;
		for (int i = 0; i <= n; i++) {
			a[i].clear();
		}
		for (int i = 0; i < m; i++) {
			cin >> v1 >> v2 >> w;
			a[v1].pb(mp(v2, w));
		}
		int s;
		cin >> s;
		Dijkstra(s, n);
		for (int i = 1; i <= n; i++) {
			if (dis[i] != INT_MAX) {
				cout << dis[i] << " ";
			} else {
				cout << "-1 ";
			}
		}
	}
	return 0;
}

```


### Floyd Warshall
```

const int N = 100;
long a[N + 1][N + 1] = {0};

void floyd_warshall(int v) {
    for (int k = 1; k <= v; k++) {
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (a[i][k] + a[k][j] < a[i][j]) {
                    a[i][j] = a[i][k] + a[k][j];
                }
            }
        }
    }
}

```


### Z Algorithm
```
/*input
aaaaa
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

int main() {
    ios_base::sync_with_stdio(false);//FAST IO
    string s;
    cin >> s;
    int n = s.size();
    int z[n];
    for (int i = 0; i < n; i++)
        z[i] = 0;
    for (int i = 1, l = 0, r = 0; i < n; ++i) {
        if (i <= r)
            z[i] = min(r - i + 1, z[i - l]);
        while (i + z[i] < n && s[z[i]] == s[i + z[i]])
            z[i]++;
        if (i + z[i] - 1 > r)
            r = i + z[i] - 1, l = i;
    }
    for (auto i : z)
        cout << i << " ";
    return 0;
}

```


### Rabin Karp (Rolling Hashing)
```
/*input
3
ababab ab
aaaaa bbb
aafafaasf aaf
*/

//SPOJ NAJPF

//Shreyans Sheth [bholagabbar]

#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set
#define hashmap unordered_map
#define PB push_back
#define MP make_pair
#define N 1000001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

const ll modPrime = 1e9 + 7;
const ll base = 257;
ll storedPowers[N];

void calculatePowers() {
	storedPowers[0] = 1;
	for (int i = 0; i < N; i++) {
		storedPowers[i + 1] = (base * storedPowers[i]) % modPrime;
	}
}

ll getStringHash(string s) {
	ll hashValue = 0;
	//essentially from x^n + x^n-1 .....x^0 as coeffs
	for (int i = 0; i < s.size(); i++) {
		hashValue = hashValue * base + s[i];
		hashValue %= modPrime;
	}
	return hashValue;
}

int main() {
	boostIO;
	calculatePowers();
	int tc;
	cin >> tc;
	while (tc--) {
		string text, pattern;
		cin >> text >> pattern;
		int textLen = text.size(), patternLen = pattern.size();
		ll basePower = storedPowers[patternLen];
		ll patternHash = getStringHash(pattern);
		ll currTextHash = getStringHash(text.substr(0, patternLen));
		vector<int> occurences;
		for (int i = patternLen; i <= textLen; i++) {
			if (patternHash == currTextHash) {
				occurences.PB(i - patternLen + 1);
			}
			if (i < textLen) {
				currTextHash = (currTextHash * base + text[i]) % modPrime; //add new digit, multiply by base
				currTextHash -= (text[i - patternLen] * basePower) % modPrime; //remove digit
				currTextHash = currTextHash < 0 ? currTextHash + modPrime : currTextHash; //+MOD if -ve
			}
		}
		if (occurences.size() > 0) {
			cout << occurences.size() << endl;
			for (int i : occurences) {
				cout << i << " ";
			}
		} else {
			cout << "Not Found";
		}
		cout << endl << endl;
	}
	return 0;
}
```


### Tarjans's Algorithm for SCC in Directed Graph

```
/*input
0 1
1 2
2 0
1 3
1 4
1 6
3 5
*/
#include <bits/stdc++.h>
using namespace std;
#define sz 100001

//const int n=875715;
vector <int> a[sz]; //Graph as adjacency list
int low[sz]; //Lowest node reachable from given node
int disc[sz]; //Stores order in which node was discovered
stack <int> s; //Stack to store the members of a SSC
bool instack[sz]; //To check if element is in the stack
int block[sz]; //stores number of the SCC
int cc = 0;

void DFS(int x) {
	static int tm = 0; //Time for each nodes discovered
	low[x] = disc[x] = tm; //Time discovered
	s.push(x); //Pushing element onto stack
	instack[x] = true; //Current element is in the stack
	for (int i : a[x]) { //Iterating through vertices of current node
		if (disc[i] == -1) {
			DFS(i);//Recursively executing DFS on this node
			low[x] = min(low[x], low[i]); //Lowest anchestor node reachable (Tree Edge)
		} else if (instack[i]) //Checking if it is not a cross edge (Back Edge)
			low[x] = min(low[x], disc[i]); //Lowest anchestor reachable
	}
	int size = 0;
	if (low[x] == disc[x]) { //Head of the SCC found
		cc++;
		while (low[x] == s.top()) {
			int y = s.top(); //Getting the element
			s.pop();
			instack[y] = 0; //Now not in stack
			block[y] = cc;
		}
		//For last element
		int y = s.top();
		s.pop();
		instack[y] = 0;
		block[y] = cc;
	}
}

void Tarjan() {
	for (int i = 1; i < n; i++) { //Initiliazing values
		low[i] = disc[i] = -1;
		instack[i] = 0;
	}
	for (int i = 1; i < n; i++)
		if (disc[i] == -1) //Node not discovered as yet
			DFS(i); //Run DFS on this
}

int main() {
	//freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
	//long long tc=5105043;
	int tc = 7;
	for (int i = 0; i < tc; i++) {
		int x, y;
		cin >> x >> y;
		a[x].push_back(y);
	}
	Tarjan();
	for (auto it : block) {
		cout << it << "\n";
	}
	return 0;
}
```

### BFS in a Grid

```
import java.util.*;

/**
 * Created by Shreyans on 4/30/2015 at 10:27 PM using IntelliJ IDEA
 */

class MAZE {
    static int r, c, s1, s2, f1, f2; //Rows, Columns, Start Coordinates, Finish Coordinates
    static int[] dx = {1, -1, 0, 0}; //right, left, NA, NA
    static int[] dy = {0, 0, 1, -1}; //NA, NA, bottom, top
    static char[][] grid;//Main grid
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //I suggest using faster IO if you have performance concerns. I did. Scanner is readable hence the choice
        r = sc.nextInt();
        c = sc.nextInt();
        grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            char[] s1 = sc.next().toCharArray(); //Reading a line of the Grid
            System.arraycopy(s1, 0, grid[i], 0, c); //Nice inbuilt function to copy contents of an array. Also doable manually
        }
        s1 = sc.nextInt() - 1;
        s2 = sc.nextInt() - 1;
        f1 = sc.nextInt() - 1;
        f2 = sc.nextInt() - 1;
        if (MAZEBFS()) {
            System.out.println("PATH EXISTS");
        } else {
            System.out.println("PATH DOES NOT EXIST");
        }
    }
    private static boolean MAZEBFS() {
        if (s1 == f1 && s2 == f2) {
            return true;//He's already there
        } else {
            grid [f1][f2] = 'G'; //finish
            Queue<int[]> q = new LinkedList<int[]>();
            int[]start = {s1, s2}; //Start Coordinates
            q.add(start);//Adding start to the queue since we're already visiting it
            grid[s1][s2] = 'B';
            while (q.peek() != null) {
                int[]curr = q.poll(); //poll or remove. Same thing
                for (int i = 0; i < 4; i++) { //for each direction
                    if ((curr[0] + dx[i] >= 0 && curr[0] + dx[i] < r) && (curr[1] + dy[i] >= 0 && curr[1] + dy[i] < c)) {
                        //Checked if x and y are correct. ALL IN 1 GO
                        int xc = curr[0] + dx[i]; //Setting current x coordinate
                        int yc = curr[1] + dy[i]; //Setting current y coordinate
                        if (grid[xc][yc] == 'G') { //Destination found
                            //System.out.println(xc+" "+yc);
                            return true;
                        } else if (grid[xc][yc] == 'E') { //Movable. Can't return here again so setting it to 'B' now
                            //System.out.println(xc+" "+yc);
                            grid[xc][yc] = 'B'; //now BLOCKED
                            int[]temp = {xc, yc};
                            q.add(temp);//Adding current coordinates to the queue
                        }
                    }
                }
            }
            return false;//Will return false if no route possible
        }
    }
}
```


### Find Articulation Points

```
/*input
7 6
0 1
1 2
3 4
2 4
2 6
5 2
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define pb emplace_back
#define sz 3005 //In the current scenario, I need only a maximum on 3000 vertices

typedef long long int ll;

//Created by Shreyans Sheth [bholagabbar]

bool visited [sz]; //whether the node has been discoverd in the DFS run or not
int low [sz]; //time of the earliest discovered vertex reachable from the vertex
int disc [sz]; //time at which vertex was explored
int parent [sz]; //stores the parents of each vertex
vector<int> a[sz]; //Adjacency List for graph //Time
vector<int> ap; //Stored the articulation points
int rtime; //Discovery time for each node

void DFS(int s)
{
    visited[s]=1;
    low[s]=disc[s]=++rtime;
    int nchild=0;
    int isArticulation = 0;
    for(auto i:a[s])
    {
        if(!visited[i])
        {
            nchild++;//INcrement children of the current vertex
            parent[i]=s;
            DFS(i);
            low[s]=min(low[s],low[i]);
            /* s is an articulation point iff
             1. It the the root and has more than 1 child.
             2. It is not the root and no vertex in the subtree rooted at one of its
                children has a back-link to its ancestor.
                A child has a back-link to an ancestor of its parent when its low
                value is less than the discovery time of its parent.*/
                if (low[i] >= disc[s] || (parent[s]!=-1 && low[i]>=disc[s]))
                    isArticulation = 1;
        }
        else if(i != parent[s])
            low[s] = min(low[s], disc[i]);
    }
    if (isArticulation)
        ap.pb(s); 
} 

void ArticulationPoints(int n)//Driver Funtion
{
	ap.clear();
	rtime=0;//The time for each cycle of DFS
	for(int i=0;i<n;i++)
	{
		parent[i]=-1;//Initializing parents as -1. True for roots
		visited[i]=0;//All points not visited
		low[i]=disc[i]=INT_MAX;
	}
	for(int i=0;i<n;i++)
		if(!visited[i])//Vertex not discoverdd
			DFS(i);
}

int main()
{
	int n,m;//number of vertices, edges
	cin>>n>>m;
	for(int i=0;i<m;i++)//Building Graph
	{
		int x,y;
		cin>>x>>y;
		a[x].pb(y);
		a[y].pb(x);
	}
	ArticulationPoints(n);//Calculating Articulation points
	cout<<"Articulation Points are:\n";
	for(int i:ap)
		cout<<i<<endl;
	return 0;
}
```

### DP - LIS
```
int[] dp = new int[n];//Storing length of max subsequence
		int max = dp[0] = 1;
		String seq = ls[0] = s1[0];
		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			String x = "";
			for (int j = i - 1; j >= 0; j--) {
				//First check if number at index j is less than num at i.
				// Second the length of that DP should be greater than dp[i]
				// -1 since dp of previous could also be one. So we compare the dp[i] as empty initially
				if (a[j] < a[i] && dp[j] > dp[i] - 1) {
					dp[i] = dp[j] + 1;
					x = ls[j];
				}
			}
			x += (" " + a[i]);
			ls[i] = x;
			if (dp[i] > max) {
				max = dp[i];
				seq = ls[i];
			}
		}
```


### DP - LCS
```
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (a[i] == b[j]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
```