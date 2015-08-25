#include <iostream>
#include <string.h>
using namespace std;
int main()
{
	int t;
	cin>>t;
	for(int i=0;i<t;i++)
	{
		char a[1000];
		cin>>a;
		int l=strlen(a);
		int f=0;
		int b=l-1;
		int cnt=0;
		int flag=1;
		while(f>=b)
		{
			if(a[f]!=a[b])
			{
				cnt++;
				if(cnt>1)
				{
					flag=0;
					break;
				}
			}
			f++;
			b--;
		}
		if(flag==1)
		{
			cout<<"yes"<<endl;
		}
		else
		{
			cout<<"no"<<endl;
		}
	}
	return 0;
}
