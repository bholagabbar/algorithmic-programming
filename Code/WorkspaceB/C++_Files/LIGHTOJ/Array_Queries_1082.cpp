/*input
2
5 3
78 1 22 12 3
1 2
3 5
4 4
1 1
10
1 1
*/
#include <bits/stdc++.h>
using namespace std;
#define sz 100005
#define PI(x) printf("%d", x)
#define PL(x) printf("%lld", x)
#define SI(x) scanf("%d", &x)
#define SD(x) scanf("%lf", &x)
#define SL(x) scanf("%lld", &x)
 
int arr[sz];
 
int segTree[sz<<2];
int lazy[sz<<2];
 
void buildSegTree(int node, int a, int b) {
    if(a > b) {
        return;
    }
    if(a == b) {
        segTree[node] = arr[a];
        return;
    }
    buildSegTree((node << 1), a, (a + b) >> 1);
    buildSegTree((node << 1) + 1, 1+((a + b) >> 1), b);
    segTree[node] = std::min(segTree[node << 1], segTree[(node << 1) + 1]);
}
 
void updateSegTree(int node, int a, int b, int i, int j, int val) {
 
    if(lazy[node] != 0) {
        segTree[node] += lazy[node];
        if(a != b) {
            lazy[node<<1] += lazy[node];
            lazy[(node<<1)+1] += lazy[node];
        }
        lazy[node] = 0;
    }
    if(a > b || a > j || b < i) {
        return;
    }
    if(a >= i && b <= j) {
        segTree[node] += val;
        if(a != b) {
            lazy[node<<1] += val;
            lazy[(node<<1)+1] += val;
        }
        return;
    }
    updateSegTree(node << 1, a, (a + b) >> 1, i, j, val);
    updateSegTree((node << 1) + 1, 1 + ((a + b) >> 1), b, i, j, val);
    segTree[node] = std::min(segTree[node << 1], segTree[(node << 1) + 1]);
}
 
int querySegTree(int node, int a, int b, int i, int j) {
 
    if(a > b || a > j || b < i) {
        return INT_MAX;
    }
    if(lazy[node] != 0) {
        segTree[node] += lazy[node];
        if(a != b) {
            lazy[node << 1] += lazy[node];
            lazy[(node << 1) + 1] += lazy[node];
        }
        lazy[node] = 0;
    }
    if(a >= i && b <= j) {
        return segTree[node];
    }
    return std::min(querySegTree((node << 1), a, (a+b) >> 1, i, j), querySegTree((node << 1) + 1, 1 + ((a + b) >> 1), b, i, j));
}
 
int main()
{
    int notc;
    SI(notc);
    for (int t = 1; t <= notc; t++) {
        int n, q;
        SI(n), SI(q);
        for (int i = 0; i < n; i++) {
            SI(arr[i]);
        }
        buildSegTree(1, 0, n-1);
        printf("Case %d:\n", t);
        while (q--) {
            int l ,r;
            SI(l), SI(r);
            PI(querySegTree(1, 0 ,n-1, l-1 ,r-1));
            printf("\n");
        }
    }
    return 0;
}
