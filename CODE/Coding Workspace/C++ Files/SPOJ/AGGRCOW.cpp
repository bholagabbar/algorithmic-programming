#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar]

vector <long long int> a;
long long c;


int check(int x)
{
	int cowsplaced=1;
	long long int lastpos=a[0];
	for(int i=1;i<a.size();i++){
		if(a[i]-lastpos>=x)
		{
			cowsplaced++;
			
			if(cowsplaced==c)
			  return 1;

            lastpos=a[i];
		  }
	  }
	return 0;
}

long long BinarySearch()
{
	long long int lo=0, hi=a[a.size()-1];
	long long int n=a.size();
	int cnt=0;
	while(lo<hi)
	{
		long long int x=lo+ (hi-lo+1)/2; //May become buggy!!
		if(check(x)==1)
		{
			lo=x;
		}
		else
		{
			hi=x-1;
		}
		cnt++;
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
 		long long int n,x;
 		cin>>n>>c;
 		a.clear();
 		for(long long i=0;i<n;i++)
 		{
 			cin>>x;
 			a.push_back(x);
 		}
 		sort(a.begin(),a.end());
 		cout<<BinarySearch()<<endl;
 	}   
	return 0;
}