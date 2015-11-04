/*input
100 10 20
*/

//TEST

#include <bits/stdc++.h>
using namespace std;

#define ll unsigned long long
#define PII pair<ll, ll>
#define f first
#define s second
#define F(i,a,b) for(ll i = (ll)(a); i <= (ll)(b); i++)
#define RF(i,a,b) for(ll i = (ll)(a); i >= (ll)(b); i--)

ll t, w, b, lcm,  tmp, ans, t1, gc;
ll gcd(ll a, ll b)
{
	if (a%b==0)
		return b;
	else
		return gcd(b,a%b);
}

/*
if( a / gc > t /(long double) b  )
{
	ans = min(a,t+1) ;
}
else 
{
	lcm = a / gc * b ;
	times = t  / lcm ;
	ans = times * a;
	ans += min(a,t-times*lcm+1);
}
*/

int main() 
{
    ios_base::sync_with_stdio(false);cin.tie(0);
	cin>>t>>w>>b;
	gc=gcd(w, b);
	if(w==b)
	{
		cout<<"1/1";
		return 0;
	}
	if( w / gc > t /(long double) b  )
		ans = min(w-1, min(t, b-1));
	else 
	{
		lcm=w/gc*b;
		tmp=min(w,b);
		ans+=min(tmp-1,t);
		ans+=t/lcm*tmp;
		t1=t/lcm*lcm+tmp-1;
		if(t<t1 && t/lcm)
		{
			cout<<"Ya\n";
			cout<<ans<<endl;
			ans-=(t1-t);
			cout<<ans<<endl;
		}
	}
	//cout<<t1<<endl;
	tmp=gcd(ans,t);
	cout<<ans/tmp<<"/"<<t/tmp<<endl;
    return 0;
}