#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(false)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define sz 100005
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

//Shreyans Sheth [bholagabbar]

int main()
{
	//readFile
	boostIO;
	int tc;
	cin>>tc;
	while(tc--)
	{
		int n,m;
		cin>>n>>m;
		ll a[n],b[m];
		for(int i=0;i<n;i++)
			cin>>a[i];
		for(int i=0;i<m;i++)
			cin>>b[i];
		sort(a,a+n);
		sort(b,b+m);
		int cnt1=0,cnt2=0;
		while(cnt1 !=n and cnt2!=m)
		{
			if(b[cnt2]<=a[cnt1])
				cnt2++;
			else
				cnt1++;
		}
		if(cnt1==n && cnt2!=m)
			cout<<"MechaGodzilla\n";
		else if(cnt2==m and cnt1!=n)
			cout<<"Godzilla\n";
		else
			cout<<"uncertain\n";

	}
	return 0;
}