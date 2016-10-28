/*input
1
1 2 3 4 1 2 3 1 4 1 
*/
#include <stdio.h>
#include <math.h>
#include <string.h>
int main()
{
int t;
scanf("%d",&t);
int i=0;   
for(i=0;i<t;i++)
    {
    int ans=0;
    int s[10];
    int k=0;
	for(k=0;k<10;k++)
        {
        scanf("%d",&s[k]);
        }
        int j=1;
		for(j=1;;j++)
        {
        int nd= floor(log10(abs(j))) + 1;//getting length of integer
		int a[nd];
        int j2=j;
        int cnt=(nd-1);
        while(cnt>-1)
            {
            a[cnt]=j2%10;
            j2=j2/10;
            cnt--;
            }
		int s2[10];
		int u=0;
        for(u=0;u<10;u++)
        {
        s2[u]=s[u];
        }
		for(k=0;k<nd;k++)
            {
            s2[a[k]]--;
            if(s2[a[k]]<0)
                {
                ans=j;
                goto OUT;
                }
            }
        }
    OUT:
	printf("%d\n",ans);
    }
return(0);
}
