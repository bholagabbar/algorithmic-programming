//Shreyans Sheth [bholagabbar]

#include <bits/stdc++.h>
using namespace std;
#define pb push_back
#define sz 100005

//Maximal Matching begins

int n, vis[sz], level[sz], pair1[sz], pair2[sz];
vector<int> adjLeft[sz];
 
bool maxMatchDfs(int u)
{
    vis[u] = true;
    for (int i:adjLeft[u])
    {
        int v = pair2[i];
        if (v == -1 || (!vis[v] && level[u] < level[v] && maxMatchDfs(v)))
        {
            pair1[u] = i, pair2[i] = u;
            return true;
        }
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
            {
                int v = pair2[i];
                if (v != -1 && level[v] < 0) 
                {
                    level[v] = level[u] + 1;
                    Q.push(v);
                }
            }
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
    //p=edges
    int p,a,b;
    cin>>n>>m>>p;
    for(int i=0;i<p;i++)
    {
        cin>>a>>b;
        adjLeft[a].pb(b);
    }
    cout<<HopcroftKarp();
    return 0;
}