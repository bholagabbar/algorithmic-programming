#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define pii pair<int,int>
#define mp make_pair
#define f first
#define s second

//Created by Shreyans Sheth [bholagabbar]

int visited[1000005];
int cnt[1000005];
int steps[1000005]; 
int a[1000005];

int main()
{
	ios_base::sync_with_stdio(false);
    //freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
 	int n;
 	cin>>n;
 	int max=-1;
 	for(int i=0;i<n;i++)
 	{
 		cin>>a[i];
 		max=std::max(max,a[i]); //Since we don't want any value greater than max
 	}
 	memset(visited,-1,sizeof(visited));
 	for(int i=0;i<n;i++)
 	{
 		int x=a[i],y=0;
 		queue<pii> q; //for values reachable from a[i]
 		q.push(mp(x,0));
 		while(!q.empty()) //BFS for all values reachable from node
 		{
 			x=q.front().f;
 			y=q.front().s;
 			q.pop();
 			if(visited[x]!=i && x<=max)//nice hack to avoid clearing visited everytime
 			{
 				visited[x]=i;
 				steps[x]+=y; //Steps taken to reach this node from the current node
 				cnt[x]++; //To show that this node has been reached from the current node
 				q.push(mp(2*x,y+1));
 				q.push(mp(x/2,y+1));
 			}
 		}
 	}

 	int ans=INT_MAX;
 	for(int i=0;i<=max;i++)
 		if(cnt[i]==n) // Means that this node has been visited by all elements present in the array
 			ans=min(ans,steps[i]);//minmum steps

 	cout<<ans;
	return 0;
}