/*input
6 3
*/
#include <iostream>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define pll pair<long long int,long long int>
#define CLR(s) memset(&s, 0, sizeof(s))
#define hashset unordered_set
#define hashmap unordered_map
#define pii pair<int,int>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl '\n'

typedef unsigned long long int ll;
typedef long double ld;

//Created by Shreyans Sheth [bholagabbar]

int main()
{
	//ReadFile;
	BoostIO;
	ll n,m,min,max;
	cin>>n>>m;
	if(m==1)
		max=min=(n*(n-1))/2;
	else
	{
		max=((n-m+1)*(n-m))/2;
		ll m1=n/m;//min
		ll mintimes=m;
		ll maxtimes=n%m;
		mintimes-=maxtimes;
		min=mintimes*((m1*(m1-1))/2)+maxtimes*(m1*(m1+1))/2;
	}
	cout<<min<<" "<<max<<endl;
	return 0;
}