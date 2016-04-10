
//Shreyans Sheth [bholagabbar]

#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set    //JAVA Feels :')
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define sz 100001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

const ll MOD=1e9+7;

ll C[5001][5001];

void getCombinations(int n, int r)
{ 
    for (int i=0; i<=n; i++)
        for (int k=0; k<=r && k<=i; k++)
            C[i][k] = (k==0 || k==i) ? 1 : (C[i-1][k-1]%MOD + C[i-1][k]%MOD)%MOD;
}

int main()
{
    getCombinations(10,10);
    cout<<C[4][2]<<endl;
    return 0;
}