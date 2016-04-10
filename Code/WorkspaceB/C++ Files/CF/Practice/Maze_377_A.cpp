/*input
3 4 2
#..#
..#.
#...
*/
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
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

int n, m, k;
char grid [501][501];
bool vis [501][501] = {0};
int dx[4]={1, -1, 0, 0};
int dy[4]={0, 0, 1, -1};

void gridBfs(int sx, int sy)
{
	queue<pii> q;
	vis[sx][sy]=1;
	q.push({sx,sy});
	while(!q.empty()){
		pii curr=q.front(); q.pop();
		int x=curr.F, y=curr.S;
		int cnt=0;
		for(int i=0; i<4; i++) {
			if(x+dx[i]>=1 && x+dx[i] <= n && y+dy[i] >= 1 && y+dy[i] <= m && grid[x+dx[i]][y+dy[i]] == '.' && !vis[x+dx[i]][y+dy[i]]){
				vis[x+dx[i]][y+dy[i]] = true;
				q.push({x+dx[i], y+dy[i]});
				cnt++;
			}
			if(x+dx[i]>=1 && x+dx[i] <= n && y+dy[i] >= 1 && y+dy[i] <= m && grid[x+dx[i]][y+dy[i]] == 'X')
				cnt++;
		}
		cout<<x<<" "<<y<<" "<<cnt<<endl;
		if(k>0 && cnt==1){
			grid[x][y]='X';
			k--;
		}
	}
}

int main()
{
	boostIO;
	cin>>n>>m>>k;
	for(int i=1; i<=n; i++){
		string s;
		cin>>s;
		for(int j=1; j<=m; j++)
			grid[i][j]=s[j-1];
	}
	for(int i=1; i<=n; i++)
		for(int j=1; j<=m; j++)
			if(grid[i][j]=='.' && !vis[i][j]){
				gridBfs(i, j);
			}

	for(int i=1; i<=n; i++){
		for(int j=1; j<=m; j++){
			cout<<grid[i][j];
		}
		cout<<endl;
	}
	return 0;
}