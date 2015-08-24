#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
 
//Created by Shreyans Sheth [bholagabbar]
 
typedef long long ll;
 
class node
{
public:
	ll a,d,p;
};
 
 
ll sfunt(node a, node b)
{
	return a.d<b.d;
}
 
 
int main()
{
	ios_base::sync_with_stdio(false);
    //freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
    int tc;
    cin>>tc;
    while(tc--)
    {
    	long n,k;
    	cin>>n>>k;
    	map<ll, vector<node>> m;
    	map<ll, vector<node>>::iterator it;
    	
    	for(int i=0;i<n;i++)
    	{
    		node x;
    		cin>>x.a>>x.d>>x.p;
    		m[x.p].emplace_back(x);
    	}
 
    	ll ans=0LL;
    	for(it=m.begin();it!=m.end();it++)
    	{
    		ll ind=it->first;
    		vector <node> v=it->second;
    		sort(v.begin(),v.end(),sfunt);
    		ll occ=-1;
    		for(node y:v)
    		{
    			if(occ==-1)
    			{
    				occ=y.d;
    				ans++;
    			}
    			else if(y.d>=occ)
    			{
    				occ=y.d;
    				ans++;
    			}
    		}
    	}
    	cout<<ans<<endl;
    }    
	return 0;
} 