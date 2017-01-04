/*input
2
ABCDE
XXBCZQ
BBB
BBBBBB
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

int main() {
    boostIO;
    int tc;
    cin >> tc;
    while (tc--) {
    	string a, b;
    	cin >> a;
    	cin >> b;
    	int mid = a.size() / 2;
    	pair<int, int> keep[26];
    	for (int i = 0; i < 26; i++) {
    		keep[i] = make_pair(-1, -1);
    	}
    	for (int i = 0; i < a.size(); i++) {
    		int curr = a[i] - 'A';
    		if (keep[curr].F == -1 || abs(mid - i) < keep[curr].F) {
    			keep[curr].F = abs(mid - i);
    			keep[curr].S = i;
    		}
    	}
    	int mmin = INT_MAX;
    	for (int i = 0; i < b.size(); i++) {
    		int curr = b[i] - 'A';
    		if (keep[curr] != make_pair(-1, -1)) {
    			int top = keep[curr].S;
    			int right = b.size() - (i + 1);
    			int bottom = a.size() - (keep[curr].S + 1);
    			int left = i;
    			int total = abs(top - right) + abs(right - bottom) + abs(bottom - left) + abs(left - top);
    			mmin = std::min(mmin, total);
    		}
    	}
    	cout << mmin << endl;
    }
    
    return 0;
}