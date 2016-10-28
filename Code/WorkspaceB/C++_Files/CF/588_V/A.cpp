/*input
3
1 3
2 1
3 1
*/
#include <bits/stdc++.h>
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

typedef long long int ll;
typedef long double ld;

//Created by Shreyans Sheth [bholagabbar]

int a[100005],p[100005];

int main()
{
	//ReadFile;
	BoostIO;
	int n;
	cin>>n;
	for(int i=0;i<n;i++)
		cin>>a[i]>>p[i];
	ll sum=0;
	for(int i=0;i<n;i++)
	{
		sum+=a[i]*p[i];
		ll meatcnt=0;
		int j=i+1;
		while(p[i]<=p[j])
			meatcnt+=a[j++];
		sum+=meatcnt*p[i];
		i=j-1;
	}
	cout<<sum;
	return 0;
}