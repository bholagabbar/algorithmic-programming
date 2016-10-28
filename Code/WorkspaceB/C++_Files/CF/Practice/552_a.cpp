#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar]

int main()
{
	ios_base::sync_with_stdio(false);
 	int a[101][101];
 	for(int i=0;i<101;i++)
 		for(int j=0;j<101;j++)
 			a[i][j]=0;
 	int n,x1,y1,x2,y2;
 	cin>>n;
 	for(int q=0;q<n;q++)
 	{
 		cin>>x1>>y1>>x2>>y2;
 		for(int i=min(x1,x2);i<=abs(x1+(x2-x1));i++)
 			for(int j=min(y1,y2);j<=abs(y1+(y2-y1));j++)
 				a[i][j]++;
 	}
 	long sum=0;
 	for(int i=1;i<=100;i++)
 		for(int j=1;j<=100;j++)
 			sum+=a[i][j];
 	cout<<sum;
	return 0;
}