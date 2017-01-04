/*input
aaaaa
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

int main() {
    ios_base::sync_with_stdio(false);//FAST IO
    string s;
    cin >> s;
    int n = s.size();
    int z[n];
    for (int i = 0; i < n; i++)
        z[i] = 0;
    for (int i = 1, l = 0, r = 0; i < n; ++i) {
        if (i <= r)
            z[i] = min(r - i + 1, z[i - l]);
        while (i + z[i] < n && s[z[i]] == s[i + z[i]])
            z[i]++;
        if (i + z[i] - 1 > r)
            r = i + z[i] - 1, l = i;
    }
    for (auto i : z)
        cout << i << " ";
    return 0;
}
