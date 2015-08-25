#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

int n=100000;
long BIT[n+1];
int a[n];

void BuildBIT(int n)//Remember BIT is 1-based index
{
	fill_n(BIT,n,0); //Initializing it with 0
	for(int i=1;i<=n;i++)
	{
		long value=a[i-1];//Current value to store
		int k=i;//Start index
		while(k<=n)
		{
			BIT[k]+=value;//Adding this value
			k+=(k & (-k))//Updating next index to store
		}
	}
}

void QueryBIT(int r)//Query from 0-r
{
	long ans=0;
	int index=r+1;//Essentially the node at the bottom
	while(index>0)
	{
		ans+=BIT[index];//Adding values from segments along the way
		index-=(index& (-index));//Going up to root
	}
	return ans;
}

void UpdateBIT(int p, int val)//Point update 
{
	int mod_index=p+1;
	while(mod_index<=n)//Affects every index >p
	{
		BIT[mod_index]+=val;
		mod_index+=(mod_index & (-mod_index));
	}
}

void Range_Update(int l,int r,int val)// Use only for range updates, point queries where BIT is initilaized to 0
{
	UpdateBIT(l,val);
	UpdateBIT(r+1,-val);//Since all the values ahead of l are affected, you revert them back
}

int main()
{
	ios_base::sync_with_stdio(false);
	return 0;
}