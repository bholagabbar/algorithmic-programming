/*input
3
3 3
3 2 1
3 1
1 2 3
3 2
1 2 3
*/
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

int c[100005]={0};

ll Merge(int l, int mid, int r, int a[])
{
	int i=l,j=mid+1,k=l;
	ll inv=0;
	while(i<=mid && j<=r)
	{
		if(a[i]<=a[j])
			c[k++]=a[i++];
		else
		{
			c[k++]=a[j++];
			inv+=(mid-l)-i;
		}
	}
	while(i<=mid)
		c[k++]=a[i++];
	while(j<=r)
		c[k++]=a[j++];
	for(int i=l;i<=r;i++)
		a[i]=c[i];
	return inv;
}

ll MergeSort(int l, int r, int a[])
{
	if(l<r)
	{
		int mid=(l+r)>>1;
		return MergeSort(l,mid,a)+MergeSort(mid+1,r,a)+Merge(l,mid,r,a);
	}
}

int main()
{
	int tc;
	cin>>tc;
	for(int q=1;q<=tc;q++)
	{
		int n;
		ll k,ans;
		cin>>n>>k;
		int a[n];
		bool flag=0;
		hashset<int> hs;
		for(int i=0;i<n;i++)
		{
			cin>>a[i];
			hs.insert(a[i]);
		}
		if(hs.size()!=n)
			flag=1;
		ll inv=MergeSort(0,n-1,a);
		if(inv>=k)
			ans=inv-k;
		else
			ans=(flag || (inv-k)%2==0)?0:1;
		cout<<ans<<endl;
	}
}
