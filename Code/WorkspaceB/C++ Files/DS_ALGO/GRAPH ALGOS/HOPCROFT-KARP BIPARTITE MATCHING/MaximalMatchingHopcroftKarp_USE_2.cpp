#include <bits/stdc++.h>
using namespace std;
#define sz 100001

int n,m; //Vertices on left, right
vector<int> adj[sz]; //typically, for left (adjLeft)

namespace HopcroftKarp //Maximal Matching using Hopcroft Karp
{
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
                for (int v:adj[u])
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
            for (int v: adj[u])
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

    int MaximalMatching()
    {
        for (int u=0; u<=n; u++)
            pairU[u] = 0;
        //Adjust 'm' (vertices on right) accordingly
        m=n;
        for (int v=0; v<=m; v++)
            pairV[v] = 0;
        int maxMatching = 0;

        while (maxMatchBfs())
            for (int u=1; u<=n; u++)
                if (pairU[u]==0 && maxMatchDfs(u))
                    maxMatching++;
        return maxMatching;
    }
}

void addEdge(int u, int v)
{
    adj[u].push_back(v);
}

int main()
{
    m=10, n=9;
    addEdge(9 ,10);
    int maxMatching=HopcroftKarp::MaximalMatching();
    cout << "Size of maximum matching is " <<maxMatching;
    return 0;
}