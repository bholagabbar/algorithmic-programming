/*input
4 3
1 2 3 4
4 1 4
1 1 3 10
4 1 4
*/
#include <bits/stdc++.h>
using namespace std;
#define size 100005
#define M 1000000007

long long arr[size];
long long st[size<<2];
long long lazyadd [size<<2];
long long lazymul [size<<2];

void initilize(long n)
{
	for(long i=0;i<=4*n;i++)
	{
		lazyadd[i]=0;
		lazymul[i]=1;
	}
}

	void build(int node, int a, int b)
	{
		if(a>b)
			return;
		if(a==b)
		{
			st[node]=arr[a];
			return;
		}

		build(2*node,a,(a+b)>>1);
		build(2*node+1,1+((a+b)>>1), b);
		st[node]=(st[2*node]%M + st[2*node+1]%M)%M;
	}

void add(int node, int a,int b,int i,int j,long long value)
{
	if(lazymul[node]!=1)
	{
		st[node]=(st[node]%M * (b-a+1)*lazymul[node])%M;
		if(a!=b)
		{
			st[2*node]=(lazymul[node]%M * st[2*node]%M)%M;
			st[2*node+1]=(lazymul[node]%M * st[2*node+1]%M)%M;
		}
		lazymul[node]=1;
	}
	
	if(lazyadd[node]!=0)
	{
		st[node]=(st[node]%M + (b-a+1)*lazyadd[node])%M;
		if(a!=b)
		{
			lazyadd[2*node]+=(lazyadd[node]%M) %M;
			lazyadd[2*node+1]+=(lazyadd[node]%M) %M;
		}
		lazyadd[node]=0;
	}

	if(i>b || a>b || j<a)
		return;

	if(a>=i && b<=j)
	{
		st[node]=(st[node]%M + ((b-a+1)*value)%M)%M;
		if(a!=b)
		{
			lazyadd[2*node]=(lazyadd[2*node]%M + value)%M;
			lazyadd[2*node+1]=(lazyadd[2*node+1]%M + value)%M;
		}
		return;
	}

	add(2*node,a,(a+b)>>1,i,j,value);
	add(2*node+1 ,1+((a+b)>>1),b, i,j,value);
	st[node]=(st[2*node]%M + st[2*node+1]%M)%M;
}

void mul(int node, int a,int b,int i,int j,long long value)
{
	if(lazyadd[node]!=0)
	{
		st[node]=(st[node]%M + (b-a+1)*lazyadd[node])%M;
		if(a!=b)
		{
			st[2*node]=(lazyadd[node]%M + st[2*node]%M)%M;
			st[2*node+1]=(lazyadd[node]%M + st[2*node+1]%M)%M;
		}
		lazyadd[node]=0;
	}

	if(lazymul[node]!=1)
	{
		st[node]=(st[node]%M * (b-a+1)*lazymul[node])%M;
		if(a!=b)
		{
			st[2*node]=(lazymul[node]%M * st[2*node]%M)%M;
			st[2*node+1]=(lazymul[node]%M * st[2*node+1]%M)%M;
		}
		lazymul[node]=1;
	}

	if(i>b || a>b || j<a)
		return;

	if(a>=i && b<=j)
	{
		st[node]=(st[node]%M * ((b-a+1)*value)%M)%M;
		if(a!=b)
		{
			lazymul[2*node]=(lazymul[2*node]%M * value%M)%M;
			lazymul[2*node+1]=(lazymul[2*node+1]%M * value%M)%M;
		}
		return;
	}

	mul(2*node,a,(a+b)>>1,i,j,value);
	mul(2*node+1 ,1+((a+b)>>1),b, i,j,value);
	st[node]=(st[2*node]%M + st[2*node+1]%M)%M;
}

long long sum(int node, int a,int b, int i,int j)
{
	if(lazyadd[node]!=0)
	{
		st[node]=(st[node]%M + (b-a+1)*lazyadd[node]%M)%M;
		if(a!=b)
		{
			lazyadd[2*node]+=(lazyadd[node]%M) %M;
			lazyadd[2*node+1]+=(lazyadd[node]%M) %M;
		}
		lazyadd[node]=0;
	}

	if(lazymul[node]!=1)
	{
		st[node]=(st[node]%M * (b-a+1)*lazymul[node]%M)%M;
		if(a!=b)
		{
			st[2*node]=(st[2*node]%M * lazymul[node]%M)%M;
			st[2*node+1]=(st[2*node+1]%M * lazymul[node]%M)%M;
		}
		lazymul[node]=1;
	}

	if(i>b || a>b || j<a)
		return 0;

	if(i<=a && j>=b)
		return st[node];

	return (sum(2*node,a,(a+b)>>1,i,j) + sum(2*node+1,1+((a+b)>>1),b,i,j));
}

int main()
{
	ios_base::sync_with_stdio(false);
	int n,q;
	cin>>n>>q;
	for(int i=1;i<=n;i++)
	{
		cin>>arr[i];
	}
	initilize(n);
	build(1,1,n);
	int t,a,b;
	long long c;
	while(q--)
	{
		cin>>t;
		if(t==1)
		{
			cin>>a>>b>>c;
			add(1,1,n,a,b,c);
		}
		if(t==2)
		{
			cin>>a>>b>>c;
			mul(1,1,n,a,b,c);
		}
		if(t==4)
		{
			cin>>a>>b;
			cout<<sum(1,1,n,a,b)<<endl;
		}
	}
	return 0;
}