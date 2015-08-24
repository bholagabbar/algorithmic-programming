#include <stdio.h>
#include <math.h>
int main()
{
	int t;
	scanf("%d",&t);
	while(t--)
	{
		int o,r,s;
		scanf("%d%d%d",&o,&r,&s);
		double ans=((r*o+s)/(o+1));
		printf("%0.2d \n",ans);
	}
	return 0;
}