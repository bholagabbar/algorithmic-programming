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
		int n,k;
		cin>>n>>k;
		int a[n];
		int cnt=0;
		for(int i=0;i<n;i++)
		{
			cin>>a[i];
			if(a[i]%2==0)
			{
				cnt++;
			}
		}
		if((k>0&&cnt>=k)||(k==0&&cnt<n))
		{
			cout<<"YES\n";
		}
		else
		{
			cout<<"NO\n";
		}
	}
	return 0;
}