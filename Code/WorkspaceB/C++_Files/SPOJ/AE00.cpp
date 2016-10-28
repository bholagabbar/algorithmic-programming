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

const int lim=10000;
bool prime[lim+1];
int dp[lim+1]={0};

void Sieve()
{
	fill(prime,prime+lim+1,1);
	prime[0]=prime[1]=0;
	for(int i=0;i*i<=lim;i++)
		if(prime[i])
			for(int j=i*i;j<=lim;j+=i)
				prime[j]=0;
}

int main()
{
	//readFile;
	boostIO;
	Sieve();
	int n;
	cin>>n;
	for(int i=1;i<=n;i++)
	{
		for(int j=2;j*j<=i;j++)
			if(i%j==0)
				dp[i]++;
		dp[i]+=dp[i-1]+1;
	}
	cout<<dp[n];
	return 0;
}