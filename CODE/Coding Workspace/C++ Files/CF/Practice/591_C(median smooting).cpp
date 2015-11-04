/*input

*/
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

typedef pair<int, int> pii;
typedef long long int ll;
typedef pair<ll, ll> pll;
typedef long double ld;

//Shreyans Sheth [bholagabbar]

bool a[(sz+5)*5];

int main()
{
	//readFile
	boostIO;
	int n;
	cin>>n;
	for(int i=0;i<n;i++)
		cin>>a[i];
	int max=0;
	for(int i=1;i<n-1;i++)
	{
		int j=i;
		while(j<=n-1 && a[j]!=a[j-1] && a[j]!=a[j+1])
		{
			a[j]=a[j-1];
			cnt++,j++;
		}
		i=j-1;
		max=max(cnt,max);
	}
	cout<<max;
	return 0;
}