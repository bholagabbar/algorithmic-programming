#include <bits/stdc++.h>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(false);cin.tie(0);//FAST IO
	int t;
	cin>>t;
	while(t--)
	{
		string s;
		cin>>s;
		vector<char> al;
		vector<char> num;
		for(int i=0;i<s.size();i++)
		{
			if(s.at(i)>=48 &&s.at(i)<=57)
			{
				num.push_back(s.at(i));
			}
			else
			{
				al.push_back(s.at(i));
			}
		}
		sort(num.begin(),num.end());
		sort(al.begin(),al.end());
		
		stack <char> ans;
		
		for(int i=s.size()-1;i>=0;i--)
		{
			if(s.at(i)>=48 &&s.at(i)<=57)
			{
				ans.push(num.at(num.size()-1));
				num.pop_back();
			}
			else
			{
				ans.push(al.at(al.size()-1));
				al.pop_back();			
			}
		}
		while(!ans.empty())
		{
			cout<<ans.top();
			ans.pop();
		}
		cout<<"\n";
	}
	return 0;
}