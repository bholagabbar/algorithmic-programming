#include <bits/stdc++.h>
using namespace std;

const int N=100001;

int prime[N];
int a[N];

void factor_sieve() {
	for (int i = 1; i < N; i++) {
		prime[i] = i;
	}
	for (int i = 2; i*i < N; i++) {
		if (prime[i] == i) {
			for (int j = i*i; j < N; j += i) {
				prime[j] = i;
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(0), cin.tie(0);
	factor_sieve();
	int tc;
	cin >> tc;
	while (tc--) {
		int n;
		cin >> n;
		for (int i = 0; i < n; i++) {
			cin >> a[i];
		}
		set<int> keep_prime_factors;
		for (int i = 0; i < N; i++) {
			int curr = a[i];
			while (curr > prime[curr]) {
				keep_prime_factors.insert(prime[curr]);
				curr /= prime[curr];
			}
			keep_prime_factors.insert(curr);
		}
		keep_prime_factors.insert(2);
		keep_prime_factors.erase(0);
		keep_prime_factors.erase(1);
		int min=INT_MAX;
		for (int curr_prime : keep_prime_factors) {
			int to_add = 0;
			int prev;
			if (a[0] < curr_prime) {
				to_add += curr_prime - a[0];
				prev = curr_prime;
			} else {
				prev = a[0];
				if(a[0] % curr_prime != 0) {
					int fac=a[0] / curr_prime;
					prev = curr_prime * (fac+1);
				}
				to_add += prev - a[0];
			}
			for (int i = 1; i < n; i++) {
				if (to_add > min) break;
				int curr_value = a[i];
				if (curr_value < prev) {
					to_add += prev - curr_value;
					curr_value = prev;
				}
				int was=curr_value;
				if(curr_value % curr_prime != 0) {
					int fac= curr_value / curr_prime;
					curr_value = curr_prime * (fac+1);
				}
				to_add += curr_value - was;
				prev = curr_value;
			}
			min = std::min(min, to_add);
		}
		cout << min <<"\n";
	}
	return 0;
}