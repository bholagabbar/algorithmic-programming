/*input
81
85
155
99999
0
*/
#include <iostream>
#include <math.h>
using namespace std;
#define endl '\n'
#define size 1000006

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

bool prime[size];

void SIEVE()
{
	prime[0]=prime[1]=false;
	for(int i=2;i<size;i++)
	{
		prime[i]=true;
	}

	for(int i=2;i<sqrt(size);i++)
	{
		if(prime[i])
		{
			for(int j=2*i;j<size;j+=i)
			{
				prime[j]=false;
			}
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	SIEVE();
	int n;
	cin>>n;
	while(n!=0)
	{
		int flag=0;
		for(int j=2;j<=sqrt(n);j++)
		{
			for(int k=2;k<=cbrt(n);k++)
			{
				if(prime[j]&&prime[k])
				{
					unsigned long long b=j*j,c=k*k*k;
					if(b+c<n)
					{
						unsigned long long a=n-b-c;
						if(a+b+c==n && prime[a])
						{
							cout<<a<<" "<<j<<" "<<k<<endl;
							flag=1;
							goto nxt;
						}
					}
				}
			}
		}
		nxt:if(flag==0)
		{
			cout<<"0 0 0\n";
		}
		cin>>n;
	}	
	return 0;
}