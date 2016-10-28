#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define endl '\n'
#define MOD 1000000007
#define size 1000005

typedef long long int ll;

//Created by Shreyans Sheth (bholagabbar)

ll f[size];

void CalculateFib()
{
	f[0]=1;
	f[1]=1;
	for(ll i=2;i<size-2;i++)
		f[i]=(f[i-1]%MOD+f[i-2]%MOD)%MOD;
}

int OnesinBase2(ll x)
{
	int cnt=0;
	while(x>0)
	{
		if(x%2!=0)
			cnt++;
		x/=2;
	}
	return cnt;
}

int main()
{
	ios_base::sync_with_stdio(false);
    //ReadFile;
    CalculateFib();
    int tc;
    cin>>tc;
    while(tc--)
    {
    	ll n,k;
    	cin>>n>>k;
    	int m=OnesinBase2(f[n]);
    	if(m==k)
    		cout<<"CORRECT\n";
    	else
    		cout<<"INCORRECT\n";
    }
    return 0;
}