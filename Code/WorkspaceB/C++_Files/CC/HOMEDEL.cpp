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
 
int dis[250][250];
 
void FloydWarshall(int n)
{
	for(int k=0;k<n;k++)
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(i!=j && i!=k && j!=k && dis[i][k]+dis[k][j]<dis[i][j])
					dis[i][j]=dis[i][k]+dis[k][j];
}
 
int main()
{
	boostIO;
	int n,m,s,g,d;
	cin>>n;
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			cin>>dis[i][j];
	FloydWarshall(n);
	cin>>m;
	while(m--)
	{
		cin>>s>>g>>d;
		cout<<dis[s][g]+dis[g][d]<<" "<<dis[s][g]+dis[g][d]-dis[s][d]<<endl;
	}
	return 0;
}