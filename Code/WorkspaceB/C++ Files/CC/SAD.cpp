#include <stdio.h>
int main()
{
	int r,c;
	scanf("%d%d",&r,&c);
	long a[r][c];
	for(int i=0;i<r;i++)
	{
		for(int j=0;j<c;j++)
		{
			scanf("%ld",&a[i][j]);
		}
	}
	long ro[r];
	long co[c];
	for(int i=0;i<c;i++)
	{
		long max=-1;
		for(int j=0;j<r;j++)
		{
			if(a[j][i]>max)
			{
				max=a[j][i];
			}
		}
		co[i]=max;
	}
	for(int i=0;i<r;i++)
	{
		long min=0;
		for(int j=0;j<c;j++)
		{
			if(j==0)
			{
				min=a[i][j];
			}
			else
			{
				if(a[i][j]<min)
				{
					min=a[i][j];
				}
			}
		}
		ro[i]=min;
	}
	int flag=0;
	for(int i=0;i<r;i++)
	{
		for(int j=0;j<c;j++)
		{
			if(ro[i]==co[j])
			{
				flag =1;
				printf("%ld",ro[i]);
				goto f;
			}
		}
	}
	
	f:if(flag==0)
	{
		printf("GUESS");
	}

	return 0;
}