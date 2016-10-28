/*input
2
3 3
-1 -1 1
-1 -1 -1
1 -1 -1
2 3
0 1 -2
2 3 1
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

int main()
{
	//readFile;
	boostIO;
	int tc;
	cin>>tc;
	while(tc--)
	{
		int m,n;
		cin>>m>>n;
		ll a[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				cin>>a[i][j];
		ll ans=LONG_MIN;
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
			{
				int cx=i,cy=j,k=1;
				while(cx+k<m && cy+k<n)
				{
					int cxx=i,cyy=j,k1=0;
					ll sum1=0;
					while(cxx+k1 <=cx+k && cyy+k1<=cy+k)
					{
						sum1+=a[cxx+k1][cyy+k1];
						k1++;
					}
					cxx=cx+k;
					cyy=cy;
					k1=0;
					while(cxx-k1 >=cx && cyy+k1<=cy+k)
					{
						sum1+=a[cxx-k1][cyy+k1];
						k1++;
					}
					if(k1%2==0)
						sum1-=a[cx+(k1/2)][cy+(k1/2)];
					cout<<sum1<<endl;
					k++;
					ans=max(ans,sum1);
				}
			}
		cout<<ans<<endl;
	}	
	
	return 0;
}