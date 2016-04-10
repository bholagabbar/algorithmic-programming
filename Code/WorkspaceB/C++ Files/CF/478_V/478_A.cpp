#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define pll pair<long long int,long long int>
#define CLR(s) memset(&s, 0, sizeof(s))
#define hashset unordered_set
#define hashmap unordered_map
#define pii pair<int,int>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;

//Created by Shreyans Sheth [bholagabbar]

int main()
{
	//ReadFile;
	BoostIO;
	long sum=0;
	for(int i=0;i<5;i++)
	{
		ll x;
		cin>>x;
		sum+=x;
	}
	if(sum%5!=0)
		cout<<"-1";
	else
		cout<<(sum/5);

	return 0;
}