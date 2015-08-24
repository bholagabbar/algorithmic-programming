#include <bits/stdc++.h>
#include <math.h>
using namespace std;
#define endl '\n'
#define cout cout.flush()

int main()
{
	ios_base::sync_with_stdio(false);cin.tie(NULL);//FAST IO
	while(t--)
	{

		long long n;
		cin>>n;
		long long j=(long long)sqrt(n);
		long long ans=0;
		for(long long i=1;i<=j;i++)
		{
			if(n%i==0)
			{
				ans+=i;
				if(i!=(n/i))//dont double count square roots
				{
					ans+=(n/i);
				}
			}
		}
		cout<<ans<<endl;
	}
	return 0;
}