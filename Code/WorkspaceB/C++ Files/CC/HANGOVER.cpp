/*input
1.00
3.71
0.04
5.19
0.00
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define pb emplace_back

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	vector <float> predef;
	float cnt=2;
	float sum=0;
	while(sum<=5.20)
	{
		sum+=(1/cnt);
		predef.pb(sum);
		cnt++;
	}
	float n;
	cin>>n;
	while(n!=0)
	{
		int c=0;
		while(predef[c]<=n)
		{
			c++;
		}
		cout<<(c+1)<<" card(s)\n";
		cin>>n;
	}

}