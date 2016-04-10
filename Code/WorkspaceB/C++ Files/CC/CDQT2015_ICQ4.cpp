#include <iostream>
#include <algorithm>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(false);cin.tie(0);//FAST IO
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		int a[n-1];
		for(int i=0;i<n-1;i++)
		{
			cin>>a[i];
		}
		sort(a,(a+n-1));
		for(int i=1;i<=n;i++)
		{
			if(a[i-1]!=i)
			{
				cout<<i<<"\n";
				break;
			}
		}
	}
	return 0;
}