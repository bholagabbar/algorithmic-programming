/*input
19
2
1 2
2 3
3
1 2
2 3
4 2
8
1 2
2 3
3 4
3 5
6 7
7 8
7 9
7 10
1
100 200
3
1 10
10 20
5 40
1
5 40
4
1 2
2 3
3 4
1 4
4
30 35
30 40
10 20
5 40
10
171 113
48 146
37 166
176 113
182 42
48 42
153 131
133 167
127 86
27 64
10
1 11
1 12
1 13
1 14
1 15
21 31
21 32
21 33
21 34
21 35
6
11 7
3 10
3 6
2 6
10 2
11 4
9
11 8
2 8
7 4
8 3
8 9
3 4
2 4
4 6
5 4
14
5 4
1 6
12 9
4 10
5 2
1 10
8 6
12 8
10 2
8 10
8 3
2 12
5 9
10 9
10
11 3
1 12
10 9
10 8
3 9
5 6
7 8
6 12
10 6
4 5
9
7 12
3 9
11 4
1 11
8 11
5 8
9 5
9 11
7 6
14
2 3
9 2
12 6
1 11
9 6
1 10
12 2
8 11
1 9
9 8
2 7
8 3
2 11
6 4
6
2 10
7 3
10 5
7 2
9 12
2 12
14
1 11
12 7
6 11
11 5
1 8
6 12
9 7
2 12
4 6
2 9
7 8
8 6
8 3
9 3
18
2 7
5 17
14 13
9 6
19 14
16 20
13 11
10 18
14 6
7 20
3 19
11 6
1 19
16 8
12 17
3 7
14 16
12 4
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int main()
{
	int tc;
	scanf("%d",&tc);
	for(int t=1;t<=tc;t++)
	{
		int n;
		scanf("%d",&n);
		int x,y,cnt1=0,cnt2=0;
		int p[100000];//parent can be either 1 or 2
		memset(p,0,sizeof(p));
		for(int i=0;i<n;i++)
		{
			scanf("%d%d",&x,&y);
			if(p[x]==0 && p[y]==0)
			{
				p[x]=1;
				p[y]=2;
				cnt1++;
				cnt2++;
			}
			else if(p[x]==0 && p[y]!=0)
			{
				if(p[y]==1)
				{
					p[x]=2;
					cnt2++;
				}
				else
				{
					p[x]=1;
					cnt1++;
				}
			}
			else if(p[x]!=0 && p[y]==0)
			{
				if(p[x]==1)
				{
					p[y]=2;
					cnt2++;
				}
				else
				{
					p[y]=1;
					cnt1++;
				}
			}
			else if(p[x]!=0 && p[y]!=0 && p[x]==p[y])
			{
				if(p[x]==1)
				{
					cnt1--;
					cnt2++;
					p[x]=2;
				}
				else
				{
					cnt1++;
					cnt2--;
					p[x]=1;
				}
			}
		}
		printf("Case %d: %d\n",t,max(cnt1,cnt2));
	}
	return 0;
}