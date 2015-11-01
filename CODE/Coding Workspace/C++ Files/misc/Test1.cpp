#include<stdio.h>
#include<conio.h>
#include<string.h>
int main()
{
char masterlist[5][10]={"Sh","RE","Y","AN","S"};
int i,flag,a;
char yourname[10];
scanf("%s",&yourname);
flag =0;
for(i=0;i<5;i++)
{
strcmp(masterlist[i][0],yourname);
if(a==0)
{
printf("WELCOME");
flag=1;
break;
}
}
if(flag==0)
{
printf("FUCK OFF");
}

}

