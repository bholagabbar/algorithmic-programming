//Shreyans Sheth [bholagabbar]
 
#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set   //JAVA Feels :')
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define sz 201
#define F first
#define S second
#define endl '\n'
 
typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
 
//Maximal Matching begins
 
int n, vis[sz], level[sz], pair1[sz], pair2[sz];
vector<int> adjLeft[sz];
 
bool maxMatchDfs(int u)
{
    vis[u] = true;
    for (int i:adjLeft[u])
        if (pair2[i] == -1 || (!vis[pair2[i]] && level[u] < level[pair2[i]] && maxMatchDfs(pair2[i])))
        {
            pair1[u] = i, pair2[i] = u;
            return true;
        }
    return false;
}
 
int HopcroftKarp()
{
    memset(pair1, -1, sizeof(pair1));
    memset(pair2, -1, sizeof(pair2));
    for (int match = 0; ;)
    {
        queue<int> Q;
        for (int i = 1; i <= n; i++)
        {
            if (pair1[i] == -1)
            {
                level[i] = 0;
                Q.push(i);
            }
            else
                level[i] = -1;
        }
        while (!Q.empty())
        {
            int u = Q.front(); Q.pop();
            for (int i:adjLeft[u])
                if (pair2[i] != -1 && level[pair2[i]] < 0) 
                    level[pair2[i]] = level[u] + 1, Q.push(pair2[i]);
        }
        for (int i=1; i<=n; i++)
            vis[i] = false;
        int d = 0;
        for (int i = 1; i <= n; i++)
            if (pair1[i] == -1 && maxMatchDfs(i))
                d++;
        if (d == 0)
            return match;
        match += d;
    }
}
 
//Maximal Matching ends
 
int main()
{
    boostIO;
    int tc,a,b,m;
    cin>>tc;
    while(tc--)
    {
        cin>>n>>m;
        for(int i=0;i<=n;i++)
            adjLeft[i].clear();
        for(int i=0;i<m;i++)
        {
            cin>>a>>b;
            adjLeft[a].pb(n+b);
        }
        cout<<(n-HopcroftKarp())<<endl;
    }
    return 0;
} 