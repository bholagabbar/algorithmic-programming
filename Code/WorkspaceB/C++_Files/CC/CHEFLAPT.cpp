#include <stdio.h>
#include <algorithm>
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
        if(n==1)
        {
            printf("%d\n",a[0]);
        }
        else
        {
            for(int j=0;j<n;j++)
            {
                if(j==0&&a[j]!=a[j+1])
                {
                    printf("%d\n",a[j]);
                    break;
                }
                else if(j!=0&&j!=n-1&&a[j-1]!=a[j]&&a[j+1]!=a[j])
                {
                    printf("%d\n",a[j]);
                    break;
                }
                else if(j==n-1&&a[j-1]!=a[j])
                {
                    printf("%d\n",a[j]);
                    break;
                }
            }
        }		
	}
	return 0;
}