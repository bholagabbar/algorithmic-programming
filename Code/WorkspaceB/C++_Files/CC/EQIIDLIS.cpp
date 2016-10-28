/*input
3
4
1 2 2 3
2
1 2
7
1 2 3 4 5 6 7
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
		int a[n];
		long long sum=0;
		for(int i=0;i<n;i++)
		{
			cin>>a[i];
			sum+=a[i];
		}
		if(sum%n==0)
		{
			int cnt=0;
			for(;;)
			{
				int mx=0,mn=INT_MAX,mxi=0,mni=0;
				for(int i=0;i<n;i++)
				{
					if(a[i]>mx)
					{
						mx=a[i];
						mxi=i;
					}
					if(a[i]<mn)
					{
						mn=a[i];
						mni=i;
					}
				}
				if(a[mxi]-a[mni]==0)
					break;
				cnt++;
				int diff=ceil((a[mxi]-a[mni])/2);
				a[mni]+=diff;
				a[mxi]-=diff;
			}
			cout<<cnt<<endl;
		}
		else
		{
			cout<<"-1\n";
		}
	}	
	return 0;
}