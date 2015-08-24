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
		long long x, y;
		cin>>x>>y;
		if(y==0)
		{
			cout<<"1\n";
		}
		else
		{
			int a[10];
			int con[10];
			for(int i=0;i<10;i++)
			{
				a[i]=con[i]=0;
			}
			int cnt=0;
			for(int i=1;;i++)
			{
				long long temp=pow(x,i);
				if(con[temp%10]==0)
				{
					con[temp%10]=1;
					a[i-1]=temp%10;
					cnt++;
				}
				else
				{
					break;
				}
			}
			if(y%cnt==0)
			{
				cout<<a[cnt-1]<<"\n";
			}
			else
			{

				cout<<a[((y%cnt)-1)]<<"\n";	
			}
		}
	}
	return 0;
}