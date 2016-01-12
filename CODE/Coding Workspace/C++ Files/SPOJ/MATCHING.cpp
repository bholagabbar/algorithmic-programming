/*input
5 4 6
5 2
1 2
4 3
3 1
2 2
4 4
*/
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
#define sz 100005
#define F first
#define S second
#define endl '\n'
 
typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

//Maximal Matching using Hopcroft Karp

int n,m; //n=vertices on the left, m on the right
vector<int> adjLeft[sz]; //for left
int pairU [sz], pairV[sz], dist[sz];

bool maxMatchBfs()
{
    queue<int> Q;
    for (int u=1; u<=n; u++)
    {
        if (pairU[u]==0)
        {
            dist[u] = 0;
            Q.push(u);
        }
        else
            dist[u] = INT_MAX;
    }
    dist[0] = INT_MAX;
    while (!Q.empty())
    {
        int u = Q.front();
        Q.pop();
        if (dist[u] < dist[0])
            for (int v:adjLeft[u])
                if (dist[pairV[v]] == INT_MAX)
                {
                    dist[pairV[v]] = dist[u]+1;
                    Q.push(pairV[v]);
                }
    }
    return (dist[0] != INT_MAX);
}

bool maxMatchDfs(int u)
{
    if (u != 0)
    {
        for (int v: adjLeft[u])
            if (dist[pairV[v]] == dist[u]+1 && maxMatchDfs(pairV[v]))
            {
                pairV[v] = u;
                pairU[u] = v;
                return true;
            }
        dist[u] = INT_MAX;
        return false;
    }
    return true;
}

int HopcroftKarp()
{
    for (int u=0; u<=n; u++)
        pairU[u] = 0;
    //pairV refers to neighbours of vertices on the right. Adjust m accordingly
    m=2*n;
    for (int v=n+1; v<=m; v++)
        pairV[v] = 0;
    int maxMatching = 0;

    while (maxMatchBfs())
        for (int u=1; u<=n; u++)
            if (pairU[u]==0 && maxMatchDfs(u))
                maxMatching++;
    return maxMatching;
}

//Maximal Matching ends
 
int main()
{
    boostIO;
    int p,a,b;
    cin>>n>>m>>p;
    for(int i=0;i<p;i++)
    {
        cin>>a>>b;
        adjLeft[a].pb(b+n);
    }
    cout<<HopcroftKarp();
    return 0;
}