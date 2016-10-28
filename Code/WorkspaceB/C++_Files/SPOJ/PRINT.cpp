#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define printPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(false)
#define CLEAR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl '\n'
typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

//Shreyans Sheth [bholagabbar]

const int sz=1000001,lim=46342;
bool prime[lim+1],segment[sz];

void Sieve()
{
	fill(prime,prime+lim+1,1);
	prime[0]=prime[1]=0;
	for(int i=2;i<=sqrt(lim);i++)
		if(prime[i])
			for(int j=i*i;j<=lim;j+=i)
				prime[j]=0;
}

int main()
{
	//readFile;
	boostIO;
	Sieve();
	int tc;
	cin>>tc;
	while(tc--)
	{
		ll n,m;
		cin>>n>>m;
		fill(segment,segment+(m-n+1),1);
		for(int i=2;i<=sqrt(m);i++)
			if(prime[i])
			{
				ll start=(n/i)*i;
				if(start<n)
					start+=i;
				if(start<lim && prime[start])
					start+=i;
				start-=n;
				for(int j=start;j<=(m-n);j+=i)
					segment[j]=0;
			}
		for(int i=0;i<=(m-n);i++)
			if(segment[i])
				cout<<(n+i)<<endl;
		cout<<endl;
	}
	return 0;
}