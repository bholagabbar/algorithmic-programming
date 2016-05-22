
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
#define N 1000001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

int main() {
	boostIO;
	readFile;
	int a [5];
	for (int i = 0; i < 4; i++) {
		cin >> a[i];
	}
	for (int i : a) {
		cout << i <<" ";
	}
	
	return 0;
}