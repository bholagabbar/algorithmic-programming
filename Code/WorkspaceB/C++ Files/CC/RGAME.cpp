#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

const int N=100005;
const ll MOD=1e9+7;

ll a[N];
ll dp[N];

int main() {
	ios_base::sync_with_stdio(0), cin.tie(0);
	int tc, n;
	ll pre, pow2;
	cin >> tc;
	while (tc--) {
		cin >> n;
		for (int i = 0; i <= n; i++) {
			cin >> a[i];
		}
		dp[1] = a[0]*a[1] + a[1]*a[0];
		pre = 2* (a[0] + a[1]);
		pow2 = 4;
		for (int i = 2; i <= n; i++) {
			dp[i] = (2 * (dp[i-1] % MOD) + (a[i] % MOD * pre % MOD) % MOD) % MOD;
			pre = (pre % MOD + (pow2 % MOD * a[i] % MOD) % MOD) % MOD;
			pow2 = (pow2 % MOD * 2) % MOD;
		}
		dp[n] %= MOD;
		cout << dp[n] << "\n";
	}
	return 0;
}