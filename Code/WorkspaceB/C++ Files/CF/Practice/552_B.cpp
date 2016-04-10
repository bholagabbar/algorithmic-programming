/*input
1000000000
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar]

int main()
{
	ios_base::sync_with_stdio(false);
    //freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
 	long long n;
 	long long ans=0;
 	cin>>n;
 	long long len=0;
 	long long n1=n;
 	while(n1>0)
 	{
 		n1/=10;
 		len++;
 	}
 	if(len==1)
 		ans=n;
 	else
 	{
 		for(long long i=0;i<len-1;i++)
 		{
 			ans+=9*ceil(pow(10,i))*(i+1);
 		}
 		n-=ceil(pow(10,len-1))-1;
 		ans+=len*(n);
 	}
 	cout<<ans;
	return 0;
}