/*input
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

int main()
{
	boostIO;
	int n;
	cin>>n;
	int cnt=1;
	ll f=4,s=7;
	bool flag=0;
	int n1,n2;
	for(int i=0;;i++)
	{
		ll cf=f*i;
		if(cf>n)
			break;
		for(int j=0;;j++)
		{
			ll curr=cf+s*j;
			if(curr==n)
			{
				flag=1;
				n1=i,n2=j;
				break;
			}
			if(curr>n)
				break;
		}
		if(flag==1)
			break;
	}
	if(flag==1)
	{
		for(int i=0;i<n1;i++)
			cout<<"4";
		for(int i=0;i<n2;i++)
			cout<<"7";
	}
	else
		cout<<"-1";
	return 0;
}