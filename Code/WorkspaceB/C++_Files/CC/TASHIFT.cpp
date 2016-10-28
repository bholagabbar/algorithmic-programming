/*input
5
ccadd
bddcc
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
 
//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin
 
int z[5000000];
int main()
{
-	ios_base::sync_with_stdio(false);//FAST IO
	int n;
	string a,b;
	cin>>n>>a>>b;
	string s=a+"$"+b+b;
	n*=3;
	int ans=0,max=INT_MIN;
	for(int i=1,l=0,r=0;i<n;++i)//Z Algorithm the shiz
	{
		z[i]=0;
		if(i<=r)
			z[i]=min(r-i+1,z[i-l]);
		while(i+z[i]<n && s[z[i]]==s[i+z[i]])
			z[i]++;
		if(i+z[i]-1>r)
			r=i+z[i]-1,l=i;
		if(i>a.size() && z[i]>max)
			max=z[i],ans=i-a.size()-1;
	}
	cout<<ans;
	return 0;
} 