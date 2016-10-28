#include <iostream>
#include <math.h>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(false);cin.tie(0);
	int t;
	cin>>t;
	while(t--)	
	{
		string a;
		cin>>a;
		int ans=0;
		if(a.size()==1)
		{
			ans=0;
		}
		else
		{
			for(int i=0;i<a.size()-1;i++)
			{
				if(a.at(i)=='0'&&a.at(i+1)=='1')
				{
					ans++;
					i++;
				}
			}
		}
		cout<<ans<<"\n";
	}
	return 0;
}