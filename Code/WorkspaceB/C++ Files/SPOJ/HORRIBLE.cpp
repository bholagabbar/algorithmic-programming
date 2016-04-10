/*input
1
8 6
0 2 4 26
0 4 8 80
0 4 5 20
1 8 8
0 5 7 14
1 4 8
*/
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
#define sz 100005
 
typedef long long int ll;
typedef long double ld;
 
//Created by Shreyans Sheth [bholagabbar]
 
ll BIT1[sz], BIT2[sz];
 
ll QueryBIT(ll* bit, int k)
{
	ll sum=0;
	int index=k;
	while(index>0)
	{
		sum+=bit[index];
		index-=(index&(-index));
	}
	return sum;
}
 
ll rangeQueryBIT(int i, int j)
{
    ll a1=QueryBIT(BIT1,--i)*i - QueryBIT(BIT2,i);
    ll a2=QueryBIT(BIT1,j)*j - QueryBIT(BIT2,j);
    return a2-a1;
}
 
void UpdateBIT(ll* bit, int k, ll val, int n) 
{
	int index=k;
	while(index<=n)
	{
		bit[index]+=val;
		index+=(index &(-index));
	}
}
 
void rangeUpdateBIT(int i, int j, ll v, int n)
{
	UpdateBIT(BIT1, i, v, n);
	UpdateBIT(BIT1, j+1, -v, n);
	UpdateBIT(BIT2, i, v*(i-1), n);
	UpdateBIT(BIT2, j+1, -v*j, n);
}
 
int main()
{
	BoostIO;
	int tc,n,c,p,q,query;
	ll val;
	cin>>tc;
	while(tc--)
	{
		cin>>n>>c;
		CLR(BIT1);
		CLR(BIT2);
		while (c--)
		{
			cin>>query>>p>>q;//1 based queries. Hence no index+1 in BIT
			if(query)
				cout<<rangeQueryBIT(p,q)<<endl;
			else
			{
				cin>>val;
				rangeUpdateBIT(p,q,val,n);
			}
		}
	}
    return 0;
} 

/* Using Segment Tree with Lazy Propogation

#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define size 100005
 
//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin
 
long long st[size<<2];
long long lazy[size<<2];
 
void Initialize(long n)
{
	for(long i=0;i<=4*n;i++)
	{
		st[i]=lazy[i]=0;
	}
}
 
long long RMAXQ(int node, int a, int b, int i, int j)
{
	if(a>b||a>j||b<i)
		return 0;
 
	if (lazy[node] !=0 )
	{
		st[node]+=lazy[node]*(b-a+1);
		if (a!=b)
		{
			lazy[2*node]+=lazy[node];
			lazy[2*node+1]+=lazy[node];
		}
		lazy[node]=0;
	}
	
	if (a>=i && b<=j)
		return st[node];
	
	return RMAXQ(2*node, a, (a+b)/2, i, j)+ RMAXQ(2*node+1, (a+b)/2+1, b, i, j);
}
 
void UpdateSegTree(int node, int a, int b, int i, int j, long long value)
{
	if(a>b)
		return;
	
	if (lazy[node]!=0)
	{
		st[node]+=lazy[node]*(b-a+1);
		if (a!=b)
		{
			lazy[2*node]+=lazy[node];
			lazy[2*node+1]+=lazy[node];
		}
		lazy[node]=0;
	}
	
	if(a>b||a>j||b<i)
		return;
	
	if (a>=i && b<=j)
	{
		st[node]+=value*(b-a+1);
		if (a!=b)
		{
			lazy[2*node]+=value;
			lazy[2*node+1]+=value;
		}
		return;
	}
	
	UpdateSegTree(2*node, a, (a+b)/2, i, j, value);
	UpdateSegTree(2*node+1, (a+b)/2+1, b,i, j, value);
	st[node] = st[2*node] + st[2*node+1];
}
 
int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int tc;
	cin>>tc;
	while(tc--)
	{
		int n,c,q,a,b;
		long long val;
		cin>>n>>c;
		Initialize(n);
		while(c--)
		{
			cin>>q;
			if(q==1)
			{
				cin>>a>>b;
				cout<<RMAXQ(1,1,n,a,b)<<endl;
			}
			else
			{
				cin>>a>>b>>val;
				UpdateSegTree(1,1,n,a,b,val);
			}
		}
	}
 
	return 0;
} 

*/