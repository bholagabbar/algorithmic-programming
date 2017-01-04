/* input
7 10
1 2 4
2 3 10
2 5 7
3 4 4
3 5 3
3 6 6
4 5 12
4 6 5
4 7 8
6 7 12
*/

//Shreyans Sheth [bholagabbar]

#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/CP-algorithmic-programming-database/Code/WorkspaceB/C++ Files/INPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
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

int main() {
    // freopen("/home/student/input.txt", "r", stdin);
    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            if (i != j) {
                a[i][j] = INT_MAX;
            }
        }
    }
    for (int i = 1; i <= m; i++) {
        int v1, v2, w;
        cin >> v1 >> v2 >> w;
        a[v1][v2] = a[v2][v1] = w;
    }
    floyd_warshall(n);
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cout << a[i][j] << " ";
        }
        cout << "\n";
    }
    return 0;

}
