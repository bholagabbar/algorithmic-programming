/*input
7
2 3 6 7 8 9 20
*/
#include <bits/stdc++.h>
using namespace std;
#define sz 100005

int segtree[sz<<2];
int lazy[sz<<2];
int a[sz];

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
	segtree[pos]=max(segtree[pos<<1],segtree[(pos<<1)+1]);
}

int rangeMaxQuery(int pos, int lo, int hi, int start, int end)
{
	if(lazy[pos]!=0)
	{
		segtree[pos]+=lazy[pos];
		if(lo!=hi)
		{
			lazy[(pos<<1)]+=lazy[pos];
			lazy[(pos<<1)+1]+=lazy[pos];
		}
		lazy[pos]=0;
	}
	if(lo>hi || start>hi || end<lo)
		return -INT_MAX;
	if(lo>=start && hi<=end)
		return segtree[pos];
	return max(rangeMaxQuery((pos<<1),lo,(lo+hi)>>1,start,end),rangeMaxQuery((pos<<1)+1,1+((lo+hi)>>1),hi,start,end));
}

void updateSegTree(int pos, int lo, int hi, int start, int end, int val)
{
	if(lazy[pos]!=0)
	{
		segtree[pos]+=lazy[pos];
		if(lo!=hi)
		{
			lazy[(pos<<1)+1]=lazy[pos];
			lazy[(pos<<1)+1]=lazy[pos];
		}
		lazy[pos]=0;
	}
	if(lo>hi || start>hi || end<lo)
		return;
	if(lo>=start && hi<=end)
	{
		segtree[pos]+=val;
		if(lo!=hi)
		{
			segtree[(pos<<1)+1]=val;
			segtree[(pos<<1)]=val;
		}
		return;
	}
	updateSegTree((pos<<1),lo,(lo+hi)>>1,start,end,val);
	updateSegTree((pos<<1)+1,1+((lo+hi)>>1),hi,start,end,val);
	segtree[pos]=max(segtree[(pos<<1)],segtree[(pos<<1)+1]);
}

int main()
{
	int n;
	cin>>n;
	for(int i=0;i<n;i++)
		cin>>a[i];
	buildSegTree(1,0,n-1);
	cout<<rangeMaxQuery(1,0,n-1,1,4)<<endl;
	cout<<rangeMaxQuery(1,0,n-1,2,5)<<endl;
	updateSegTree(1,0,n-1,2,5,10);
	cout<<rangeMaxQuery(1,0,n-1,2,5)<<endl;
	return 0;
}