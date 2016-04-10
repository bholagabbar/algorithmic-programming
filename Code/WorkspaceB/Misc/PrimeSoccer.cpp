#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define boostIO ios_base::sync_with_stdio(false)
#define ld long double
#define ll long long int
#define CLR(s) memset(&s, 0, sizeof(s))
#define scani(s) scanf("%d",&s)
#define scanl(s) scanf("%lld",&s)
#define hashset unordered_set //JAVA feels :')
#define hashmap unordered_map
#define pll pair<ll,ll>
#define pii pair<int,int>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl '\n'

double C[20][20];
bool prime[50];

void Combinations()
{
    for(int i=0;i<=18;i++)
        for(int j=0;j<=i;j++)
        {
            if(j==0 || j==i)
                C[i][j]=1;
            else
                C[i][j]=C[i-1][j-1]+C[i-1][j];
        }
}

void Sieve()
{
    for(int i=0;i<50;i++)
        prime[i]=1;
    prime[0]=prime[1]=0;
    for(int i=2;i<sqrt(50);i++)
        if(prime[i])
            for(int j=i*i;j<50;j+=i)
                prime[j]=0;
}

class PrimeSoccer
{
public:
    double getProbability(int skillOfTeamA, int skillOfTeamB)
    {
        Sieve();
        Combinations();
        double ska=skillOfTeamA*0.01;
        double skb=skillOfTeamB*0.01;
        double pa=0,pb=0;
        for(int i=0;i<=18;i++)
            if(prime[i])
                pa+=pow(ska,i)*pow(1.0-ska,18-i)*C[18][i], pb+=pow(skb,i)*pow(1.0-skb,18-i)*C[18][i];
        double ans=1.0-((1.0-pa)*(1.0-pb));
        return ans;
    }
};

/*int main()

{   PrimeSoccer p;
    printf("%.9f",p.getProbability(12,89));
    return 0;
}*/