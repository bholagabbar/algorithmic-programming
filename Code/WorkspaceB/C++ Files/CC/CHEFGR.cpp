#include <bits/stdc++.h>
#define endl '\n'
using namespace std;
int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	//cin.tie(NULL);//Untie streams before submitting
	int t;
	cin>>t;
	while(t--)
	{
		int n,m;
		cin>>n>>m;
		int a[n];
		int max=-1;
		for(int i=0;i<n;i++)
		{
			cin>>a[i];
			if(a[i]>max)
			{
				max=a[i];
			}
		}
		int flag=1;
		for(int i=0;i<n;i++)
		{
			if(a[i]!=max)
			{
				m-=(max-a[i]);
				if(m<0)
				{
					break;
				}
			}
		}
		if(m<0||(m>0&&m%n!=0))
		{
			flag=0;
		}
		if(flag==1)
		{
			cout<<"Yes"<<endl;
		}
		else
		{
			cout<<"No"<<endl;
		}
	}	
	return 0;
}