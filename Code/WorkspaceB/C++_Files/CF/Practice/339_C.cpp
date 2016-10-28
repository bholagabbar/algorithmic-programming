/*input
1 1 3
10
*/
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
#define sz 100001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

int candles[sz]={0}, a[sz];

int main()
{
	boostIO;
	int m,t,r;
	cin>>m>>t>>r;
	for(int i=0;i<m;i++)
	{
		cin>>a[i];
		a[i]+=305;
	}
	int ans=0;
	for(int i=0; i<m; i++)
		if(candles[a[i]]<r)
		{
			for(int j=a[i]-1; j>=a[i]-t && candles[a[i]] <r ; j--)
			{
				int prevCnt=candles[a[i]];
				for(int k=j; k<= j+t; k++)
					candles[k]++;
				if(candles[a[i]]==prevCnt)
				{
					cout<<"-1";
					return 0;
				}
				ans++;
			}
			if(candles[a[i]]<r)
			{
				cout<<"-1";
				return 0;
			}
		}
	cout<<ans;
	return 0;
}