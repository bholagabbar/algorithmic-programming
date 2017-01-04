
//Shreyans Sheth [bholagabbar | http://shreyanssheth.com]

#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/algorithmic-programming/Code/WorkspaceB/C++_Files/INPUT.txt","r",stdin);
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
#define N 100001
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

vector<int> a[N];
vector<int> cycleElements;
bool vis[N] = {0};
int parent[N];
bool isMonster = false;
bool hasMultipleCycles = false;

void isValidMonsterDfs(int s) {
	if (!hasMultipleCycles) {
		vis[s] = true;
		for (int i : a[s]) {
			parent[i] = s;
			if (vis[i] && i != parent[s]) {
				if (!isMonster) {
					int curr = i;
					while(parent[curr] != curr) {
						cycleElements.PB(curr);
						curr = parent[curr];
					}
					cycleElements.PB(curr);
					isMonster = true;
				} else {
					hasMultipleCycles = true;
				}
			} else {
				hasCycle(i, s);
			}
		}
		vis[s] = false;
	}
}

bool hasCycle(int s, int o) {

}

int main() {
    boostIO;
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
    	int v1, v2;
    	cin >> v1 >> v2;
    	a[v1].PB(v2);
    	a[v2].PB(v1);
    }
    for (int i = 1; i <= n; i++) {
    	parent[i] = i;
    }
    if ()
    
    return 0;
}