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
		if(k==1&&n==1)
			{
				cout<<"1\n";
			}
			else
			{
				if(k>(n/2))
				{
					cout<<"-1\n";
				}
				else
				{
					int x=2;
					int cnt=0;
					while(cnt!=k)
					{
						cout<<x<<" ";
						cnt++;
						x+=2;
					}
					cout<<"\n";
				}
			}
	}	
	return 0;
}