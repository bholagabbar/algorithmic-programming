/*input
4
-1 3 3 3
3 -1 3 3
3 3 -1 3
3 3 3 -1
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
	int n;
	cin>>n;
	int a[101][101];
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			cin>>a[i][j];
	int cnt[101]={0};
	for(int i=0;i<n;i++)
		for(int j=i+1;j<n;j++)
		{
			if(a[i][j]==1)
				cnt[i]++;
			else if(a[i][j]==2)
				cnt[j]++;
			else if(a[i][j]==3)
			{
				cnt[i]++;
				cnt[j]++;
			}
		}
	set<int> s;
	for(int i=0;i<n;i++)
		if(cnt[i]==0)
			s.insert(i);
	cout<<s.size()<<endl;
	for(auto i:s)
		cout<<(i+1)<<" ";
	return 0;
}