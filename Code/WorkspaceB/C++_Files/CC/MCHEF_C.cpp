#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define sz 100005

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int st[sz<<2];
int lazy [sz<<2];
long arr[sz];
long long dp[sz][507];
 
//Solving using SegTrees and Lazy Prop.
//FINALLY AC!!!! Muahahahahahahah

void Initialize(int n)
{
    for(long i=0;i<n<<2;i++)
    {
    	st[i]=INT_MAX;
    	lazy[i]=0;
    }
}
 
void UpdateSt(int node,int a,int b,int i,int j,int value)//finding in range i,j
{
    if (a>j || b<i)
		return ;

	//propogating lazy values
	if (lazy[node]!=0)
	{
	    st[node]=min(lazy[node],st[node]);
	    if (a!=b)
	    {
	        if (lazy[node*2]!=0)
	            lazy[node*2] = min(lazy[node*2], lazy[node]);
	        else
	            lazy[node*2] = lazy[node];

	        if (lazy[node*2+1]!=0)
	            lazy[node*2+1] = min(lazy[node*2+1], lazy[node]);
	        else
	            lazy[node*2+1] = lazy[node];
	    }
	    lazy[node]=0;
	}
	
	if(a>=i && b<=j)
	{
		//checking current value
        st[node] = min(st[node], value);
        if (a!=b)
        {
            if (lazy[node*2]!=0)
                lazy[node*2] = min(lazy[node*2], value);
            else
                lazy[node*2] = value;

            if (lazy[node*2+1]!=0)
                lazy[node*2+1] = min(lazy[node*2+1], value);
            else
                lazy[node*2+1] = value;
        }
        return;
	}
	UpdateSt(node*2,a,(a+b)>>1,i,j,value);
	UpdateSt(node*2+1,((a+b)>>1)+1,b,i,j,value);
    st[node] = min(st[node*2], st[node*2+1]);
}
 
int RMINQ(int node,int a,int b,int i, int j)//updating in range i,j
{
	if (a>b||a>i||b<j)
        return INT_MAX;

    if (lazy[node]!=0)
    {
        st[node] = min(st[node], lazy[node]);
        if (a!=b)
        {
            if (lazy[node*2]!=0)
                lazy[node*2] = min(lazy[node*2], lazy[node]);
            else
                lazy[node*2] = lazy[node];
            if (lazy[node*2+1]!=0)
                lazy[node*2+1] = min(lazy[node*2+1], lazy[node]);
            else
                lazy[node*2+1] = lazy[node];
        }
        lazy[node]=0;
    }

    if(a>=i && b<=j)
        return st[node];

    return min(RMINQ(node*2,a,(a+b)>>1,i,j), RMINQ(node*2+1,((a+b)>>1)+1,b,i,j));
}
 
int main()
{
	ios_base::sync_with_stdio(false);
	int tc;
	cin>>tc;
	while(tc--)
	{
		int n,k,m;
		cin>>n>>k>>m;
		Initialize(n);
		long long sum=0;
		vector<int>neg;
		for(int i=1;i<=n;i++)
		{
			cin>>arr[i];
			sum+=arr[i];
			if(arr[i]<0)
			{
				neg.emplace_back(i);
			}
		}
		int a,b,c;
		for(int i=0;i<m;i++)
		{
			cin>>a>>b>>c;
			UpdateSt(1,1,n,a,b,c);
		}
		vector<long> value;
		vector<int> weight;
		for(auto i:neg)
		{
			int x=RMINQ(1,1,n,i,i);
			if(x!=INT_MAX)
			{
				value.emplace_back(abs(arr[i]));
				weight.emplace_back(x);
			}
		}
		for(int i=1;i<=value.size();i++)
		{
			for(int j=1;j<=k;j++)
			{
				dp[i][j]=dp[i-1][j];
				
				if(weight[i-1]<=j)
				{
					dp[i][j]=max(dp[i][j],value[i-1]+dp[i-1][j-weight[i-1]]);
				}
			}
		}
		sum+=dp[value.size()][k];
		cout<<sum<<endl;
	}
	return 0;
}