/*input
aaaaaaaaaa
a
a
*/
#include <cstdio>
#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>
#include <map>
#include <iterator>
#include <set>
#include <iomanip>
#include <vector>
#include <queue>
#include <bitset>
#define FOR(start,end) for(int i = start; i<end; ++i)

using namespace std;

int fra[128], frb[128], frc[128], aux[128];

int main() {
	int i, j, maxb, maxTotal, finalB, finalC;
	char ch;

	string a, b, c;
	cin >> a >> b >> c;

	for (i = 0; i < a.size(); ++i) {
		++fra[a[i]];
		++aux[a[i]];
	}

	for (i = 0; i < b.size(); ++i)
		++frb[b[i]];

	for (i = 0; i < c.size(); ++i)
		++frc[c[i]];

	maxTotal = -1;
	bool ok = true;
	for (i = 0;; ++i) {
		maxb = 1000000000;

		for (ch = 'a'; ch <= 'z'; ++ch) {
			if (frb[ch] > 0)
				maxb = min(maxb, fra[ch] / frb[ch]);
		}

		if (maxb + i > maxTotal) {
			maxTotal = maxb + i;
			finalB = maxb;
			finalC = i;
		}

		for (ch = 'a'; ch <= 'z'; ++ch) {
			fra[ch] -= frc[ch];

			if (fra[ch] < 0) {
				ok = false;
				break;
			}
		}

		if (ok == false)
			break;
	}

	string s;
	for (i = 0; i < finalB; ++i) {
		s += b;

		for (ch = 'a'; ch <= 'z'; ++ch) {
			aux[ch] -= frb[ch];
		}
	}

	for (i = 0; i < finalC; ++i) {
		s += c;

		for (ch = 'a'; ch <= 'z'; ++ch) {
			aux[ch] -= frc[ch];
		}
	}

	for (ch = 'a'; ch <= 'z'; ++ch) {
		while (aux[ch] > 0) {
			s += ch;
			--aux[ch];
		}
	}

	cout << s;

	return 0;
}