/*input
3
1
14
45
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define MOD 1000000007

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin
//Mind=Blown

int u[100005];//parent
int r[100005];//rank

void init(int n)
{
	for(int i=1;i<=n;i++)
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
	int px=FIND(x),py=FIND(y);
	if(px==py) 
		return false;
	
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
		int n;
		cin>>n;
		if(n==1)
		{
			cout<<"26"<<endl;
			continue;
		}
		init(n);
		int cnt=0;
		int x=(n/2);
		int y=-1;
		for(int i=1;i<=n;i++)
		{
			if(i%2==1)
			{
				UNION(i,i+x);
				x--;
			}
			else
			{
				UNION(i,i+y);
				y--;
			}
		}
		unordered_set <int> s;
		for(int i=1;i<=n;i++)
		{
			s.insert(FIND(u[i]));
		}
		cnt+=s.size();
		long long pro=1;
		for(int i=1;i<=cnt;i++)
		{
			pro=((pro%MOD)*(26))%MOD;
		}
		cout<<(pro%MOD)<<endl;
	}
	return 0;
}