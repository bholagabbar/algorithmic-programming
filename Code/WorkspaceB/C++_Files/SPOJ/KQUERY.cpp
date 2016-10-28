#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

long segtree[30001<<2]={0};
int arr[30001]={0};
int k;

void build(int node, int a, int b)
{
	if(a>b) return;

	if(a==b)
	{
		if(arr[a]>k)
		{
			segtree[node]++;
		}
		return;
	}
	int mid=(a+b)/2;

	build(2*pos, a,mid);
	build(2*pos+1, mid+1, b);

	segtree[node]=(segtree[2*pos] + segtree[2*pos+1]);
}

int RSUMQ(int node, int a, int b, int i, int j)
{
	if(lazy[node]!=0)
	{
		st[node]+=lazy[node];

		if(a!=b)
		{
			
			lazy[2*node]+=lazy[node];
			lazy[2*node +1]+=lazy[node];
		}

		lazy[node]=0;
	}

	if(i>b || j<a || a>b)
		return 0;

	if(a>=i && b<=j)
		return st[node];//returning value at node

	return RSUMQ(2*node ,a, (a+b)/2 ,i ,j) + RSUMQ(2*node+1, 1+ (a+b)/2, b, i, j);
}

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int n,k,x,y,;
	cin>>n;
	for(int i=0;i<n;i++)
	{
		cin>>a[i];
	}	
	int k;
	cin>>k;
	while(k--)
	{

	}

	return 0;
}