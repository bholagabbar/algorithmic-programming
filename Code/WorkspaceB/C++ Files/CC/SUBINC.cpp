/*input
2
4
1 4 2 3
1
5
*/
#include <bits/stdc++.h>
using namespace std;

typedef long long int ll;

int main()
{
	int n,t;
	scanf("%d",&t);
	while(t--)
	{
		scanf("%d",&n);
		ll x,x1,cnt=1,ans=0;
		scanf("%lld",&x);
		for(int i=1;i<n;i++)
		{
			scanf("%lld",&x1);
			if(x1>=x)
				cnt++;
			else
			{
				ans+=(cnt*(cnt+1))/2;
				cnt=1;
			}
			x=x1;
		}
		ans+=(cnt*(cnt+1))/2;
		printf("%lld\n",ans);
	}
	return 0;
}