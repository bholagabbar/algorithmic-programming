#include<stdio.h>
int main()
{    
        
        int t;
        int i=0;
        scanf("%d",&t);
        for(i=0;i<t;i++)
            {
            int j=0;
            int g;
            scanf("%d",&g);
            for(j=0;j<g;j++)
                {
               
                int l,n,q;
                scanf("%d",&l);
                scanf("%d",&n);
                scanf("%d",&q);
                int ans=0;
                if(l==1)
                    {
                    if(q==1)
                        {
                        ans=n/2;
                        }
                    else
                        {
                        if(n%2==0)
                            {
                            ans=n/2;
                            }
                        else
                            {
                            ans=(n/2) +1;
                            }
                        }
                    }
                else
                    {
                    if(q==2)
                        {
                        ans=n/2;
                        }
                    else
                        {
                        if(n%2==0)
                            {
                            ans=n/2;
                            }
                        else
                            {
                            ans=(n/2) +1;
                            }
                        }
                    }
                printf("%d\n",ans);
                }
            }
        return(0);
		} 
