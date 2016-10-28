/*input
3
10
4 1 2 3 4
8
1 1
8
8 1 1 1 1 1 1 1 1
*/
#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostCCIO ios_base::sync_with_stdio(false)
#define pb emplace_back
#define mp make_pair
#define hashset unordered_set
#define hashmap unordered_map
#define pii pair<int,int>
#define endl '\n'

typedef long long int ll;

//Created by Shreyans Sheth [bholagabbar]

struct node
{
	int f,s,t;
	node(int f, int s, int t)
	{
		this->f=f;
		this->s=s;
		this->t=t;
	}
};

class comparator
{
public:
	bool operator()(const node &a, const node &b)
	{
		return a.f>b.f;
	}
};

int main()
{
	//BoostCCIO;
	//ReadFile;
	int tc;
	scanf("%d",&tc);
	while(tc--)
	{
		int p,n,x;
		scanf("%d%d",&p,&n);
		priority_queue<node,vector<node>,comparator> pq;
		for(int i=0;i<n;i++)
		{
			scanf("%d",&x);
			node *N=new node(x,x,1);
			pq.push(*N);
		}
		int ans=0;
		for(int i=0;i<p;i++)
		{
			node N=pq.top();
			pq.pop();
			ans=N.f;
            N.t++;
            N.f=N.s*((N.t*(N.t+1))/2);
            pq.push(N);
		}
		printf("%d\n",ans);
	}
	return 0;
}