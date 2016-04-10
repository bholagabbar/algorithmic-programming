/*input
10
*/
#include <iostream>
#include <cmath>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define pll pair<long long int,long long int>
#define CLR(s) memset(&s, 0, sizeof(s))
#define hashset unordered_set //JAVA feels :')
#define hashmap unordered_map
#define pii pair<int,int>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl '\n'
#define sz 1000001

typedef long long int ll;
typedef long double ld;

//Created by Shreyans Sheth [bholagabbar]

bool prime[sz];

void Sieve()
{
	for(int i=0;i<sz;i++)
		prime[i]=1;
	prime[0]=prime[1]=0;
	for(int i=2;i<=sqrt(sz-1);i++)
		if(prime[i])
			for(int j=i*i;j<sz;j+=i)
				prime[j]=0;
}

int main()
{
	//ReadFile;
	BoostIO;
	Sieve();
	ll n;
	cin>>n;
	ll max=n;
	for(ll i=2;i<=sqrt(n);i++)
		if(prime[i] && n%i==0)
		{
			ll sq=i*i;
			while(max%sq==0)
				max/=i;
		}
	cout<<max;
	return 0;
}