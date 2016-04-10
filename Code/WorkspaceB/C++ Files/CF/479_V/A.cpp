/*input
1
2
3
*/
#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define boostIO ios_base::sync_with_stdio(false)
#define ld long double
#define ll long long int
#define CLR(s) memset(&s, 0, sizeof(s))
#define scani(s) scanf("%d",&s)
#define scanl(s) scanf("%64d",&s)
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
	int a,b,c;
	cin>>a>>b>>c;
	int x1=a+(b*c),x2=a*(b+c),x3=a*b*c,x4=(a+b)*c,x5=(a*b)+c,x6=(a+b+c);	
	cout<<max(x1,max(x2,max(x3,max(x4,max(x5,x6)))));
	return 0;
}