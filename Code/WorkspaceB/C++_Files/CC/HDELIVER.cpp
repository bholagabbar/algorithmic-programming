#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define pb emplace_back

//Created by Shreyans Sheth [bholagabbar]

vector<int> a[105];
bool visited[105];
unordered_map<int,unordered_set<int>> hm;

void BFS(int x, int n)
{
	unordered_set<int>ths;
	fill_n(visited,n+1,0);
	queue<int> q;
	q.push(x);
	visited[x]=true;
	while(!q.empty())
	{
		int z=q.front();
		q.pop();
		ths.insert(z);
		for(auto i:a[z])
            if(!visited[i])
            {
                visited[i]=1;
                q.push(i);
            }
	}
	hm[x]=ths;
}

int main()
{
    //ReadFile;
    int t;
    cin>>t;
    while(t--)
    {
    	int n,m,x,y,q;
    	scanf("%d%d",&n,&m);
    	for(int i=0;i<=n;i++)
    		a[i].clear();
    	hm.clear();
    	for(int i=0;i<m;i++)
    	{
    		scanf("%d%d",&x,&y);
    		a[x].pb(y);
    		a[y].pb(x);
    	}
    	unordered_set<int>::iterator it;
    	unordered_set<int>::iterator it1;
    	unordered_map<int,unordered_set<int>>::iterator it2;
    	cin>>q;
    	while(q--)
    	{
    		int flag=0;
    		scanf("%d%d",&x,&y);
    		it2=hm.find(x);
    		if(it2==hm.end())
    			BFS(x,n);
    		it2=hm.find(y);
    		if(it2==hm.end())
    			BFS(y,n);
    		it=hm[x].find(y);
    		it1=hm[y].find(x);
    		if(it==hm[x].end() && it1==hm[y].end())
    			printf("NO\n");
    		else
    			printf("YO\n");
    	}
    }
	return 0;
}