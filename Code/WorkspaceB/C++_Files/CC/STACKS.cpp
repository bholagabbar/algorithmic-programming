/*input
3
6
3 4 5 1 1 2
10
3 2 9 5 2 9 4 14 7 10
8
14 5 13 19 17 10 18 12
*/
#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define CLR(s) memset(&s, 0, sizeof(s))
#define hashset unordered_set
#define hashmap unordered_map
#define pii pair<int,int>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define MOD 1000000007
#define endl '\n'

typedef long long int ll;
typedef long double ld;

//Created by Shreyans Sheth [bholagabbar]

int main()
{
	//ReadFile;
	BoostIO;
	int tc;
	cin>>tc;
	while(tc--)
	{
		int n;
		ll x;
		cin>>n;
		vector<ll> v;
		cin>>x;
		v.pb(x);
		for(int i=1;i<n;i++)
		{
			cin>>x;
			auto it=lower_bound(v.begin(),v.end(),x+1);
			if(it==v.end())
				v.pb(x);
			else
				v[distance(v.begin(),it)]=x;
		}
		cout<<v.size()<<" ";
		for(auto i:v)
			cout<<i<<" ";
		cout<<endl;
	}
	return 0;
}