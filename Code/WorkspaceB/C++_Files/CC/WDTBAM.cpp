#include <bits/stdc++.h>
using namespace std;
 
typedef long long int ll;
 
int main()
{
	ios_base::sync_with_stdio(false);
	int tc;
	cin>>tc;
	while(tc--)
	{
		int n;
		string ans,chef;
		cin>>n>>ans>>chef;
		ll w[n+1];
		for(int i=0;i<=n;i++)
			cin>>w[i];
		ll fans=w[0];
		int end=0;
		if(ans.compare(chef)!=0)
			for(int i=0;i<n;i++)
			{
				if(ans[i]==chef[i])
					fans=max(fans,w[++end]);
			}
		else
			fans=w[n];
		cout<<fans<<"\n";
	}
	return 0;
} 