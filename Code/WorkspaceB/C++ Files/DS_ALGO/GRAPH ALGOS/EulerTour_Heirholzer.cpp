//http://codeforces.com/contest/508/problem/D


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

const int n=251;

map<string, int> inDeg, outDeg;
map<string, bool> vis;
set<string> checkVertices;

map<string, vector<string>> a;
string root;

bool checkEulerAndFindRoot()
{
	int eq=0, inOut=0, Outin=0;
	root= *checkVertices.begin();
	for(string i: checkVertices)
	{
		if(inDeg[i] == outDeg[i])
			eq++;
		else if(inDeg[i] - outDeg[i] ==1)
			inOut++;
		else if(outDeg[i] - inDeg[i] == 1)
		{
			Outin++;
			root =i; //If 1 degree is also odd, we start with odd degree node
		}
	}
	//Condition for euler tour to exist (except for the fact the graph should be connected)

	if((inOut!=1 && Outin!=0) || (Outin!=1 && inOut!=0))
		return false;

	if((inOut+Outin == 2 || inOut+Outin == 0) && inOut+Outin+eq == checkVertices.size())
		return true;

	return false;
}

vector<string> Hierholzer(string start) //Returns euler tour
{
	vector<string> res;
    stack<string> st;
    st.push(start);
    while (!st.empty())
    {
        string curr = st.top();
        if (a[curr].empty())
        {
            res.pb(curr);
            st.pop();
        }
        else
        {
        	st.push(a[curr].back());
            a[curr].pop_back();
        }
    }
    reverse(res.begin(), res.end());
    return res;
}

int main()
{
	boostIO;
	string ss;
	int m;
	cin>>m;
	for(int i=0;i<m;i++)
	{
		cin>>ss;
		string v1,v2;
		v1+=ss[0], v1+=ss[1];
		v2+=ss[1], v2+=ss[2];
		a[v1].pb(v2);
		inDeg[v2]++, outDeg[v1]++, vis[v1]++, vis[v2]++;
		checkVertices.insert(v1);
		checkVertices.insert(v2);
	}

	if(!checkEulerAndFindRoot())
	{
		cout<<"NO\n";
		return 0;
	}

	vector<string> v=Hierholzer(root);
	if(v.size()!=m+1)
		cout<<"NO\n";
	else
	{
		cout<<"YES\n";
		cout<<v[0];
		for(int i=1; i<v.size(); i++)
			cout<<v[i][1];
	}
	return 0;
}