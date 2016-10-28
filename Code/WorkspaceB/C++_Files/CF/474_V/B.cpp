/*input
5
2 7 3 4 9
3
1 25 11
*/
#include <iostream>
#include <vector>
#define pb push_back
#define endl '\n'
using namespace std;

typedef long long int ll;

int main()
{
	int n;
	cin>>n;
	ll a[n];
	vector<ll> prefix_sum;
	for(int i=0;i<n;i++)
	{
		cin>>a[i];
		if(i==0)
			prefix_sum.pb(a[i]);
		else
			prefix_sum.pb(prefix_sum[i-1]+a[i]);
	}
	int m;
	cin>>m;
	int q;
	for(int i=0;i<m;i++)
	{
		cin>>q;
		auto it=lower_bound(prefix_sum.begin(),prefix_sum.end(),q);
		cout<<(it-prefix_sum.begin()+1)<<endl;
	}
	return 0;
}