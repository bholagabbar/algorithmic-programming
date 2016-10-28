/*input
2 2
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
	ll n,k;
	cin>>n>>k;
	cout<<(6*(n-1)+5)*k<<endl;;
	for(int i=0;i<n;i++)
	{
		cout<<(6*i+1)*k<<" "<<(6*i+3)*k<<" "<<(6*i+4)*k<<" "<<(6*i+5)*k<<endl;
	}
	return 0;
}