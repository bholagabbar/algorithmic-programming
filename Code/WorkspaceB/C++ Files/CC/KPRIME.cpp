#include <bits/stdc++.h>
#define endl '\n'
using namespace std;

bool p[100001];
int size=100000;
void SOE();

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	cin.tie(NULL);
	SOE();
	int a[100001]={0};
	for(int i=2;i<=100000;i++)
	{
		if(p[i])
		{
			a[i]=1;
		}
		else
		{
			for(int j=2;j<=(i/2);j++)
			{
				if((p[j])&&(i%j==0))
				{
					a[i]++;
				}
			}
		}
	}
	int t;
	cin>>t;
	while(t--)
	{
		int l,r,k,ans=0;;
		cin>>l>>r>>k;
		for(int i=l;i<=r;i++)
		{
			if(a[i]==k)
			{
				ans++;
			}
		}
		cout<<ans<<endl;
		cout.flush();
	}
	return 0;

}


void SOE()
{
	fill_n(p,size+1,true);//similar to Arrays.fill
	p[0]=false;
	p[1]=false;
	for(int i=2;i<=sqrt(size);i+=2)
	{
		if(p[i])
		{
			for(int j=2*i;j<=size;j+=i)
			{
				p[j]=false;
			}
		}
	}
}

