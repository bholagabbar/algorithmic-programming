//UPDATEIT SPOJ

/*input
1
5 3
0 1 7
2 4 6
1 3 2
3
0
3
4
*/
//Range update and point queries in BIT
#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define pll pair<long long int,long long int>
#define CLR(s) memset(&s, 0, sizeof(s))
#define hashset unordered_set
#define hashmap unordered_map
#define pii pair<int,int>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl '\n'
#define sz 10005

typedef long long int ll;
typedef long double ld;

//Created by Shreyans Sheth [bholagabbar]

ll bit[sz];

void UpdateBIT(int r, ll val, int n)
{
	int index=r+1;
	while(index<=n)
	{
		bit[index]+=val;
		index+=(index&(-index));
	}
}

void rangeUpdateBIT(int p, int q, ll val, int n)
{
	UpdateBIT(p,val,n);
	UpdateBIT(q+1,-val,n);
}

ll QueryBIT(int r)
{
	ll ans=0;
	int index=r+1;
	while(index>0)
	{
		ans+=bit[index];
		index-=(index&(-index));
	}
	return ans;
}

int main()
{
	BoostIO;
	int t,n,u,l,r,q;
	ll val;
	cin>>t;
	while(t--)
	{
		cin>>n>>u;
		CLR(bit);
		for(int i=0;i<u;i++)
		{
			cin>>l>>r>>val;
			rangeUpdateBIT(l,r,val,n);
		}
		cin>>q;
		while(q--)
		{
			cin>>r;
			cout<<QueryBIT(r)<<endl;
		}
	}
	return 0;
}
