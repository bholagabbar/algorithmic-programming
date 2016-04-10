/*input
3
3 10
7 3 1
3 5
7 3 1
3 1
7 3 1
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
		int n,p,cnt=0;
		cin>>n>>p;
		int temp;
		for(int i=0;i<n;i++)
		{
			cin>>temp;
			if(temp>=p)
				cnt++;
		}
		cout<<cnt<<endl;
	}	
	return 0;
}