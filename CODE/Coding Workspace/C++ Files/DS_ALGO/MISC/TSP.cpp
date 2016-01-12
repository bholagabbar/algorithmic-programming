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

int dist[3][3];
const int INF = 1e6;

string toBinary(int a)
{
    string binary = "";
    int mask = 1;
    for(int i = 0; i < 3; i++)
    {
        if((mask&a) >= 1)
            binary = "1"+binary;
        else
            binary = "0"+binary;
        mask<<=1;
    }
    //cout<<binary<<endl;
    return binary;
}

int shortestTSPdistance(int n)
{
    int lim = 1 << n;  
    int dp[lim][n];  
    for(int i=0;i<lim;i++)
        for(int j=0;j<n;j++)
            dp[i][j]=INF;
    for (int i = 0; i < n; i++)  
        dp[1 << i][i] = 0; // base case of visiting just 1 city  
    for (int mask = 0; mask < lim; mask++)
        for (int last = 0; last < n; last++)
        {
            if (mask && (1 << last) == 0)
                continue; 
            for (int curr = 0; curr < n; curr++)
            {
                if (mask && (1 << curr) == 0)
                    continue;
                int otherMask = mask ^ (1 << curr);  
                dp[mask][curr] = min(dp[mask][curr], dp[otherMask][last] + dist[last][curr]);  
                cout<<"Last ="<<last<<" Curr= "<<curr<<" Mask= "<<toBinary(mask)<<" Other mask= "<<toBinary(otherMask)<<" DP="<<dp[mask][curr]<<endl;
            }
        }
    int ans = INF;  
    for (int i = 0; i < n; i++)
        ans = min(ans, dp[lim - 1][i]);  
    return ans;  
}

int main()
{
    //boostIO;
    int n=3;
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++){
            dist[i][j]=dist[j][i]=i;
            if(i==j)
                dist[i][j]=dist[j][i]=0;
        }
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++)
            cout<<dist[i][j]<<" ";
        cout<<endl;
    }
    cout<<shortestTSPdistance(n);
    return 0;
}