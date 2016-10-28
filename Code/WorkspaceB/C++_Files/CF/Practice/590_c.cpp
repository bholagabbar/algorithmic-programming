#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define CLR(s) memset(&s, 0, sizeof(s))
#define hashset unordered_set
#define hashmap unordered_map
#define pii pair<int,int>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define MOD 1000000007
#define endl '\n'
#define sz 100005

typedef long long int ll;
typedef long double ld;

//Created by Shreyans Sheth [bholagabbar]

bool leaf[sz]={0};
int cats[sz]={0};
vector<int> a[sz];
bool vis[sz]={0};
int m;
int maxcon[sz]={0};
int icnt[sz]={0};

class node
{
public:
	int curr, p, ncat;
	bool cc;//Consecutive cat
	node(int curr, int p, int cat, bool cc)
	{
		this->curr=curr;
		this->p=p;
		this->ncat=cat;
		this->cc=cc;
	}
	node(int curr, int p)
	{
		this->curr=curr;
		this->p=p;
	}
};

int BFS()
{
	queue<node> q;
	node s(1,1,cats[1],1);
	q.push(s);
	vis[1]=1;
	int cnt=0;
	while(!q.empty())
	{
		node cur=q.front();
		q.pop();
		int v=cur.curr;
		int cat=cur.ncat;
		bool consec=cur.cc;
		maxcon[v]=max(cat,maxcon[cur.p]);
		//cout<<"current "<<v<<" parent "<<cur.p<<" cats "<<cat<<" Consecutive? "<<consec<<" Final Max "<<maxcon[v]<<endl;
		if(v!=1 && leaf[v] && maxcon[v]<=m)
			cnt++;
		for(auto i:a[v])
			if(!vis[i])
			{
				node ns(i,v);
				if(consec)
				{
					if(cats[i]==0)
					{
						ns.cc=false;
						ns.ncat=0;
					}
					else
					{
						ns.cc=true;
						ns.ncat=cat+cats[i];
					}
				}
				else
				{
					if(cats[i]==1)
					{
						ns.cc=true;
						ns.ncat=cats[i];
					}
					else
					{
						ns.cc=false;
						ns.ncat=0;
					}
				}
				vis[i]=1;
				q.push(ns);
			}
	}
	return cnt;
}

int main()
{
	//ReadFile;
	BoostIO;
	int n;
	cin>>n>>m;
	for(int i=1;i<=n;i++)
	{
		int x;
		cin>>x;
		if(x==1)
			cats[i]=1;
	}
	for(int i=1;i<n;i++)
	{
		int x,y;
		cin>>x>>y;
		a[x].pb(y);
		a[y].pb(x);
	}
	for(int i=1;i<=n;i++)
		if(a[i].size()==1)
			leaf[i]=1;
	cout<<BFS()<<endl;
	return 0;
}