#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define boostIO ios_base::sync_with_stdio(false)
#define ld long double
#define ll long long int
#define CLR(s) memset(&s, 0, sizeof(s))
#define scani(s) scanf("%d",&s)
#define scanl(s) scanf("%lld",&s)
#define hashset unordered_set //JAVA feels :')
#define hashmap unordered_map
#define pll pair<ll,ll>
#define pii pair<int,int>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl '\n'

int main()
{
	//readFile;
	boostIO;
	int n,cnt;
	ll x,y;
	cin>>n;
	pll a[n];
	for(int i=0;i<n;i++)
	{
		cin>>x>>y;
		a[i]={x,y};
	}
	n==1?cnt=1:cnt=2;
	for(int i=1;i<n-1;i++)
	{
		if(a[i].S<(a[i].F-a[i-1].F))//Best case of falling left
			cnt++;
		else if((a[i].S+a[i+1].S)<(a[i+1].F-a[i].F))//2nd best: This to right and aage waala to left
			cnt+=2,i++;
		else if((a[i+1].F-a[i].F)>a[i].S)//Cut to right. Increase x coords
			a[i].F+=a[i].S,cnt++;
	}
	cout<<cnt;
	return 0;
}