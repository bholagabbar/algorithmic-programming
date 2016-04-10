#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define endl '\n'
#define pb emplace_back
#define f first
#define s second
#define mp make_pair

typedef long long int ll;

//Created by Shreyans Sheth [bholagabbar]

int main()
{
    BoostIO;
    //ReadFile;
 	int tc;
 	cin>>tc;
 	while(tc--)
 	{
 		int n;
 		cin>>n;
 		vector<pair<int,int>> pos;
 		vector<pair<int,int>> neg;
 		for(int i=1;i<=n;ic++)
 		{
 			int x;
 			cin>>x;
 			if(x<0)
 				neg.pb(mp(-x,i));
 			else if(x>0)
 				pos.pb(mp(x,i));
 		}
 		int cnt1=0,cnt2=0;
 		ll sum=0;
 		while(cnt1!=pos.size() || cnt2!=neg.size())
 		{
 			while(cnt2!= neg.size() && pos[cnt1].f>=neg[cnt2].f)
 			{
 				pos[cnt1].f-=neg[cnt2].f;
 				sum+=abs(pos[cnt1].s-neg[cnt2].s)*neg[cnt2].f;
 				cnt2++;
 				if(pos[cnt1].f==0)
 				{
 					cnt1++;
 					break;
 				}
 			}
 			while(cnt1!= pos.size() && pos[cnt1].f<neg[cnt2].f)
 			{
 				neg[cnt2].f-=pos[cnt1].f;
 				sum+=abs(pos[cnt1].s-neg[cnt2].s)*pos[cnt1].f;
 				cnt1++;
 				if(neg[cnt2].f==0)
 				{
 					cnt2++;
 					break;
 				}
 			}
 		}
 		cout<<sum<<endl;
 	}
	return 0;
}