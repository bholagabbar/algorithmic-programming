/*input
1
8 6
0 2 4 26
0 4 8 80
0 4 5 20
1 8 8
0 5 7 14
1 4 8
*/

//HORRIBLE SPOJ
#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define pll pair<long long int,long long int>
#define CLR(s) memset(&s, 0, sizeof(s))
#define hashset unordered_set
#define hashmap unordered_map
#define pii pair<int,int>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl '\n'
#define sz 100005
 
typedef long long int ll;
typedef long double ld;
 
//Created by Shreyans Sheth [bholagabbar]
 
ll BIT1[sz], BIT2[sz];
 
ll QueryBIT(ll* bit, int k)
{
	ll sum=0;
	int index=k;
	while(index>0)
	{
		sum+=bit[index];
		index-=(index&(-index));
	}
	return sum;
}
 
ll rangeQueryBIT(int i, int j)
{
    ll a1=QueryBIT(BIT1,--i)*i - QueryBIT(BIT2,i);
    ll a2=QueryBIT(BIT1,j)*j - QueryBIT(BIT2,j);
    return a2-a1;
}
 
void UpdateBIT(ll* bit, int k, ll val, int n) 
{
	int index=k;
	while(index<=n)
	{
		bit[index]+=val;
		index+=(index &(-index));
	}
}
 
void rangeUpdateBIT(int i, int j, ll v, int n)
{
	UpdateBIT(BIT1, i, v, n);
	UpdateBIT(BIT1, j+1, -v, n);
	UpdateBIT(BIT2, i, v*(i-1), n);
	UpdateBIT(BIT2, j+1, -v*j, n);
}
 
int main()
{
	BoostIO;
	int tc,n,c,p,q,query;
	ll val;
	cin>>tc;
	while(tc--)
	{
		cin>>n>>c;
		CLR(BIT1);
		CLR(BIT2);
		while (c--)
		{
			cin>>query>>p>>q;//1 based queries. Hence no index+1 in BIT
			if(query)
				cout<<rangeQueryBIT(p,q)<<endl;
			else
			{
				cin>>val;
				rangeUpdateBIT(p,q,val,n);
			}
		}
	}
    return 0;
} 
