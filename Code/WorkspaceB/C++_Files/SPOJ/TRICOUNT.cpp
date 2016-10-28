#include <bits/stdc++.h>
using namespace std;

//Shreyans Sheth [bholagabbar]
typedef long long int ll;
int main()
{
	//readFile
	//boostIO;
	int tc;
	cin>>tc;
	while(tc--){
		ll n;
		cin>>n;
		ll ans=(n*(n+2)*(2*n+1))/8;
		cout<<ans<<endl;
	}	
	
	return 0;
}