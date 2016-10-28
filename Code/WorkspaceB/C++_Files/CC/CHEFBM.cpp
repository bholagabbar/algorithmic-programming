#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define pb emplace_back
#define mp make_pair
#define hashmap unordered_map
#define hashset unordered_set
#define pii pair<int,int>
#define endl '\n'
 
typedef long long int ll;
 
//Created by Shreyans Sheth [bholagabbar]
 
int a[100005];
 
void Initialize(int m)
{
	for(int i=0;i<=m;i++)
		a[i]=i;
}
 
int main()
{
	//BoostIO;
	//ReadFile;
	int n,m,p;
	scanf("%d%d%d",&n,&m,&p);
	vector<int> v[n+1];
	for(int i=0;i<p;i++)
	{
		int x,y;
		scanf("%d%d",&x,&y);
		v[x].pb(y);
	}
	Initialize(m);
	for(int i=1;i<=n;i++)
	{
		for(int j:v[i])//Putting in changes
			a[j]++;
		bool flag=1;
		long int ans=0;
		for(auto it=v[i].rbegin();it!=v[i].rend();it++)//Only changed elements
			if(*it<m && a[*it]>a[*it+1])
			{
				flag=0;
				break;
			}
		if(flag==0)
			printf("-1\n");
		else
			printf("%ld\n",a[m]-a[1]);//Total sum remains same
		for(int j:v[i])//Only replacing indices that changed
			a[j]=j;
	}
	return 0;
}