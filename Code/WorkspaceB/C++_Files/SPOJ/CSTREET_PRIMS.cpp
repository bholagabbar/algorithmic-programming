/*input
1
2
5
7
1 2 1
2 3 2
2 4 6
5 2 1
5 1 3
4 5 2
3 4 3
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
#define sz 100001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

vector<pii> graph[sz];
hashset<int> vis;

inline ll Prims(int n)
{
    int s=rand()%n+1;
    vis.insert(s);
    ll sum=0;
    while(vis.size()!=n)
    {
        int minw=INT_MAX,vert1,vert2;
        for(int i:vis)
            for(pii curr:graph[i])
                if(vis.find(curr.first)==vis.end() && curr.second<minw)
                    vert1=i, vert2=curr.first, minw=curr.second;
        vis.insert(vert2);
        sum+=minw;
    }
    return sum;
}

int main()
{
    boostIO;
    int tc;
    cin>>tc;
    while(tc--)
    {
        ll p;
        cin>>p;
        int n,e;
        cin>>n>>e;
        for(int i=1;i<=n;i++)
            graph[i].clear();
        vis.clear();
        for(int i=0;i<e;i++)
        {
            int v1,v2,w;
            cin>>v1>>v2>>w;
            graph[v1].pb({v2,w});
            graph[v2].pb({v1,w});
        }
        ll ans=Prims(n)*p;
        cout<<ans<<endl;
    }
    return 0;
}
