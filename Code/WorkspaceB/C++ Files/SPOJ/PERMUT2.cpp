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

int a[sz],b[sz];

int main()
{
	//readFile
	boostIO;
	int n;
	cin>>n;
	while(n!=0)
	{
		for(int i=1;i<=n;i++)
		{
			cin>>a[i];
			b[a[i]]=i;
		}
		int flag=1;
		for(int i=1;i<=n;i++)
			if(a[i]!=b[i])
			{
				flag=0;
				break;
			}
		if(flag==0)
			cout<<"not ambiguous\n";
		else
			cout<<"ambiguous\n";
		cin>>n;
	}
	
	return 0;
}