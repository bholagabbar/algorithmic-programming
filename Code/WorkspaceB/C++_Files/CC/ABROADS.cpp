/*input
3 3 6
1 2 3
1 2
2 3
3 1
P 1 3
D 1
P 2 3
D 2
P 3 10
D 3
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
#define N 500001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;


int n, m, q;
int arr[N];
int v1[N];
int v2[N];
int d[N];
int p[N];
int a[N];
int beforePop[N];
int dsu[N];
ll sz[N];
bool roadUsed[N];
char type[N];
ll ans[N];

multiset <ll > cur;

int FIND(int node)
{
    if(dsu[node] != dsu[dsu[node]])
        dsu[node] = FIND(dsu[node]);
    return dsu[node];
}

void UNION(int a, int b)
{
    int px = FIND(a);
    int py = FIND(b);
    if(px != py)
    {
        cur.erase(cur.find(sz[px]));
        cur.erase(cur.find(sz[py]));
        sz[px] += sz[py];
        cur.insert(sz[px]);
        dsu[py] = px;
    }
}

int main()
{
    boostIO;
    cin>>n>>m>>q;
    for(int i = 1; i <= n; i++)
    {
        cin>>arr[i];
        sz[i] = arr[i];
        dsu[i] = i;
    }
    for(int i = 1; i <= m; i++)
    {
        cin>>v1[i]>>v2[i];
        roadUsed[i] = 1;
    }
    for(int i = 1; i <= q; i++)
    {
        cin>>type[i];
        if(type[i] == 'D')
        {
            cin>>p[i];
            roadUsed[p[i]] = 0;
        }
        else
        {
            cin>>a[i]>>p[i];
            beforePop[i] = sz[a[i]];
            sz[a[i]] = p[i];
        }
    }
    for(int i = 1; i <= n; i++)
    {
        cur.insert(sz[i]);
    }
    for(int i = 1; i <= m; i++)
        if(roadUsed[i])
            UNION(v1[i] , v2[i]);
    
    for(int i = q; i >= 1; --i)
    {
        ans[i] = *cur.rbegin();
        if(type[i] == 'D')
            UNION(v1[p[i]] , v2[p[i]]);
        else
        {
            int parentA=FIND(a[i]);
            cur.erase(cur.find(sz[parentA]));
            sz[parentA] += beforePop[i] - p[i]; //add the difference of the population to the region
            cur.insert(sz[parentA]);
        }
    }
    for(int i = 1; i <= q; i++)
        cout<<ans[i]<<endl;
    return 0;
}