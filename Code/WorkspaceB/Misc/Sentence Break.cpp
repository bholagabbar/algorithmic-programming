#include<stdio.h>
#include<conio.h>
#include<string.h>
main()
{
char t[100];
printf("Please enter title\n");
gets(t);
int i=0,j=0;
int cntw=1;
int len=strlen(t);
for(i=0;i<len;i++)
{
if((t[0]>=97)&&(t[0]<=122))
{
t[0]-=32;
}
if(t[i]==' ')
{
cntw++;
if((t[i+1]>=97)&&(t[0]<=122))
{
t[i]-=32;
}
}
}
printf("No of words:%d",cntw);
printf("\n");
for(i=0;i<len;i++)
{
printf("%c",t[i]);
}
return(0);
}



