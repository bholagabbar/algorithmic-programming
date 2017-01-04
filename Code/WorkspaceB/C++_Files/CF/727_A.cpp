/*input
100 40021
*/
//Shreyans Sheth [bholagabbar | http://shreyanssheth.com]

#include <bits/stdc++.h>
using namespace std;
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

int limit = 1000000000;
bool found = false;
vector<int> ans;

void dfs(int s, int target, vector<int> v) {
	if (!found) {
		v.PB(s);
		if (s > limit) {
			return;
		}
		if (s == target) {
			found = true;
			for (int i : v) {
				ans.PB(i);
			}
			return;
		}
		int a1 = s * 2;
		dfs(a1, target, v);
		int a2 = 10 * s + 1;
		dfs(a2, target, v);
		v.pop_back();
	}
}

int main() {
    boostIO;
    int a, b;
    cin >> a >> b;
    vector<int> v;
    dfs(a, b, v);
    if (!found) {
    	cout << "NO";
    } else {
    	cout << "YES\n" << ans.size() << "\n";
    	for (int i : ans) {
    		cout << i << " ";
    	}
    }
    return 0;
}