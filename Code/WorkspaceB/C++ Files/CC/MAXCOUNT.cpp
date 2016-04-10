#include <iostream>
#include <algorithm>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(false);cin.tie(0);//okay it halved my time so it's fast
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		int a[n];
		for(int i=0;i<n;i++)
		{
			cin>>a[i];
		}
		std::sort(a, a+n);
		int max=0;
		int no=a[0];
		int cnt=1;
		for(int j=1;j<n;j++)
		{
			if(a[j]==a[j-1])
			{
				cnt++;
			}
			else
			{
				if(cnt>max)
				{
					no=a[j-1];
					max=cnt;
				}
				cnt=1;
			}
		}
		if(cnt>max)
		{
			max=cnt;
			no=a[n-1];
		}
	cout<<no<<" "<<max<<"\n";
	}
	return 0;
}