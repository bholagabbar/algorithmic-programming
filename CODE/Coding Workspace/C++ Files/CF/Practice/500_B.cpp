#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostCC ios_base::sync_with_stdio(false)
#define pb emplace_back
#define mp make_pair
#define hashset unordered_set
#define hashmap unordered_map
#define pii pair<int,int>
#define endl '\n'

typedef long long int ll;
typedef long double ld;

//Created by Shreyans Sheth [bholagabbar]

vector<int> a[500];
int arr[500];
bool vis[500]={0};

void BFSandMake(int x)
{
	queue<int> q;
	q.push(x);
	vis[x]=1;
	set<int> cc;//Connected Components
	while(!q.empty())
	{
		int c=q.front();
		q.pop();
		cc.insert(c);
		for(auto i:a[c])
			if(!vis[i])
			{
				vis[i]=1;
				q.push(i);
			}
	}
	int cnt=0;
	int temp[cc.size()];
	for(auto i:cc)
		temp[cnt++]=arr[i];
	sort(temp,temp+cc.size());
	cnt=0;
	for(auto i:cc)//sorted numbers as possible
		arr[i]=temp[cnt++];
}


int main()
{
	//ReadFile;
	BoostCC;
	int n;
	cin>>n;
	for(int i=1;i<=n;i++)
		cin>>arr[i];
	for(int i=1;i<=n;i++)
	{
		string s;
		cin>>s;
		for(int j=1;j<=n;j++)
			if(s[j-1]=='1')
				a[i].pb(j);
	}
	for(int i=1;i<=n;i++)//Getting Con.Comp. and making the arr entries as sorted as possible
		if(!vis[i])
			BFSandMake(i);
	for(int i=1;i<=n;i++)
		cout<<arr[i]<<" ";
	return 0;
}