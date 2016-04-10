/*input
2
5 5
^^^^^
^^^^^
^^^^#
^^^^^
^^^^^
5 7
^^#^^^^
^^#^#^#
#^^^^^^
^^#^^#^
^^^^^^^
*/
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
	int tc,n,r,c;
	cin>>tc;
	while(tc--)
	{
		cin>>r>>c;
		char a[r][c];
		string s;
		for(int i=0;i<r;i++)
		{
			cin>>s;
			for(int j=0;j<c;j++)
				a[i][j]=s[j];
		}
		int cnt=0;
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)
				if(a[i][j]=='^')
				{
					int l=0,ri=0,t=0,b=0;
					for(int i1=j-1;i1>=0;i1--){
						if(a[i][i1]=='^')
							l++;
						else
							break;
					}
					for(int i1=j+1;i1<c;i1++){
						if(a[i][i1]=='^')
							ri++;
						else
							break;
					}
					for(int j1=i-1;j1>=0;j1--){
						if(a[j1][j]=='^')
							t++;
						else
							break;
					}
					for(int j1=i+1;j1<r;j1++){
						if(a[j1][j]=='^')
							b++;
						else
							break;
					}
					if(i==2 && j==3)
						cout<<min(l,min(ri,min(t,b)))<<endl;
					if(min(l,min(ri,min(t,b)))>=2)
						cnt++;
				}
		cout<<cnt<<endl;
	}
	return 0;
}