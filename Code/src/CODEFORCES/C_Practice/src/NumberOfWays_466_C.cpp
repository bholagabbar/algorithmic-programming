//Shreyans Sheth [bholagabbar]

#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set	//JAVA Feels :')
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define sz 500001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

ll a[sz], BIT[sz]={0};

ll QueryBIT(int b, int N)
{
	ll sum = 0;
	b+=1;
	while(b>0)
	{
		sum+=BIT[b];
		b-= (b & (-b));
	}
	return sum;
}

void UpdateBIT(int k, ll v, int N)
{
	k+=1;
	while(k<=N)
	{
		BIT[k] += v;
		k+=(k & (-k));
	}
}

int main()
{
	boostIO;
	int n;
	cin>>n;
	cin>>a[0];
	for(int i=1;i<n;i++)
	{
		cin>>a[i];
		a[i]+=a[i-1];
	}
	ll last=a[n-1];
	if(last%3!=0)
	{
		cout<<"0";
		return 0;
	}
	vector<int> fi;
	for(int i=0;i<n-1;i++)
	{
		if(a[i]==last/3)
			fi.pb(i);
		if(a[i]==2*(last/3))
			UpdateBIT(i,1,n-1);
	}
	ll ans=0;
	for(int i:fi)
		ans+=QueryBIT(n-2,n-1)-QueryBIT(i,n-1);
	cout<<ans;
	return 0;
}