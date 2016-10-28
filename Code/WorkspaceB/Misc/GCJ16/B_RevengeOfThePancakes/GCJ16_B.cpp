
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
#define N 100010
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

int main() {
	boostIO;
	int tcno;
	cin >> tcno;
	for (int tc = 1; tc <= tcno; tc++) {
		string s;
		cin >> s;
		int len = s.size(), ptr = 1, cnt = 0;
		while (ptr < len) {
			if (s[ptr] == s[ptr - 1]) {
				ptr++;
			} else {
				s[ptr - 1] = s[ptr];
				cnt++;
			}
		}
		if (s[ptr - 1] == '-') {
			cnt++;
		}
		cout << "Case #" << tc << ": " << cnt << endl;
	}
	return 0;
}