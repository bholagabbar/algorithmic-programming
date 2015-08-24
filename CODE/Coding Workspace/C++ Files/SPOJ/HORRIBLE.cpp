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