/*input
5
-1
1
2
1
-1
*/
#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define pb emplace_back
#define mp make_pair
#define f first
#define s second
#define pii pair<int,int>
#define endl '\n'

typedef long long int ll;

//Created by Shreyans Sheth [bholagabbar]

vector<int> a[2005];
unordered_set<int> hs;

int BFS(int s)
{
	bool visited[2005]={0};
	queue<pii> q;
	q.push(mp(s,0));
	int mx=-1;
	while(!q.empty())
	{
		int cv=q.front().f;
		int runs=q.front().s;
		mx=std::max(mx,runs);
		q.pop();
		if(!visited[cv])
		{
			visited[cv]=1;
			for(int i:a[cv])
				q.push(mp(i,runs+1));
		}
	}
	hs.insert(mx);
}


int main()
{
	BoostIO;
	//ReadFile;
	int n;
	cin>>n;
	for(int i=1;i<=n;i++)
	{
		int x;
		cin>>x;
		if(x!=-1)
			a[x].pb(i);
	}
	for(int i=1;i<=n;i++)
		BFS(i);
	cout<<hs.size();
	return 0;
}