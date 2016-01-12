#include<stdio.h>
#include<conio.h>
main()
{
int dsum=0;
int c1=-1;
int abno [28124];
int i=0;
int j=0;
int k=0;
int l=0;
for(i=2;i<28124;i++)
{
int f=(i/2);
for(j=1;j<=f;j++)
{
if(i%j==0)
{
dsum+=j;
}
}
if(dsum>i)
{
c1++;
abno[c1]=i;
}
}
int h=((c1*(c1+1))/2);
int abnos[h];
int cnt=0;
for(i=0;i<c1;i++)
{
for(j=0;j<i;j++)
{
abnos[cnt]=(abno[i]+abno[j]);
cnt++;
}
}
int cnt1=0;
while(abnos[k]!=0)
{
cnt1++;
k++;
}
int ab[cnt1];
for(i=0;i<(cnt1);i++)
{
    ab[i]=abnos[i];
}
long sum=0;
sum=(((ab[0]-1)*(ab[0]))/2);
for(i=0;i<(cnt-1);i+=2)
{
int t1=ab[i];
int t2=ab[i+1];
for(l=(t1+1);l<=t2;l++)
{
sum+=l;
}
}
printf("%d",sum);
}

