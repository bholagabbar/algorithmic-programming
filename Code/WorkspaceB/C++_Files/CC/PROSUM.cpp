/*input
3
3
3 4 5
4
1 1 1 1
7
2 3 1 0 1 2 2
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		int cnt0=0,cnt1=0,cnt2=0,x;
		for(int i=0;i<n;i++)	
		{
			cin>>x;
			if (x==0)
				cnt0++;
			else if (x==1)
				cnt1++;
			else if(x==2)
				cnt2++;
		}
		long long sum=((n*(n-1))/2)-((cnt0+cnt1)*(n-1))-((cnt2*(cnt2-1))/2)+((cnt0*(cnt0-1))/2)+((cnt1*(cnt1-1))/2);
		cout<<sum<<endl;
	}

	return 0;
}