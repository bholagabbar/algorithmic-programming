#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define ll long long int

//Created by Shreyans Sheth [bholagabbar]

vector <ll> a;
ll c;

int check(int x)
{
	int cowsplaced=1;
	ll lastpos=a[0];
	for(int i=1;i<a.size();i++)
		if(a[i]-lastpos>=x)
		{
			cowsplaced++;	
			if(cowsplaced==c)
				return 1;
            lastpos=a[i];
		}
	return 0;
}

ll BinarySearch()
{
	ll lo=0, hi=(ll)1e9;
	ll n=a.size();
	while(lo<hi)
	{
		ll x=lo+ (hi-lo+1)/2; //May become buggy!!
		if(check(x)==1)
			lo=x;
		else
			hi=x-1;
	}
	return lo;
}

int main()
{
	ios_base::sync_with_stdio(false);
    //freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
 	int t;
 	cin>>t;
 	while(t--)
 	{
 		int n;
 		ll x;
 		cin>>n>>c;
 		a.clear();
 		for(int i=0;i<n;i++)
 		{
 			cin>>x;
 			a.push_back(x);
 		}
 		sort(a.begin(),a.end());
 		cout<<BinarySearch()<<endl;
 	}   
	return 0;
}