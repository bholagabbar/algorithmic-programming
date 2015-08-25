/*input
4
0 2 1 3
1 0 4 5
3 1 0 3
1 1 1 0
4
0 2 1
0 2 2
3 1 2
3 0 1
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int a[251][251];

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int n,m;
	cin>>n;

	//FLOYD WARSHALL

	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			cin>>a[i][j];
		}
	}

	for(int k=0;k<n;k++)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(a[i][k]+a[k][j]<a[i][j])
				{
					a[i][j]=a[i][k]+a[k][j];
				}
			}
		}
	}

	cin>>m;
	while(m--)
	{
		int s,g,d;
		cin>>s>>g>>d;

		int st=a[s][g]+a[g][d];
		
		cout<<st<<" "<<(st-a[s][d])<<endl;
	}

	return 0;
}
