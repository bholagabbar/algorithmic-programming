

#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define sz 100001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;


bool prime[sz];

void Sieve()
{
	prime[0]=prime[1]=0;
	for(ll i=2;i<=sz;i++)
		prime[i]=1;
	for(ll i=2; i*i <=sz; i++)
		if(prime[i])
			for(ll j=i*i; j<size; j+=i)
				prime[j]=0;
}


int main()
{
	boostIO;
	
	
	return 0;
}