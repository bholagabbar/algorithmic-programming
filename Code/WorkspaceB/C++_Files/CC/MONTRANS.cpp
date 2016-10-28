/*input
2
9 77 69
98 99 69
*/
#include <iostream>
#include <cstdio>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int main()
{
	int t;
	scanf("%d",&t);
	while(t--)
	{
		int a,b,c;
		scanf("%d%d%d",&a,&b,&c);
		int ans=0,cnt=0;
		float f=(float)(a*100.0+b);
		float max=f;
		while(cnt<10000 && (a>0||b>=c))
		{
			if(b>=c)
			{
				b-=c;
			}
			else
			{
				b+=100;
				b-=c;
				a-=1;
			}
			swap(a,b);
			cnt++;
			f=(float)(a*100.0+b);
			if(f>max)
			{
				max=f;
				ans=cnt;
			}
		}
		printf("%d\n",ans);
	}	

	return 0;
}