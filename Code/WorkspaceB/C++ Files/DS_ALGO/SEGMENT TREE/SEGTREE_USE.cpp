/*input
7
2 3 6 7 8 9 20
*/
#include <bits/stdc++.h>
using namespace std;
#define sz 100005

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
    segTree[node] = std::max(segTree[node << 1], segTree[(node << 1) + 1]);
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
    segTree[node] = std::max(segTree[node << 1], segTree[(node << 1) + 1]);
}

int querySegTree(int node, int a, int b, int i, int j) {
 
    if(a > b || a > j || b < i) {
        return INT_MIN;
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
    return std::max(querySegTree((node << 1), a, (a+b) >> 1, i, j), querySegTree((node << 1) + 1, 1 + ((a + b) >> 1), b, i, j));
}

int main()
{
	int n;
	cin>>n;
	for(int i=0;i<n;i++){
		cin>>arr[i];
    }
	buildSegTree(1,0,n-1);
	cout<<querySegTree(1,0,n-1,0,4)<<endl;
	cout<<querySegTree(1,0,n-1,2,5)<<endl;
	updateSegTree(1,0,n-1,2,5,10);
	cout<<querySegTree(1,0,n-1,2,5)<<endl;
	return 0;
}