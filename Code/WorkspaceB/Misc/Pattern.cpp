#include<stdio.h>
#include<conio.h>
main()
{
	int max, min, i,j,h,cnt1=-1,cnt2=-1;
	printf("Please enter min no\n");
	scanf("%d",&min);
	printf("Please enter max no\n");
	scanf("%d",&max);
    printf("\n\n");
	for(i=min;i<=(max);i++)
   {
    cnt1++;
	for((j=min+cnt1);j<=(max);j++)
   {
    		printf("%d",j);
   }
   if(j>min)
   {
   cnt2++;
   for(h=min;h<(min+cnt2);h++)
   {
   		printf("%d",h);
   }
   }
   printf("\n");
   }
   getch();
   }

