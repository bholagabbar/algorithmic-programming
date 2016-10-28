#include<stdio.h>
#include<math.h>
int main()
{
int i=0,wit=0;
float bal=0;
scanf("%d",&wit);
scanf("%f",&bal);
if(((wit>0)&&(wit<=2000))&&((bal>=0)&&(bal<=2000)))
{
if((bal>=((wit+0.5))&&(wit%5==0)))
{
float ans=round(((bal-wit)-(0.50))*100.0)/100.0;
printf("%.2f",ans);
}
else if(((wit+0.5)>bal))
{
bal=round(bal*100.0)/100.0;
printf("%.2f",bal);
}
else if(((int)wit%5!=0))
{
bal=round(bal*100.0)/100.0;
printf("%.2f",bal);
}
}
return (0);
}


