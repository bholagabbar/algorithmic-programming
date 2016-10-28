/*input
4
1 1 1 1 1
2 1 1 1 1
3 1 2 3 4
4 2 3 4 1
*/
#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar]

typedef long long int ll;
const ll mod=1000000;
const ll mc=1000005;
ll s[3000005];
int cnt[mc];

int main()
{
	ios_base::sync_with_stdio(false);
    //ReadFile;
 	int tc;
 	cin>>tc;
 	while(tc--)
 	{
 		ll n,a,b,c,d;
 		cin>>n>>a>>b>>c>>d;
 		s[0]=d;
 		for(int i=1;i<n;i++)
 			s[i]=((s[i-1]*s[i-1]*a)+(s[i-1]*b)+c)%mod;
 		memset(cnt,0,sizeof(cnt));
 		for(int i=0;i<n;i++)
 			cnt[s[i]]++;
 		ll sum=0,cur=0;
 		for(int i=0;i<mc;i++)
 		{
 			if(cur%2==0)
 				sum+=(cnt[i]%2*i);
 			else
 				sum-=(cnt[i]%2*i);
 			cur+=cnt[i];
 		}
 		cout<<abs(sum)<<endl;
 	}
	return 0;
}