/*input
2 1
1 1
*/
#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define CLR(s) memset(&s, 0, sizeof(s))
#define hashset unordered_set
#define hashmap unordered_map
#define pii pair<int,int>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define MOD 1000000007
#define endl '\n'

typedef long long int ll;
typedef long double ld;

ll a[1000000];

//Created by Shreyans Sheth [bholagabbar]

bool check(ll x, int n, int m)
{
	ll boxi=n-1;
	for(int i=0;i<m;i++)
	{
		ll t=x;
		t-=boxi+1;//time taken to reach
		//cout<<x<" "<<"Time curr "<<t<<endl;
		if(t<0)
			return 0;
		while(t>0)
		{
			t-=a[boxi];
		//	cout<<"Removing "
			if(t<0)
				a[boxi]-=t;
			else
				boxi--;
		}
		if(boxi==-1)
			return 1;
	}
	return 0;
}

ll BinarySearch(int n, int m)
{
	ll l=0,h=(ll)1e4;
	while(l<h)
	{
		ll mid=l+(h-l+1)/2;
		if(check(mid,n,m))
			h=mid-1;
		else
			l=mid+1;
	}
	return l;
}

int main()
{
	//ReadFile;
	BoostIO;
	int n,m;
	cin>>n>>m;
	for(int i=0;i<n;i++)
		cin>>a[i];
	cout<<BinarySearch(n,m);
	return 0;
}