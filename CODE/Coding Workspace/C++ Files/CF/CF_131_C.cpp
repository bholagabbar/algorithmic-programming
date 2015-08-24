#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define pb emplace_back

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin
vector <long long> C[61];
void COMBINATIONS()
{
	for(long long i=0;i<=60;i++)
	{
		for(long long j=0;j<=i;j++)
		{
			if(j==0 || j==i)
			{
				C[i].pb(1);
			}
			else
			{
				C[i].pb(C[i-1][j-1]+C[i-1][j]);
			}
		}
	}
}


int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	COMBINATIONS();
	long long n,m,t;
	cin>>n>>m>>t;
	long long ans=C[n][4]*C[m][1]*C[n+m-5][t-5];		
	cout<<ans;
	return 0;
}