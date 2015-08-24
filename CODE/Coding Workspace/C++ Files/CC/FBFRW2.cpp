#include <algorithm>
#include <stdio.h>
using namespace std;
int main() 
{
	int t;
	scanf("%d",&t);
	while(t--)
	{
		int n;
		scanf("%d",&n);
		int a[n];
		for(int j=0;j<n;j++)
		{
			scanf("%d",&a[j]);
		}
		sort(a, a+n);
		int flag=1;
		int ans=0;
		int cnt=1;
		for(int j=0;j<n;j++)
		{
			a[j]=a[j]-cnt;
			if(a[j]<0)
			{
				flag=0;
				break;
			}
			ans++;
			cnt++;
			if(cnt%7==0)
			{
				cnt++;
			}
		}

		if(flag==1)
		{
			printf("Bhai Ho!\n");
		}
		else
		{
			printf("Killed %d\n",ans);	
		}
	}
	return 0;
}