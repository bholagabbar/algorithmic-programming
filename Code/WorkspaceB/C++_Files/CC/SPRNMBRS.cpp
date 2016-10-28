#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostCC ios_base::sync_with_stdio(false)
#define pb emplace_back
#define mp make_pair
#define hashset unordered_set
#define hashmap unordered_map
#define pii pair<int,int>
#define endl '\n'

typedef long long int ll;
typedef long double ld;

//Created by Shreyans Sheth [bholagabbar]

vector<ll> v;

void PreCalculate()
{
	ll lim=(ll)1e18;
	ll s=2;
	v.pb(1);
	while(s<=lim)
	{
		v.pb(s);
		ll th=(ll)3*s;
		while(th<=lim)
		{
			v.pb(th);
			th*=3;
		}
		s*=2;
	}
	sort(v.begin(),v.end());
}

int main()
{
	//ReadFile;
	BoostCC;
	PreCalculate();
	int tc;
	cin>>tc;
	while(tc--)
	{
		ll l,r;
		int cnt=0;
		cin>>l>>r;
		if(l>(ll)999502313552216064)
		{
			cout<<"0\n";
		}
		else
		{
			auto start = distance(v.begin(), lower_bound(v.begin(), v.end(),l));
			for(int i=start;i<v.size();i++)
			{
				if(v[i]>=l && v[i]<=r)
					cnt++;
				else
					break;
			}
			cout<<cnt<<endl;
		}
	}
	return 0;
}