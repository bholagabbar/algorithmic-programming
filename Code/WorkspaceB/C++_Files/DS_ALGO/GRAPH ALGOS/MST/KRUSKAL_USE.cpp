
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

class Node
{
public:
    int v1,v2,w;
    Node(int V1,int V2,int W)
    {
        this->v1=V1;
        this->v2=V2;
        this->w=W;
    }
    bool operator<( const Node &e ) const { return e.w < w; }
};

int u[100001];
int r[100001];

inline int FIND(int x) {
    if(u[x]!=u[u[x]]) {
        u[x]=FIND(u[x]);
    }
    return u[x];
}

bool UNION (int x, int y) {
    int px=FIND(x), py=FIND(y);
    if(px==py) {
        return false;
    }
    if(r[px]>r[py]) {
        swap(px,py);
    }
    else if(r[px]==r[py]) {
        r[py]++;
    }
    u[px]=py;
    return true;
}

void initializeDSU(int l) {
    for(int i=1;i<=l;i++) {
        u[i]=i;
        r[i]=1;
    }
}

int main()
{
    int n,m;
    cin>>n>>m;
    vector<Node> edges;
    initializeDSU(n);
    for(int i=0;i<m;i++)
    {
        int x1,y1,w1;
        cin>>x1>>y1>>w1;
        edges.pb(Node(x1,y1,w1));
    }
    sort(edges.begin(),edges.end());
    
    ll sum=0;
    int ecnt=0;

    while(ecnt!=n-1)
    {
        Node cur=edges[edges.size()-1];
        edges.pop_back();
        if(UNION(cur.v1,cur.v2))
        {
            ecnt++;
            sum+=cur.w;
        }
    }
    cout<<sum<<endl;
    return 0;
}