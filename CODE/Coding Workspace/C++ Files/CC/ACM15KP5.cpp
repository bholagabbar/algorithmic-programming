/*input
2
4
1 2 3 4
4
1 2 1 1
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
	int tc;
	cin>>tc;
	while(tc--)
	{
		int n;
		cin>>n;
		ll a[n];
		for(int i=0;i<n;i++)
			cin>>a[i];
		sort(a,a+n);
		ll sum=a[n-1]+a[n-2]+a[n-3];
		cout<<sum<<endl;
	}		
	return 0;
}