/*input
2
2
3 2
2
1 1
*/

#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int tc;
	cin>>tc;
	while(tc--)
	{
		int n,x;
		cin>>n;
		set <int> ans;
		for(int i=0;i<n;i++)
		{
			cin>>x;
			ans.insert(x);
		}
		cout<<ans.size()<<endl;
	}	

	return 0;
}