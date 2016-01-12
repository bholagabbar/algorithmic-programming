#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0),cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define sz 100005
#define F first
#define S second
#define endl '\n'

typedef long long ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

//Shreyans Sheth [bholagabbar]

int segtree[sz<<2];
int lazy[sz<<2];
int arr[sz];

void buildSegTree(int node, int a, int b)
{
    if(a > b) return;
    if(a == b)
    {
        segtree[node] = arr[a];
        return;
    }
    buildSegTree((node<<1),a,(b+a)>>1);
    buildSegTree((node<<1)+1,1+((a+b)>>1),b);
    segtree[node]=min(segtree[node<<1],segtree[(node<<1)+1]);
}

void updateSegTree(int node, int a, int b, int i, int j, int val)
{
 
    if(lazy[node] != 0)
    {
        segtree[node]+=lazy[node];
        if(a != b)
        {
            lazy[node<<1]+=lazy[node];
            lazy[(node<<1)+1]+=lazy[node];
        }
        lazy[node] = 0;
    }
    if(a > b || a > j || b < i)
        return;
    if(a >= i && b <= j)
    {
        segtree[node]+=val;
        if(a != b)
        {
            lazy[node<<1]+=val;
            lazy[(node<<1)+1]+=val;
        }
        return;
    }
    updateSegTree((node<<1),a,(a+b)>>1,i,j,val);
    updateSegTree((node<<1)+1,1+((a+b)>>1),b,i,j,val);
    segtree[node]=min(segtree[(node<<1)],segtree[(node<<1)+1]);
}

int rangeMinQuery(int node, int a, int b, int i, int j)
{
 
    if(a > b || a > j || b < i)
    	return INT_MAX;
    if(lazy[node] != 0)
    {
        segtree[node]+=lazy[node];
        if(a != b)
        {
            lazy[node<<1]+=lazy[node];
            lazy[(node<<1)+1]+=lazy[node];
        }
        lazy[node] = 0;
    }
    if(a >= i && b <= j)
        return segtree[node];
    return min(rangeMinQuery((node<<1),a,(a+b)>>1,i,j), rangeMinQuery((node<<1)+1,1+((a+b)>>1),b,i,j));
}
 
 
int main()
{
    boostIO;
    string s;
    cin>>s;
    int n=s.size();
    int cnt=0;
    for(int i=0;i<n;i++)
    {
    	s[i]=='(' ? cnt++:cnt--;
    	arr[i]=cnt;
    }
    buildSegTree(1,0,n-1);
    int q;
    cin>>q;
    while(q--)
    {
    	int l,r;
    	cin>>l>>r;
    	if(s[l]!=s[r])
    		s[l]=='(' ? updateSegTree(1,0,n-1,l,r-1,-2):updateSegTree(1,0,n-1,l,r-1,2);
    	swap(s[l],s[r]);
    	int val=rangeMinQuery(1,0,n-1,0,n-1);
    	if(val>=0)
    		cout<<"Yes\n";
    	else
    		cout<<"No\n";
    }
    return 0;
}