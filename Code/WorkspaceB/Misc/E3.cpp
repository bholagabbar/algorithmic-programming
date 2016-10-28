#include<stdio.h>
int main()
{
int cnt=0;
int nos=0;
scanf("%d",&nos);
int z[nos];
int i;
for(i=0;i<nos;i++)
{
int a=0;
scanf("%d",&a);
int j;
for(j=5;j<=a;j+=5)
{
cnt++;
int j2=(j/5);
while(j2%5==0)
{
cnt++;
j2=j2/5;
}
}
z[i]=cnt;
cnt=0;
}
for(i=0;i<nos;i++)
{
printf("%d\n",z[i]);
}
}
