/*input
(([{>}{[{[)]]>>]
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

bool isOpen(char c) {
	if (c == '(' || c == '{' || c == '[' || c == '<') {
		return true;
	}
	return false;
}

int getMatching(char c) {
	if (c == '(') {
		return ')';
	}
	if (c == '{') {
		return '}';
	}
	if (c == '[') {
		return ']';
	}
	return '>';
}

int main() {
    boostIO;
    string s;
    cin >> s;
    stack<char> st;
    int ans = 0;
    for (int i = 0; i < s.size(); i++) {
    	char curr = s[i];
    	if (isOpen(curr)) {
    		st.push(curr);
    	} else {
    		if (st.empty()) {
                cout << "Impossible";
                return 0;
            } else if (curr == getMatching(st.top())) {
                st.pop();
            } else {
                ans++;
                st.pop();
            }
    	}
    }
    cout << ans;
    return 0;
}