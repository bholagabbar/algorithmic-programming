#include <algorithm>
#include <stdio.h>
using namespace std;
int main() 
{
	int n,m;
	scanf("%d%d",&n,&m);
	int a[n];
	for(int j=0;j<n;j++)
	{
		scanf("%d",&a[j]);
	}
	sort(a, a+n);
	printf("%d\n",a[(n-m)]);
	return 0;
}