/*input
6
4 4
3 4
5 4
4 5
4 3
3 1
*/
#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostCC ios_base::sync_with_stdio(false)
#define pb push_back
#define mp make_pair
#define hashset unordered_set
#define hashmap unordered_map
#define pii pair<int,int>
#define f first
#define s second
#define endl '\n'

typedef long long int ll;
typedef long double ld;

//Created by Shreyans Sheth [bholagabbar]

bool vis[1001][1001]={0};
bool grid[1001][1001]={0};

void BFS(int x, int y)
{
    queue<pii> q;
    q.push({x,y});
    vis[x][y]=1;
    while(!q.empty())
    {
    	pii X=q.front();
    	q.pop();
        int cx=X.f;
        int cy=X.s;
        for(int i=1;i<=1000;i++)
        {
        	if(grid[cx][i] && !vis[cx][i] )
        	{
        		q.push({cx,i});
        		vis[cx][i]=1;
        	}
        	if(grid[i][cy] && !vis[i][cy])
        	{
        		q.push({i,cy});
        		vis[i][cy]=1;
        	}
        }
    }
}

int main()
{
	//ReadFile;
	BoostCC;
	int n,cc=0;
	cin>>n;
	vector<pii> a;
	for(int i=0;i<n;i++)
	{
		int x,y;
		cin>>x>>y;
		a.pb({x,y});
		grid[x][y]=1;
	}
	for(int i=0;i<n;i++)
	{
		int cx=a[i].f,cy=a[i].s;
		if(!vis[cx][cy])
		{
			BFS(cx,cy);
			cc++;
		}
	}
	cout<<cc-1;//Connected comps-1
}