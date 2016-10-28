/*input
3 6
CLICK 1
CLICK 2
CLICK 3
CLICK 2
CLOSEALL
CLICK 1
*/
#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define endl '\n'

typedef long long int ll;

//Created by Shreyans Sheth [bholagabbar]

int main()
{
	BoostIO;
	//ReadFile;
	int n,t;
	cin>>n>>t;
	unordered_set<int> hs;
	string s;
	int x;
	while(t--)
	{
		cin>>s;
		if(s.compare("CLICK")==0)
		{
			cin>>x;
			auto it=hs.find(x);
			if(it==hs.end())
				hs.insert(x);
			else
				hs.erase(x);
		}
		else
			hs.clear();
		cout<<hs.size()<<endl;
	}
	return 0;
}