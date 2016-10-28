/*input
4
ab
aa
aA
AAbaz
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define M 1000000007

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

long long pow(long a, long b, long MOD)
{
    long long x=1,y=a; 
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
 
long long InverseEuler(long n, long MOD)
{
    return pow(n,MOD-2,MOD);
}
 
long long factMOD(long n, long MOD)
{
    long long res = 1; 
    while (n > 0)
    {
        for (int i=2, m=n%MOD; i<=m; i++)
            res = (res * i) % MOD;
        if ((n/=MOD)%2 > 0) 
            res = MOD - res;
    }
    return res;
}

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int tc;
	cin>>tc;
	while(tc--)
	{
		string a;
		cin>>a;
		unordered_map<char,int>hm;
		for(int i=0;i<a.size();i++)
		{
			unordered_map<char,int>::const_iterator it = hm.find (a[i]);
			if(it==hm.end())
			{
				hm.emplace(a[i],1);
			}
			else
			{
				hm[a[i]]++;
			}
		}
		vector <int> reps;
		for(auto x:hm)
		{			
			if(x.second>1)
			{
				reps.emplace_back(x.second);
			}
		}
		long long num=factMOD(a.size(),M);
		for(int x:reps)
		{
			num=(num%M * InverseEuler(factMOD(x,M),M)%M)%M;
		}
		cout<<num%M<<endl;
	}		

	return 0;
}