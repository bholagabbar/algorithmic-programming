/*input
99 100
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
vector<int> a[100000];

//Created by Shreyans Sheth [bholagabbar]

int BFS(int n,int m)
{
	queue<pii> q;
	bool visited[100001]={0};
	q.push({n,0});//number,times;
	int cnt=0;
	while(!q.empty())
	{
		pii c=q.front();
		q.pop();
		int cv=c.f;
		if(c.f==m)
			return c.s;
		if(!visited[cv])
		{
			visited[cv]=1;
			for(int x:a[cv])
			{
				//cout<<x<<endl;
				q.push({x,c.s+1});
			}
		}
	}
}

int main()
{
	BoostIO;
	//ReadFile;
	ll n,m;
	cin>>n>>m;
	a[1].pb(2);
	for(int i=2;i<10005;i++)
	{
		a[i].pb(i*2);
		a[i].pb(i-1);
	}
	cout<<BFS(n,m);
	return 0;
}