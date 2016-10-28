#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int n;
	cin>>n;
	int a[n];
	int pos[n][n];
	for(int i=0;i<n;i++)
	{
		cin>>a[i];
	}
	int x;
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			cin>>x;
			if(x==1)
				pos[i][j]=true;
			else
				pos[i][j]=false;
		}
	}
	for(int i=0;i<n;i++)
	{
		for(int j=i+1;j<n;j++)
		{
			if()
		}
	}


	return 0;
}