//Shreyans Sheth [bholagabbar]

#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0),cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set	//JAVA Feels :')
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define sz 10000000
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

inline int scanIntFast()
{
    int num = 0;
    char c = getchar_unlocked();
    bool flag = 0;
    while(!((c>='0' & c<='9') || c == '-'))
        c=getchar_unlocked();
    if(c == '-')
    {
        flag = 1;
        c=getchar_unlocked();
    }
    while(c>='0' && c<='9')
    {
        num = (num<<1)+(num<<3)+c-'0';
        c=getchar_unlocked();
    }
    if(flag==0)
        return num;
    else
        return -1*num;
}

inline ll scanLLFast()
{
    ll num = 0;
    char c = getchar_unlocked();
    bool flag = 0;
    while(!((c>='0' & c<='9') || c == '-'))
        c=getchar_unlocked();
    if(c == '-')
    {
        flag = 1;
        c=getchar_unlocked();
    }
    while(c>='0' && c<='9')
    {
        num = (num<<1)+(num<<3)+c-'0';
        c=getchar_unlocked();
    }
    if(flag==0)
        return num;
    else
        return -1*num;
}

ll prime[sz+1];

void primeFactorSieve()
{
    for(int i=1;i<=sz;i++)
        prime[i]=i;
    for(int i=2;i*i<=sz;i++)
        if(prime[i]==i)
            for(int j=i*i;j<=sz;j+=i)
                prime[j]=i;
}

int main()
{
	primeFactorSieve();
	int tc;
	ll num,res,curr_prime,cnt,final_cnt,partial_res,i;
	tc=scanIntFast();
	while(tc--)
	{
		num=scanLLFast();
		if(num==1)
			res=1;
		while(num!=1)
		{
			curr_prime=prime[num];
			cnt=0;
			while(num>0 && num%curr_prime==0)
				num/=curr_prime, cnt++;
			if(cnt==1)
				res*=(curr_prime*(curr_prime-1)+1);
			else
			{
				final_cnt=(cnt<<1)+1, partial_res=1;
				for(i=0;i<final_cnt;i++)
					partial_res*=curr_prime;
				partial_res+=1;
				partial_res/=(curr_prime+1);
				res*=partial_res;
			}
		}
		printf("%lld\n",res);
		res=1;
	}
	return 0;
}