/*input
2
5
1
*/
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
#define sz 5000001
 
typedef long long int ll;
typedef long double ld;
 
//Created by Shreyans Sheth [bholagabbar]
 
bool v[sz];
ll len, lowest_prime[sz];

void Sieve()
{
	lowest_prime[1]=1;
	for (ll i = 2; i < sz; i += 2)	
		lowest_prime[i] = 2;
	for (ll i = 3; i < sz; i += 2)
		if (!v[i])
		{
			lowest_prime[i] = i;
			for (ll j = i; (j*i) < sz; j += 2)
			{
				ll x=i*j;
				if (!v[x])
					v[x]=true, lowest_prime[x]=i;
			}
		}
}
 
int main()
{
	Sieve();
	int n,tc;
	scanf("%d",&tc);
	while(tc--)
	{
		scanf("%d",&n);
		int flag=0;
		while(n!=lowest_prime[n])
		{
			if(lowest_prime[n]%4==1)
			{
				flag=1;
				break;
			}
			n/=lowest_prime[n];
		}
		if(n!=1 && n%4==1)
			flag=1;
		if(flag==1)
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}