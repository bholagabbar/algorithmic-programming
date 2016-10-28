/*input
5
2
7
11
8
*/
#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define endl '\n'
#define N 10001
typedef long long int ll;

//Created by Shreyans Sheth [bholagabbar]

bool p[N];

void Sieve()
{
	for (int i=2; i<= N; i++)
        p[i] = 1;
    for (int i=2;i*i<= N; i++) 
        if (p[i]) 
            for (int j = i*i;j<=N; j += i) 
                p[j] = 0;   
}
int main()
{
	BoostIO;
	//ReadFile;
	int tc,x;
	Sieve();
	cin>>tc;
	while(tc--)
	{
		unordered_set<int>hs;
		cin>>x;
		if(x<5)
			cout<<"0\n";
		else if(x%2==0)
		{
			if(p[((x-2)/2)] || p[x-4])
				cout<<"1\n";
		}
		else
		{
			int cnt=0;
			for(int i=2;i<=sqrt(x);i++)
			{
				if((p[i]&&p[x-2*i])||(p[i]&&p[(x-i)/2]))
				{
					auto it=hs.find(i);
					if(it==hs.end())
					{
						cnt++;
						hs.insert(i);
					}
				}
			}
			cout<<cnt<<endl;
		}
	}
	return 0;
}