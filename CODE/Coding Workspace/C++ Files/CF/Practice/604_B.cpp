/*input
4 3
2 3 5 9
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

int n,k; //wants to fit in k boxes. Find min size
ll a[sz];
map<int,int> mymapt;

bool check(ll mid)
{
	ll size=mid;
	int boxes=1;
	int cnt=0;
	ll currwt=size;
	map<int,int>mymap=mymapt;
	for(int i=n-1;i>=0;i--)
	{
		if(mymap[a[i]]>0)
		{
			int x=a[i];
			mymap[a[i]]--;
			if(mymap[a[i]]==0)
				mymap.erase(a[i]);
			auto y=mymap.upper_bound(min(size-a[i],a[i]-1));
			if(y!=mymap.end())
			{
				int val=y->first;
				mymap[val]--;
				if(mymap[val]==0)
					mymap.erase(val);
				cout<<" "<<val;
			}
			cout<<endl;
			boxes+=1;
			if(boxes>k)
				return false;
			if(mymap.size()==0)
				break;
		}
	}
	return true;
}

int binarySearch(ll lo, ll hi)
{
	while(lo<hi)
	{
		int mid=lo+(hi-lo)/2;
		if(check(mid))//Fit. Decrease size
			hi=mid;
		else
			lo=mid+1;
	}
	return hi;
}


int main()
{
	boostIO;
	cin>>n>>k;
	int mx=0;
	for(int i=0;i<n;i++)
	{
		cin>>a[i];
		mymapt[a[i]]++;
		mx=max((int)a[i],mx);
	}
	cout<<binarySearch(mx,(ll)1e9);
	return 0;
}