#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define size 100005

//Created by Shreyans Sheth [bholagabbar]

typedef long long ll;

ll a[size<<1];
ll b[size<<1];
ll BIT[size<<1];

void BuildBIT(ll n)
{
	fill_n(BIT,n+1,0);
}

ll QueryBIT(ll bi,ll n)	
{
	ll sum = 0;
	while(bi>0)
	{
		sum+=BIT[bi];
		bi-= (bi & (-bi));
	}
	return sum;
}

ll UpdateBIT(ll l, ll val, ll n)
{
	while(l<=n)
	{
		BIT[l]+=val;
		l+= (l & (-l));
	}
}

ll RangeUpdateBIT(ll l, ll r, ll val,ll n)
{
	UpdateBIT(l,val,n);
	UpdateBIT(r+1,-val,n);
}

int main()
{
	ios_base::sync_with_stdio(false);
	//ReadFile;
    ll n,m,x,y;
    ll val;
    cin>>n>>m;
    for(ll i=0;i<n;i++)
        cin>>a[i];
    BuildBIT(n);
    for(ll i=0;i<m;i++)
    {
    	cin>>x>>y;
    	RangeUpdateBIT(x,y,1,n);
    }
    for(ll i=0;i<n;i++)
        b[i]=QueryBIT(i+1,n);
    sort(a,a+n);
    sort(b,b+n);
    ll sum=0;
    for(ll i=0;i<n;i++)
        sum+=a[i]*b[i];
    cout<<sum<<endl;
	return 0;
}