#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define CLR(s) memset(&s, 0, sizeof(s))
#define hashset unordered_set
#define hashmap unordered_map
#define pii pair<int,int>
#define pll pair<long long int, long long int>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define MOD 1000000007
#define endl '\n'

typedef long long int ll;
typedef long double ld;

//Created by Shreyans Sheth [bholagabbar]

int main()
{
	//ReadFile;
	BoostIO;
	int n;
	ll d,x,y;
	cin>>n>>d;
	vector<pll> a;
	for(int i=0;i<n;i++)
	{
		cin>>x>>y;
		a.pb({x,y});
	}
	sort(a.begin(),a.end());
	ll sum[n+1]={0};
	sum[0]=0;
	for(int i=1;i<=n;i++)
		sum[i]=sum[i-1]+a[i-1].S;
	ll maxf=0;
	for(int i=0;i<n;i++)
	{
		auto it=distance(a.begin(), lower_bound(a.begin(),a.end(),mp((ll)a[i].F-d+1,(ll)-100)));
		if(it!=a.size())
			maxf=max(maxf,sum[i+1]-sum[it]);
	}
	cout<<maxf;
	return 0;
}