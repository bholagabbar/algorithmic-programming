#include <bits/stdc++.h>
using namespace std;

#define endl '\n'
#define pb emplace_back
#define f first
#define s second
#define mp make_pair

typedef long long int ll;

//Created by Shreyans Sheth [bholagabbar]

ll C[2001][2001];

void COMBINATIONS()
{
	for(int i=0;i<=2000;i++)
		for(int j=0;j<=i;j++)
		{
			if(j==0 || j==i)
				C[i][j]=1;
			else
				C[i][j]=C[i-1][j-1]+C[i-1][j];
		}
}

int main()
{
	ios_base::sync_with_stdio(false);
    //freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
 	int n,x,y;
 	cin>>n;
 	pair<int,int> a[n];
 	for(int i=0;i<n;i++)
 	{
 		cin>>x>>y;
 		a[i]={x,y};
 		//cout<<a[i].f<<" "<<a[i].s<<endl;
 	}
 	long cnt=0;
 	COMBINATIONS();
 	for(int i=0;i<n;i++)
 	{
 		int x1=a[i].f,y1=a[i].s;//first coords
 		for(int j=i+1;j<n;j++)
 		{
 			int x2=a[j].f,y2=a[j].s;//second coords
 			for(int k=j+1;k<n;k++)
 			{
 				int x3=a[k].f,y3=a[k].s;//third coords
 				if((y2-y1)*(x3-x2)==(y3-y2)*(x2-x1))//Collinear points
 					cnt+=1;
 			}
 		}
 	}
 	ll ans=C[n][3]-cnt;//Nc3 - Collinear points C 3
 	cout<<ans;
	return 0;
}