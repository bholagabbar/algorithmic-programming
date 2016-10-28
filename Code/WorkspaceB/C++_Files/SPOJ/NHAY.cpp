/*input
2
na
banananobano
6
foobar
foo
9
foobarfoo
barfoobarfoobarfoobarfoobarfoo
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin
char a[9000000];
char b[9000000];
char s[9000000];
long z[9000000];
int main()
{
	int n;
	while(scanf("%d\n",&n)!=EOF)
	{
		scanf("%s",a);
		scanf("%s",b);
		strcpy(s,a);
		strcat(s,"$");
		strcat(s,b);
		long n=strlen(s);
		vector<long>val;
		long plen=strlen(a);
		for(long i=1,l=0,r=0;i<n;i++)
		{
			z[i]=0;
			if(i<r)
			{
				z[i]=std::min(r-i+1,z[i-l]);
			}
			while(i+z[i]<n && s[z[i]]==s[i+z[i]])
			{
				z[i]++;
			}
			if(i+z[i]-1>r)
			{
				r=i+z[i]-1,l=i;
			}
			if(i>plen && z[i]==plen)
			{
				val.emplace_back(i-plen-1);
			}
		}
		for(auto i:val)
		{
			printf("%ld\n",i);
		}
		printf("\n");
	}
	return 0;
}