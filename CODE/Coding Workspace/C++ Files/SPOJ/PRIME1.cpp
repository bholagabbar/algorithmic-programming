/*input
1
1 10
*/
#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define boostIO ios_base::sync_with_stdio(false)
#define ld long double
#define ll long long int
#define CLEAR(s) memset(&(s), 0, sizeof(s))
#define scani(s) scanf("%d",&s)
#define scanl(s) scanf("%lld",&s)
#define hashset unordered_set //JAVA feels :')
#define hashmap unordered_map
#define pll pair<int,int>
#define pii pair<int,int>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl '\n'
#define sz 100005

bool prime[sz];
bool segment[sz];

void Sieve()
{
	fill(prime,prime+sz,1);
	prime[0]=prime[1]=0;
	for(int i=2;i<=sqrt(sz);i++)
		if(prime[i])
			for(int j=i*i;j<sz;j+=i)
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
		memset(segment,1,sizeof segment);
		for(int i=2;i<=sqrt(m);i++)
		{
			if(prime[i])
			{
				ll start=(n/i)*i;
				if(start<n)
					start+=i;
				if(start<sz && prime[start])
					start+=i;
				start-=n;
				for(int j=start;j<=(m-n);j+=i)
					segment[j]=0;
			}
		}
		for(int i=0;i<=(m-n);i++)
			if(segment[i] && n+i!=1)
				cout<<(n+i)<<endl;
		cout<<endl;
	}
	return 0;
}