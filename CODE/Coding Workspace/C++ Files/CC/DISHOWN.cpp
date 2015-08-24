/*input
1
2
1 2
2
0 1 2
1 1
*/
#include <iostream>
using namespace std;
 
//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin
 
int u[1000005];
int s[1000005];

int FIND(int x)
{
	if(u[x]!=u[u[x]])
	{
		u[x]=FIND(u[x]);
	}
	return u[x];
}
 
void UNION (int x, int y)
{	
	int px=FIND(x),py=FIND(y);

	if(px==py)
	{
		printf("Invalid query!\n");
		return;
	}

	if(s[px]>s[py])
	{
		u[py]=u[px];
	}
	else if(s[py]>s[px])
	{
		u[px]=u[py];
	}
}
 
inline void ur_init(int n)
{
	for(int i=1;i<=n;i++)
	{
		u[i]=i;
	}
}
 
int main()
{
	int tc;
	scanf("%d",&tc);
	while(tc--)
	{
		int n,q,t,a,b;
		scanf("%d",&n);
		ur_init(n);
		for(int i=1;i<=n;i++)
		{
			scanf("%d",&s[i]);
		}
		scanf("%d",&q);
		while(q--)
		{
			scanf("%d",&t);
			if(t==0)
			{
				scanf("%d%d",&a,&b);
				UNION(a,b);
			}
			else
			{
				scanf("%d",&a);
				printf("%d\n",FIND(a));
			}
		}
	}
	return 0;
} 