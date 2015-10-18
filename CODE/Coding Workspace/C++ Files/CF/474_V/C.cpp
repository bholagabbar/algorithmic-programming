/*input
5 2
1 1
1 3
2 3
4 4
4 5
*/
#include <iostream>
#define endl '\n'
using namespace std;

typedef long long int ll;
const ll MOD=1000000007;

ll prefix[100005];

ll Calc(ll n,ll k,ll p)
{
	//ll ans=(n*p)-((p*(p+1)/2))*k+p+1;
	//cout<<ans<<endl;
	ll ans=((n*p)%MOD - ((p*(p+1)/2)%MOD * k)%MOD + p + 1)%MOD;
	return ans;
}

void Pre(ll k)
{
	prefix[0]=0;
	for(int i=1;i<=100005;i++)
		prefix[i]=(prefix[i-1]+Calc(i,k,(ll)((ll)i/k)))%MOD;
}

int main()
{
	ios_base::sync_with_stdio(false);
	ll t,k,a,b;
	cin>>t>>k;
	Pre(k);
	while(t--)
	{
		cin>>a>>b;
		cout<<(prefix[b]-prefix[a-1])%MOD<<endl;
	}
}
	//n*p-(p*(p+1)/2)*k+(p+1);
