/*
input
3
4 2
1 2
2 3
5 3
1 2
2 3
1 3
6 3
1 2
3 4
5 6
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define MOD 1000000007

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int u[100001];
int r[100001];
int cal[100001];

inline void ur_init(int n)
{
	for(int i=1;i<=n;i++)
	{
		u[i]=i;
		r[i]=1;
		cal[i]=0;
	}
}

inline int FIND(int x)
{
	if(u[x]!=u[u[x]])
	{
		u[x]=FIND(u[x]);
	}
	return u[x];	
}

inline bool UNION(int x,int y)
{
	int px=FIND(x),py=FIND(y);
	if(px==py) return false;

	if(r[px]>r[py])
		swap(px,py);
	else if(r[px]==r[py]) 
		r[py]++;

	u[px]=py;
	return true;
}

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int tc;
	cin>>tc;
	while(tc--)
	{
		int n,m;
		cin>>n>>m;
		ur_init(n);
		for(int i=0;i<m;i++)
		{
			int a,b;
			cin>>a>>b;
			UNION(a,b);
		}
		for(int i=1;i<=n;i++)
		{
			cal[FIND(i)]++; //p[i] will not always be the parent of the disjoint set
		}

		long long nw=1,ng=0;
		for(int i=1;i<=n;i++)
		{
			if(cal[i]>0)
			{
				ng++;
				nw=((nw%MOD)*(cal[i]%MOD))%MOD;	
			}
		}
		cout<<ng<<" "<<nw<<endl;
	}
	return 0;
}