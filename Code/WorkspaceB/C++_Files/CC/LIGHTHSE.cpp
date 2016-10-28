#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define pb emplace_back
#define mp make_pair
#define pii pair<int,int>
#define pll pair<long long int, long long int>
#define endl '\n'
 
typedef long long int ll;
 
//Created by Shreyans Sheth [bholagabbar]
 
int main()
{
	BoostIO;
	//ReadFile;
	int tc;
	cin>>tc;
	while(tc--)
	{
		int n;
		cin>>n;
		map<pll,ll> m;
		ll miny=1000000005,maxy=-1000000005,maxx=-1000000005,minx=1000000005;
		for(int i=1;i<=n;i++)
		{
			ll x,y;
			cin>>x>>y;
			m[{x,y}]=i;
			maxy=max(maxy,y);
			miny=min(miny,y);
			maxx=max(maxx,x);
			minx=min(minx,x);
		}
		auto it1=m.find({minx,miny});
		auto it2=m.find({minx,maxy});
		auto it3=m.find({maxx,miny});
		auto it4=m.find({maxx,maxy});
		if(it1!=m.end())
			cout<<"1\n"<<it1->second<<" NE\n";
		else if(it2!=m.end())
			cout<<"1\n"<<it2->second<<" SE\n";
		else if(it3!=m.end())
			cout<<"1\n"<<it3->second<<" NW\n";
		else if(it4!=m.end())
			cout<<"1\n"<<it4->second<<" SW\n";
		else
		{
			pll left=m.begin()->first;
			ll leftis=m.begin()->second;
			pll right=m.rbegin()->first;
			ll rightis=m.rbegin()->second;
			if(left.second> right.second)
				cout<<"2\n"<<leftis<<" SE\n"<<rightis<<" NW\n";
			else
				cout<<"2\n"<<leftis<<" NE\n"<<rightis<<" SW\n";
		}
	}
	return 0;
} 