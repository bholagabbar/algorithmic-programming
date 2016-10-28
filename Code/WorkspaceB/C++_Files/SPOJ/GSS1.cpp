/*input
3 
-1 2 3
1
1 2
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
#define sz 1000001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

struct st_node {
    ll total_sum;
    ll max_left_prefix;
    ll max_right_suffix;
    ll max_sum;
    bool flag = 0;
};

ll arr[sz];

st_node segTree[sz<<2];

void buildSegTree(int node, int a, int b) {
    if(a > b) {
        return;
    }
    if(a == b) {
        segTree[node].total_sum = arr[a];
        segTree[node].max_left_prefix = arr[a];
        segTree[node].max_right_suffix = arr[a];
        segTree[node].max_sum = arr[a];
        return;
    }
    buildSegTree((node << 1), a, (a + b) >> 1);
    buildSegTree((node << 1) + 1, 1 + ((a + b) >> 1), b);

    segTree[node].total_sum = segTree[node << 1].total_sum + segTree[(node << 1) + 1].total_sum;
    segTree[node].max_left_prefix = std::max(segTree[node << 1].max_left_prefix, segTree[node << 1].total_sum + segTree[(node << 1) + 1].max_left_prefix);
    segTree[node].max_right_suffix = std::max(segTree[(node << 1) + 1].max_right_suffix, segTree[(node << 1)].max_right_suffix + segTree[(node << 1) + 1].total_sum);
    segTree[node].max_sum = std::max(segTree[node << 1].max_sum, std::max(segTree[(node << 1) + 1].max_sum, segTree[node << 1].max_right_suffix + segTree[(node << 1) + 1].max_left_prefix));
}

st_node querySegTree(int node, int a, int b, int i, int j) {
 
    if(a > b || a > j || b < i) {
        st_node xx;
        xx.flag = 1;
        return xx;
    }
    if(a >= i && b <= j) {
        return segTree[node];
    }
    st_node ret;
    st_node left = querySegTree((node << 1), a, (a + b) >> 1, i, j);
    st_node right = querySegTree((node << 1) + 1, 1 + ((a + b) >> 1), b, i, j);
    if (left.flag == 1 && right.flag != 1) {
        ret = right;
    } else if (right.flag == 1 && left.flag != 1) {
        ret = left;
    } else if (left.flag != 1 && right.flag != 1) {
        ret.total_sum = left.total_sum + right.total_sum;
        ret.max_left_prefix = std::max(left.max_left_prefix, left.total_sum + right.max_left_prefix);
        ret.max_right_suffix = std::max(right.max_right_suffix, left.max_right_suffix + right.total_sum);
        ret.max_sum = std::max(left.max_sum, std::max(right.max_sum, left.max_right_suffix + right.max_left_prefix));
    } else {
        ret.flag = 1;
    }
    return ret;
}


int main() {
    boostIO;
    int n, m, a, b;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    buildSegTree(1, 0, n-1);
    cin >> m;
    while(m--) {
        cin >> a >> b;
        cout << querySegTree(1, 0, n - 1, a-1, b-1).max_sum << endl;
    }
    return 0;
}