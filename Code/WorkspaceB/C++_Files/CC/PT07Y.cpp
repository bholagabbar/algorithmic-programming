/*input
10 8 
7 9 
9 1 
5 1 
3 5 
5 6 
10 4 
10 8 
3 7 
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

int u[100000];

void init(int n)
{
	for(int i=0;i<=n;i++)
	{
		u[i]=i;
	}
}


int FIND(int x)
{
	if(u[x]!=u[u[x]])
	{
		u[x]=FIND(u[x]);
	}
	return u[x];
}

bool UNION(int x, int y)
{
	int px=FIND(x);
	int py=FIND(y);

	if(px==py)
		return false;

	u[px]=py;
	return true;
}


//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int n,m,a,b;
	cin>>n>>m;
	init(n);
	int flag=1;
	for(int i=0;i<m;i++)
	{
		cin>>a>>b;
		if(flag==1)
		{
			if(!UNION(a,b))
			{
				flag=0;
			}
		}
	}
	if(flag==0)
	{
		cout<<"NO\n";
	}
	else
	{
		cout<<"YES\n";
	}
	return 0;
}