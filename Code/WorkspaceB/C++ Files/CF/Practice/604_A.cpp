/*input
55 66 75 44 47
6 0 6 6 10
19 0
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
	int m[5],w[5],sh,wh;
	for(int i=0;i<5;i++)
		cin>>m[i];
	for(int i=0;i<5;i++)
		cin>>w[i];
	cin>>sh>>wh;
	double ans=0;
	double cnt[5]={500, 1000, 1500, 2000,2500};
	for(int i=0;i<5;i++)
		ans+=max(0.3*cnt[i],(1-(m[i]/250.0))*cnt[i]-50.0*w[i]);
	cout<<(int)(floor(ans+100.0*sh-50.0*wh+0.5));
	return 0;
}