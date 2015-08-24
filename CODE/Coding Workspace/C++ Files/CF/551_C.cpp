/*input
3 2
1 0 2
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar]

typedef long long int ll;

vector <ll> a;
ll ss;

int BinarySearch()
{
	vector <ll> b=a; //copy
	ll lo=2;
	ll hi=accumulate(a.begin(),a.end(),0)+a.size();
	int findex=a.size()-1;
	for(int i=a.size()-1;i>=0;i--) //finding last non zero endex to reach
	{
		if(a[i]!=0)
		{
			findex=i;//HAS to reach here
			break;
		}
	}
	int cnt=0;
	while(lo<hi)
	{
		ll x= lo+ (hi-lo)/2;//BS for minimum time
		x=x-(findex+1); //Since time needed has to be atleast (last non zro box index(0 indexing)+1)
		if(x<=0)
			break;
		int p=0;
		

		ll load=0,stud=1;
		for(int i=0;i<=findex;i++)
		{
			if(load+a[i]+1>x)
			{
				load=a[i]+(i+1);
				stud++;
			}
			else
			{
				load+=a[i]+(i+1);//Carrying on seconds. Since second guy will have to walk as much as first gut atleast
			}
		}
		cout<<x<<" "<<stud<<endl;

		cnt++;
		if(cnt>20)
			break;

		if(stud<=ss)
			hi=x;
		else
			lo=x+1;
	}
	return lo;
}


int main()
{
	ios_base::sync_with_stdio(false);
    //freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
    int n;
    cin>>n>>ss;
    for(int i=0;i<n;i++)
    {
    	ll x;
    	cin>>x;
    	a.push_back(x);
    }
    cout<<BinarySearch();
	return 0;
}