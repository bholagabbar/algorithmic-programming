#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define endl '\n'

typedef long long int ll;

//Created by Shreyans Sheth [bholagabbar]

int main()
{
	BoostIO;
	//ReadFile;
	int n,x,y;
	cin>>n>>x;
	string s;
	cin>>s;
	int a[n+1][10]={0};
	for(int i=1;i<=n;i++)
	{
		y=s[i-1]-48;
		a[i][y]++;
		for(int j=0;j<10;j++)
			a[i][j]+=a[i-1][j];
	}
	while(x--)
	{
		cin>>y;
		ll sum=0;
		int x1=s[y-1]-48;
		for(int i=0;i<10;i++)
			sum+=(ll)a[y][i]*(ll)abs(x1-i);
		cout<<sum<<endl;
	}
	return 0;
}