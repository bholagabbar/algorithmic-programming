/*input
2
50000 50000
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int n,m;
	m=0;
	cin>>n;
	int a,x;
	cin>>x;
	a=x;
	vector<int>v;
	v.push_back(x);
	for(int i=1;i<n;i++)
	{
		cin>>x;
		m=max(m,x);
		v.push_back(x);
		if(a!=1)
		{
			a=__gcd(a,x);
		}
	}	
	if(a!=1)
	{
		a=m/a;
	}
	int cnt=0;
	for(int i=0;i<v.size();i++)
	{
		if(v[i]<a)
		{
			while(v[i]!=a)
			{
				v[i]*=2;
				cnt++;
			}
		}
		else if(v[i]>a)
		{
			while(v[i]!=a)
			{
				v[i]/=2;
				cnt++;
			}
		}
	}
	cout<<cnt<<endl;
	return 0;
}