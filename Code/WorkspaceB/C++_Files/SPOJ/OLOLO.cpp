#include <bits/stdc++.h>
#define pb push_back
using namespace std;
int main()
{
	ios_base::sync_with_stdio(false);cin.tie(0);//FAST IO
	int n,x;
	cin>>n;
	vector<int> v;
	for(int i=0;i<n;i++)
	{
		cin>>x;
		v.pb(x);
	}	
	sort(v.begin(),v.end());
	if(v.at(0)!=v.at(1))
	{
		cout<<v.at(0);
	}
	else if(v.at(v.size()-1)!=v.at(v.size()-2))
	{
		cout<<v.at(v.size()-1);
	}
	else
	{
		for (int i=1;i<v.size()-1;i++)
		{
			if(v.at(i)!=v.at(i+1)&&v.at(i)!=v.at(i-1))
			{
				cout<<v.at(i);
				break;
			}
		}
	}
	return 0;
}