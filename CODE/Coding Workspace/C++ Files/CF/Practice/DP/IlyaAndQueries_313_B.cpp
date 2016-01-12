/*input
#..###
5
1 3
5 6
1 5
3 6
3 4
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
	string s;
	cin>>s;
	int n=s.size();
	int seg[n]={0};
	if(s[1]==s[0])
		seg[1]=1;
	for(int i=1;i<n;i++)
	{
		if(s[i-1]==s[i])
			seg[i]=seg[i-1]+1;
		else
			seg[i]=seg[i-1];
	}
	int q;
	cin>>q;
	while(q--)
	{
		int l,r;
		cin>>l>>r;
		cout<<seg[r-1]-seg[l-1]<<endl;
	}
	return 0;
}