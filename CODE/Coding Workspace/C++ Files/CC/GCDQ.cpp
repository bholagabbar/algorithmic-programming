/*input
1
3 3
2 6 9
1 1
2 2
2 3
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define size 100005

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

//fuck this shit. SegTree FTW

int st[size<<2];
int arr[size];

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
	st[pos]=__gcd(st[2*pos],st[2*pos+1]);
}

int GCDQuery(int node,int a,int b, int i,int j)
{
	if(i>b || a>b || j<a)
		return 0;

	if(i<=a && j>=b)
		return st[node];

	return __gcd(GCDQuery(2*node,a,(a+b)>>1,i,j),GCDQuery(2*node+1,1+((a+b)>>1),b,i,j));
}


int main()
{
	int tc;
	scanf("%d",&tc);
	while(tc--)
	{
		int n,m;
		scanf("%d%d",&n,&m);
		for(int i=0;i<n;i++)
		{
			scanf("%d",&arr[i]);
		}
		BuildSegTree(1,0,n-1);
		int l,r;
		for(int i=0;i<m;i++)
		{
			scanf("%d%d",&l,&r);
			l--,r--;
			int ans=__gcd(GCDQuery(1,0,n-1,0,l-1), GCDQuery(1,0,n-1,r+1,n-1));
			printf("%d\n",ans);
		}
	}
	return 0;
}