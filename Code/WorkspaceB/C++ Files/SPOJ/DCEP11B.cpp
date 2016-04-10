#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar]

long long int pow(long long int a, long long int b, long long int MOD)
{
    long long int x=1,y=a; 
    while(b > 0)
    {
        if(b%2 == 1)
        {
            x=(x*y);
            if(x>MOD) x%=MOD;
        }
        y = (y*y);
        if(y>MOD) y%=MOD; 
        b /= 2;
    }
    return x;
}
 
long long int InverseEuler(long n, long MOD)
{
    return pow(n,MOD-2,MOD);
}

int main()
{
	ios_base::sync_with_stdio(false);
    //freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
    int tc;
    cin>>tc;
    while(tc--)
    {
    	long long int n,m;
    	cin>>n>>m;
    	if(n>=m)
    	{
    		cout<<"0\n";
    	}
    	else
    	{
    		long long int x=1;
    		for(long long int i=n+1;i<m;i++)
    		{
    			x=(x%m*i)%m;
    		}
    		long long int ans=-1;
    		ans*=InverseEuler(x,m);
    		ans=((ans%m)+m)%m;
    		cout<<ans<<endl;
    	}
    }
	return 0;
}