#include <bits/stdc++.h>
using namespace std;

typedef unsigned long long int ll;

int main()
{
	ios_base::sync_with_stdio(false);
	int tc;
	cin>>tc;
	NXT:while(tc--)
	{
		ll n;
		cin>>n;
		double x=log2(n+1);
		if(x!=0)
		{
			cout<<"-1\n";
			goto NXT;
		}
		else
		{
			ll y=n/2;
			cout<<y<<"\n";
		}
	}    
    
	return 0;
}