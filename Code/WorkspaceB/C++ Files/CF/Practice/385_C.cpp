/*input
6
5 5 7 10 14 15
3
2 11
3 12
4 4
*///Shreyans Sheth [bholagabbar]

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
#define sz 100001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

const int N = 10000001+10;
int cnt[N] = {0};
int pre[N] = {0};
bool prime[N];

void primeSieve()
{
	fill(prime, prime+N, 1);
	prime[0] = prime[1] = 0;
	for(int i=2 ;i<=N; i++)
	{
		if (prime[i])
		{
			pre[i] += cnt[i];
			for (int j = i + i; j < N; j += i)
			{
				prime[j] = false;
				pre[i] += cnt[j];
			}
		}
		pre[i]+=pre[i-1];
	}
}

int main()
{
	boostIO;
	int n,x,l,r;
	cin >> n;
	for(int i=1; i<=n ;i++)
	{
		cin >> x;
		cnt[x]++;
	}
	primeSieve();
	cin >> n;
	while (n--)
	{
		cin >> l >> r;
		if (l > 10000000) l = 10000000;
		if (r > 10000000) r = 10000000;
		cout << pre[r] - pre[l-1] << endl;
	}
	return 0;
}