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