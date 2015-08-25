/*input
amanaplanacanal
aaaabbbb
xyz
a
b
acd
aaabbcc
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

char a[1000000];
char r[1000000];
char s[5000000];
long z[1000000];
char temp[1000000];
int main()
{
	while(scanf("%s",a)!=EOF)	
	{
		int n=strlen(a);
		int cnt=0;
		memset(r,0,sizeof(r));
		memset(s,0,sizeof(s));
		memset(temp,0,sizeof(temp));
		for(int i=n-1;i>=0;i--)
		{
			r[cnt]=a[i];
			cnt++;
		}
		strcpy(s,r);
		strcat(s,"$");
		strcat(s,a);
		n=strlen(s);
		int xs=strlen(r);
		long max=0;
		for(long i=1,l=0,r=0;i<n;i++)
		{
			z[i]=0;
			if(i<r)
			{
				z[i]=min(r-i+1,z[i-l]);
			}
			while(i+z[i]<n && s[z[i]]==s[i+z[i]])
			{
				z[i]++;
			}
			if(i+z[i]-1>r)
			{
				r=i+z[i]-1,l=i;
			}
			if(i>xs && z[i]>max)
			{
				max=z[i];
			}
		}
		cnt=0;
		for(long i=max;i<xs;i++)
		{
			temp[cnt]=r[i];
			cnt++;
		}
		strncpy(temp,r+max,(xs-max));
		strcat(a,temp);
		printf("%s\n",a);
	}
	return 0;
}