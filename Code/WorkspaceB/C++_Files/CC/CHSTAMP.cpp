//Shreyans Sheth [bholagabbar]

#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set	//JAVA Feels :')
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define sz 100001
#define F first
#define S second
#define endl '\n'

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

const int lim=50000;
int cnt [lim+1];
int mx [lim+1];
class Comparator
{
public:
    bool operator() (const int &a, const int &b) const
    {
        return (mx[a] > mx[b]) || (mx[a] == mx[b] && a > b);
    }
};
set<pii> off[lim+1];
set<int, Comparator> bestOfferForDay;
set<int> offersforDay[50001];

int main()
{
    int tc,temp,n,m,d,a,b;
    cin>>tc;
    while(tc--)
    {
        for (int i=1; i<=lim; i++)
        {
            off[i].clear();
            offersforDay[i].clear();
            mx[i] = i;
            cnt[i]=0;
        }
        cin>>n>>m;
        for (int i=0; i<n; i++)
        {
            cin>>temp;
            cnt[temp]++;
        }
        for (int i=0; i<m; i++)
        {
            cin>>temp>>a>>b;
           	int a1=min(a,b),b1=max(a,b);
            off[temp].insert({a1,b1});
        }
        for (int i=lim; i>=0; i--)
        	if(off[i].size()>0)
        	{
        		bestOfferForDay.clear();
        		for(auto j:off[i])
        			if(j.F != j.S)
        			{
        				bestOfferForDay.insert(j.F);
        				bestOfferForDay.insert(j.S);
        				offersforDay[j.F].insert(j.S);
        				offersforDay[j.S].insert(j.F);
        			}
        		while(bestOfferForDay.size()>0)
        		{
        			int start=*bestOfferForDay.begin();
        			bestOfferForDay.erase(start);
        			for(auto j:offersforDay[start])
        				if(bestOfferForDay.find(j)!=bestOfferForDay.end())
        				{
        					bestOfferForDay.erase(j);
        					mx[j]=mx[start];
        					bestOfferForDay.insert(j);
        				}
        			offersforDay[start].clear();
        		}
        	}
        	ll sum=0;
        	for(int i=0;i<=lim;i++)
        		sum+=mx[i]*cnt[i];
        	cout<<sum<<endl;
    }
    return 0;
}