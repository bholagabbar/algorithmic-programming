/*input
7 5 0
Q 7
S 1 7 1
Q 3
S 1 3 1
Q 3
*/
#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;

//Created by Shreyans Sheth [bholagabbar]

ll BIT[1000005];
int N;
 
void BuildBIT(ll c)
{
	fill_n(BIT,N,0); 
	for(int i=1;i<=N;i++)
	{
		ll value=c;
		int k=i;
		while(k<=N)
		{
			BIT[k]+=value;
			k+=(k & (-k));
		}
	}
}

ll QueryBIT(int b)	
{
	ll sum = 0;
	while(b>0)
	{
		sum+=BIT[b];
		b-= (b & (-b));
	}
	return sum;
}

void UpdateBIT(int k, ll v) 
{
	while(k<=N)
	{
		BIT[k] += v;
		k+=(k & (-k));
	}	
}

void RangeUpdateBIT(int i, int j, ll v)	//Range Updates, Point Queries
{
	UpdateBIT(i, v);
	UpdateBIT(j+1, -v);
}
 
int main()
{
    int m,u,v;
    ll c,x;
    char ch[2];
    fill_n(BIT,N,0); 
    scanf("%d%d%lld",&N,&m,&c);
    while(m--)
    {
    	scanf("%s",&ch);
    	if(ch[0]=='Q')
    	{
    		scanf("%d",&u);
    		printf("%lld\n",QueryBIT(u)+c);
    	}
    	else
    	{
    		scanf("%d%d%lld",&u,&v,&x);
    		RangeUpdateBIT(u,v,x);
    	}
    }
	return 0;
}  