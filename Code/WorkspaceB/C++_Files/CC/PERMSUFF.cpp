/*input
2
7 4
3 1 2 4 5 7 6
1 2
4 4
6 7
2 3
4 2
2 1 3 4
2 4
2 3
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int tc;
	cin>>tc;
	while(tc--)
	{
		int n,m,x,y,flag=1;
		cin>>n>>m;
		int s[n];
		int a[n];
		for(int i=1;i<=n;i++)
		{
			s[i-1]=i;
		}
		for(int i=0;i<n;i++)
		{
			cin>>a[i];
		}
		for(int i=0;i<m;i++)
		{
			cin>>x>>y;
			sort(a+x-1,a+y);
		}
		for(int i=0;i<n;i++)
		{
			if(a[i]!=s[i])
			{
				flag=0;
				break;
			}
		}
		if(flag==1)
		{
			cout<<"Possible\n";
		}
		else
		{
			cout<<"Impossible\n";
		}
	}	

	return 0;
}