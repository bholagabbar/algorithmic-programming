//Shreyans Sheth [bholagabbar]

#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set	//JAVA Feels :')
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define sz 100001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<ll, ll> pll;
typedef pair<int, double> pid;

bool vis[100001];
double dis[100001];
vector<pid> a[100001];

inline double Dijkstra(int s, int n)
{
    for(int i=0;i<=n;i++)
        vis[i]=0, dis[i]=INT_MIN;
    class prioritize{public: bool operator ()(pid &p1 ,pid &p2){return p1.S<p2.S;}};
    priority_queue<pid, vector<pid>, prioritize> pq;
    pq.push({s,dis[s]=1});
    while(!pq.empty())
    {
        pid cur=pq.top(); pq.pop();
        int cv=cur.F;
        double cw=cur.S;
        vis[cv]=1;
        for(pid x:a[cv])
        	if(!vis[x.F] && cw*x.S!=0 && cw*x.S>dis[x.F])
        	    pq.push({x.F,dis[x.F]=cw*x.S});
    }
    return dis[n]*100.0;
}

int main()
{
	boostIO;
	int n,m,v1,v2;
	double w;
	cin>>n;
	while(n!=0)
	{
	    cin>>m;
	    for(int i=0;i<=n;i++)
	        a[i].clear();
	    for(int i=0;i<m;i++)
	    {
	        cin>>v1>>v2>>w;
	        a[v1].pb({v2,w/100.0});
	        a[v2].pb({v1,w/100.0});
	    }
	    cout<<getPrecision(Dijkstra(1,n),6)<<" percent\n";
	    cin>>n;
	}
	return 0;
}