#include <bits/stdc++.h>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(false);cin.tie(NULL);
	int v;
	cin>>v;
	bitset<2001>gr[v];
	string x;
	for(int i=0;i<v;i++)
	{
		cin>>x;
		for(int j=0;j<v;j++)
		{
			if(x[j]=='1')
			{
				gr[i].set(j);
			}
		}
	}
	int cnt=0;
	for(int i=0;i<v;i++)
	{
		for(int j=i+1;j<v;j++)
		{
			if(!gr[i].test(j))
			{
				if((gr[i]&gr[j]).any()>0)
				{
					cnt+=2;
				}
			}
		}
	}
	cout<<cnt;
	return 0;
}