#include<stdio.h>
int main()
{
int a,n,k;
scanf("%d",&a);
scanf("%d",&n);
scanf("%d",&k);
int p[k+1];
int i=0;
for(i=0;i<k;i++)
            {
            p[i]=0;
            }
for(i=0;i<a;i++)
            {
            int cnt = 0;
            if (n == 0)
                {
                break;
                }
            else
                {
                p[cnt]++;
                if (p[cnt] > n)
                    {
                    while (p[cnt] > n && cnt < k)
                        {
                        p[cnt] = 0;
                        p[cnt+1]++;
                        cnt++;
                        }
                    }
                }
            }
            for(i=0;i<k;i++)
            {
            printf("%d ",p[i]);
            }
return(0);
}
