/*input
4 4 6
2 2
3 2 
3 2 
4 3
4 4
4 3
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
		int n,m;
		cin>>n>>m;
		char a[n][m];
		string x;
		for(int i=0;i<n;i++)
		{
			cin>>x;
			for(int j=0;j<m;j++)
			{
				a[i][j]=x[j];
			}
		}

		int cnt=0;
		for(int k=1;k<=min(m,n);k++)
		{
			for(int i=0;i<n;i++)
			{
				if(i+k>=n)
					break;

				for(int j=0;j<m;j++)
				{
					if(j+k>=m)
						break;
					
					if(a[i][j]==a[i][j+k] && a[i][j]==a[i+k][j] && a[i][j]==a[i+k][j+k])
					{
						cnt++;
					}
				}
			}
		}
		cout<<cnt<<endl;
	}

	return 0;
}