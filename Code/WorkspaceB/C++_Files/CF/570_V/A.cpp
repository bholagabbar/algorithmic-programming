/*input
3 4
10 10 3
5 1 6
2 2 2
1 5 7
*/
#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define boostIO ios_base::sync_with_stdio(false)
#define ld long double
#define ll long long int
#define CLR(s) memset(&s, 0, sizeof(s))
#define scani(s) scanf("%d",&s)
#define scanl(s) scanf("%lld",&s)
#define hashset unordered_set //JAVA feels :')
#define hashmap unordered_map
#define pll pair<ll,ll>
#define pii pair<int,int>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl '\n'

int main()
{
	//readFile;
	boostIO;
	ll n,m;
	cin>>n>>m;
	ll a[m][n];
	for(ll i=0;i<m;i++)
		for(ll j=0;j<n;j++)
			cin>>a[i][j];
	ll cand[n]={0};
	for(ll i=0;i<m;i++)
	{
		ll index=0;
		ll max=a[i][0];
		for(ll j=1;j<n;j++)
			if(a[i][j]>max)
			{
				max=a[i][j];
				index=j;
			}
		cand[index]++;
	}
	ll win=0;
	ll max=cand[0];
	for(ll i=1;i<n;i++)
		if(cand[i]>max)
		{
			max=cand[i];
			win=i;
		}
	cout<<win+1;
	return 0;
}