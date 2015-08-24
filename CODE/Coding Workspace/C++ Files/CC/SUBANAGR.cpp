#include <bits/stdc++.h>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int n;
	cin>>n;
	int a[n][26];
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<26;j++)
		{
			a[i][j]=0;
		}
	}
	string x="";
	for(int i=0;i<n;i++)
	{
		cin>>x;
		for(int j=0;j<x.size();j++)
		{
			a[i][(x.at(j)-97)]++;
		}
	}	
	x="";
	for(int i=0;i<26;i++)
	{
		int flag=1;
		int cnt=INT_MAX;
		for(int j=0;j<n;j++)
		{
			if(a[j][i]==0)
			{
				flag=0;
				break;
			}
			else
			{
				if(cnt>a[j][i])
				{
					cnt=a[j][i];
				}
			}
		}
		if(flag==1)
		{
			for(int j=0;j<cnt;j++)
			{
				x+=((char)(i+97));
			}
		}
	}
	if(x!="")
	{
		cout<<x;
	}
	else
	{
		cout<<"no such string";
	}
	return 0;
}