/*input
3
3 4
3 1 2
1 1
1
2 4
8 8
*/
#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int tc;
	cin>>tc;
	while(tc--)
	{
		long long n,k;
		cin>>n>>k;
		long long arr[n];
		for(int i=0;i<n;i++)
		{
			cin>>arr[i];
		}
		long long c=0,r=0;
		for(int i=0;i<n;i++)
		{
			if(r>=k)
			{
				c+=r/k;
				r=r%k;
			}
			c+=arr[i]/k;
			r+=arr[i]%k+1;
		}
		if(r-1>=k)
		{
			c+=r/k;
		}
		cout<<c<<"\n";
	}	

	return 0;
}