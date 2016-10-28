/*input
2
3 2
piygu ezyfo rzotm
1 piygu
6 tefwz tefwz piygu ezyfo tefwz piygu
4 1
kssdy tjzhy ljzym kegqz
4 kegqz kegqz kegqz vxvyj
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
	while(tc-->0)
	{
		int n,k;
		cin>>n>>k;
		vector<string> v;
		for(int i=0;i<n;i++)
		{
			string x;
			cin>>x;
			v.pb(x);
		}
		hashset<string> hs2;
		for(int i=0;i<k;i++)
		{
			int l;
			cin>>l;
			for(int j=0;j<l;j++)
			{
				string x;
				cin>>x;
				hs2.insert(x);
			}
		}
		for(auto i:v)
		{
			auto it=hs2.find(i);
			if(it==hs2.end())
				cout<<"NO ";
			else
				cout<<"YES ";
		}
		cout<<endl;
	}	
	return 0;
}