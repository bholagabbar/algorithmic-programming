/*input
3
100 6
13 17 42 9 23 57
99 6
13 17 42 9 23 57
1000 3
314 159 265
*/
#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define printPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(false)
#define CLR(s) memset(&s, 0, sizeof s)
#define PI(x) printf("%d", x)
#define PL(x) printf("%lld", x)
#define SI(x) scanf("%d", &x)
#define SD(x) scanf("%lf", &x)
#define SL(x) scanf("%lld", &x)
#define hashset unordered_set
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define sz 100005
#define F first
#define S second
#define endl '\n'

typedef pair<int, int> pii;
typedef long long int ll;
typedef pair<ll, ll> pll;
typedef long double ld;

//Shreyans Sheth [bholagabbar]

int main()
{
	//readFile
	boostIO;
	int tc;
	cin>>tc;
	for(int t=1;t<=tc;t++)
	{
		ll k,n;
		cin>>k>>n;
		ll a[n];
		for(int i=0;i<n;i++)
			cin>>a[i];
		sort(a,a+n);
		int cnt=0;
		for(int i=n-1;i>=0;i--)
		{
			k-=a[i];
			cnt++;
			if(k<=0)
				break;
		}
		cout<<"Scenario #"<<t<<":\n";
		if(k>0)
			cout<<"impossible";
		else
			cout<<cnt;
		cout<<endl<<endl;
	}		
	
	return 0;
}