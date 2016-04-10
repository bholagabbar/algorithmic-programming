
//Shreyans Sheth [bholagabbar]

#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt", "r", stdin);
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

bool marked[10] = {0};

int main() {
	boostIO;
	int notc;
	cin >> notc;
	for(int tc = 1; tc <= notc; tc++) {
		long n, n_multiple, cnt = 1;
		fill_n(marked, 10, false);
		cin >> n;
		if (n == 0) {
			cout << "Case #" << tc << ": " <<"INSOMNIA" << endl;
		} else {
			bool flag = false;
			while (!flag) {
				n_multiple = n * cnt;
				while (n_multiple > 0) {
					int curr_digit = (n_multiple % 10);
					marked[curr_digit] = true;
					n_multiple /= 10;
				}
				flag = true;
				for (int i = 0; i <= 9; i++) {
					if (!marked[i]) {
						cnt++;
						flag = false;
						break;
					}
				}
			}
			n_multiple = n * cnt;
			cout << "Case #" << tc << ": " <<n_multiple<< endl;
		}
	}
	return 0;
}