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
int cnt[sz]={0};

int main()
{
	boostIO;
	int n,m,a,b;
	cin>>n>>m;
	for(int i=0;i<m;i++)
	{
		cin>>a>>b;
		cnt[a]++;
		cnt[b]++;
	}

	int cnt1=0, cnt2=0, cntn=0, cntshite=0;
	for(int i=1;i<=n;i++)
	{
		if(cnt[i]==1)
			cnt1++;
		else if(cnt[i]==2)
			cnt2++;
		else if(cnt[i]==n-1)
			cntn++;
		else
			cntshite++;
	}

	if(cnt1==2 && cnt2==n-2 && cntn==0 && cntshite==0)
		cout<<"bus topology";
	else if(cnt1==0 && cnt2==n && cntn==0 && cntshite==0)
		cout<<"ring topology";
	else if(cnt1==n-1 && cntn==1 && cnt2==0 && cntshite==0)
		cout<<"star topology";
	else
		cout<<"unknown topology";

	return 0;
}