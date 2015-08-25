 /*input
5 3
1000 1002 1003 1004 1005
S 0 2
G 0 3
S 0 2
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define size 1000005

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

long long st[size<<2];//Segment Tree
int lazy [size<<2]={0};//Lazy Array
int arr[size];//Input Array

void BuildSegTree(int pos, int a, int b)
{
	if(a>b)
		return;
	if(a==b)
	{
		st[pos]=arr[a];
		return;
	}

	BuildSegTree(2*pos,a,(a+b)>>1);
	BuildSegTree(2*pos+1,1+((a+b)>>1), b);
	st[pos]=st[2*pos]+st[2*pos+1];
}

void LazyUpdate(int node, int a,int b,int i,int j,int value)
{
	if(lazy[node]!=0)
	{
		st[node]+=lazy[node];
		if(a!=b)
		{
			st[2*node]+=lazy[node];
			st[2*node+1]+=lazy[node];
		}
		lazy[node]=0;
	}

	if(i>b || a>b || j<a)
		return;

	if(a>=i && b<=j)
	{
		st[node]+=value;
		if(a!=b)
		{
			lazy[2*node]+=value;
			lazy[2*node +1]+=value;
		}
		return;
	}

	LazyUpdate(2*node,a,(a+b)>>1,i,j,value);
	LazyUpdate(2*node+1 ,1+((a+b)>>1),b, i,j,value);
	st[node]=st[2*node]+st[2*node+1];
}

long long SumQuery(int node, int a,int b, int i,int j)
{
	if(lazy[node]!=0)
	{
		st[node]+=lazy[node];
		if(a!=b)
		{
			st[2*node]+=lazy[node];
			st[2*node+1]+=lazy[node];
		}
		lazy[node]=0;
	}

	if(i>b || a>b || j<a)
		return 0;

	if(i<=a && j>=b)
		return st[node];

	return (SumQuery(2*node,a,(a+b)>>1,i,j) + SumQuery(2*node+1,1+((a+b)>>1),b,i,j));
}

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int n,m;
	cin>>n>>m;
	for(int i=0;i<n;i++)
	{
		cin>>arr[i];
	}		
	BuildSegTree(1,0,n-1);
	char act;
	int a,b;
	for(int i=0;i<m;i++)
	{
		cin>>act;
		if(act=='S')
		{
			cin>>a>>b;
			cout<<SumQuery(1,0,n-1,a,b)<<endl;
		}
		else if(act=='G')
		{
			cin>>a>>b;
			LazyUpdate(1,0,n-1,a,a,b);
		}
		else if(act=='T')
		{
			cin>>a>>b;
			LazyUpdate(1,0,n-1,a,a,-b);
		}
	}
	return 0;
}