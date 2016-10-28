/*input
8 4
1 2 1 2 1 2 1
*/
#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define pii pair<int,int>
#define f first
#define s second
#define mp make_pair
#define endl '\n'

typedef long long int ll;

//Created by Shreyans Sheth [bholagabbar]

int a[100000]={0};
bool visited[100000]={0};

bool BFS(int t)
{
	queue<int> q;
	q.push(1);
	while(!q.empty())
	{
		int cv=q.front();
		q.pop();
		if(cv==t)
			return 1;
		if(!visited[cv])
		{
			visited[cv]=1;
			q.push(cv+a[cv]);
		}
	}
	return 0;
}

int main()
{
	BoostIO;
	//ReadFile;
	int n,t,x;
	cin>>n>>t;
	for(int i=1;i<=n;i++)
	{
		cin>>x;
		a[i]=x;
	}
	if(BFS(t))
		cout<<"YES";
	else
		cout<<"NO";
	return 0;
}