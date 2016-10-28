#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define pll pair<long long int,long long int>
#define CLR(s) memset(&s, 0, sizeof(s))
#define hashset unordered_set
#define hashmap unordered_map
#define pii pair<int,int>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl '\n'
#define sz 100008

typedef long long int ll;
typedef long double ld;

//Unthreaded fast IO
inline ll SCANFAST()
{
    ll num = 0;
    char c = getchar_unlocked();
    bool flag = 0;
    while(!((c>='0' & c<='9') || c == '-'))
        c=getchar_unlocked();
    if(c=='-')
    {
        flag = 1;
        c=getchar_unlocked();
    }
    while(c>='0' && c<='9')
    {
        num = (num<<1)+(num<<3)+c-'0';
        c=getchar_unlocked();
    }
    if(flag==0)
        return num;
    else
        return -1*num;
}

//Created by Shreyans Sheth [bholagabbar]

const ll INF=(ll)(1e9+5);
ll segtree[sz<<2];
ll a[sz];

void buildSegTree(int pos, int lo, int hi)
{
	if(lo>hi)
		return;
	if(lo==hi)
	{
		segtree[pos]=a[lo];
		return;
	}
	buildSegTree((pos<<1),lo,(hi+lo)>>1);
	buildSegTree((pos<<1)+1,1+((lo+hi)>>1),hi);
	segtree[pos]=min(segtree[pos<<1],segtree[(pos<<1)+1]);
}

inline ll rangeMinQuery(int pos, int lo, int hi, int start, int end)
{
	if(lo>hi || start>hi || end<lo)
		return INF;
	if(lo>=start && hi<=end)
		return segtree[pos];
	return min(rangeMinQuery((pos<<1),lo,(lo+hi)>>1,start,end),rangeMinQuery((pos<<1)+1,1+((lo+hi)>>1),hi,start,end));
}

int main()
{
	int tc;
	tc=SCANFAST();
	for(int t=1;t<=tc;t++)
	{
		int n,q,i,j;
		n=SCANFAST();
		q=SCANFAST();
		for(int i=0;i<n;i++)
			a[i]=SCANFAST();
		buildSegTree(1,0,n-1);
		printf("Scenario #%d:\n\n",t);
		while(q--)
		{
			i=SCANFAST();
			j=SCANFAST();
			printf("%lld\n\n",rangeMinQuery(1,0,n-1,i-1,j-1));
		}
	}
	return 0;
}