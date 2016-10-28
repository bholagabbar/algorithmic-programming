/*input
5
5 1 2 4 3 
0
*/
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
 
int a[N];
 
int main() {
	boostIO;
	int n;
	cin >> n;
	while (n != 0) {
		for (int i = 0; i < n; i++) {
			cin >> a[i];
		}
		int curr_no = 1, i = 0;
		bool flag = 1;
		stack<int> st;
		while (curr_no <= n && flag == 1) {
			while (i < n && a[i] != curr_no) {
				st.push(a[i]);
				i++;
			}
			if (i == n && curr_no <= n && st.empty()) {
				flag = 0;
			} else {
				curr_no++;
				while (!st.empty() && st.top() == curr_no) {
					st.pop();
					curr_no++;
				}
			}
		}
		while (!st.empty() && st.top() == curr_no) {
			st.pop();
			curr_no++;
		}
		if (curr_no == n + 1) {
			flag = 1;
		}
		if (flag == 1) {
			cout << "yes" << endl;
		} else {
			cout << "no" << endl;
		}
		cin >> n;
	}	
	return 0;
} 