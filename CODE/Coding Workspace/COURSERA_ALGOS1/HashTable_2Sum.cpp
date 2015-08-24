#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define endl '\n'

typedef long long int ll;

//Created by Shreyans Sheth [bholagabbar]

int main()
{
	ios_base::sync_with_stdio(false);
    ReadFile;
 	unordered_set<ll> s;
 	unordered_set<ll>::iterator it;
 	ll x;
 	vector<ll> a;
 	for(long i=0;i<1000000;i++)
 	{
 		cin>>x;
 		it=s.find(i);
 		if(it==s.end())
 		{
 			a.emplace_back(x);
 			s.insert(i);
 		}
 		//s.insert(i);
 	}
 	cout<<s.size()<<endl;
 	s.clear();
 	for(int i=0;i<a.size();i++)
 		for(int j=i+1;j<a.size();j++)
 			if(a[i]+a[j]>=-10000 and a[i]+a[j]<=10000)
 				s.insert(a[i]+a[j]);
    cout<<s.size();
	return 0;
}