#include <iostream>
#include <math.h>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(false);cin.tie(0);//FAST IO
	int t;
	cin>>t;
	while(t--)	
	{
		long n;
		cin>>n;
		string s;
		while(n>0)
		{
			long temp=n%2;
			s+=(char)(temp+48);
			n=n/2; 
		}
		int cnt=0;
		int i=0;
		while(s.at(i)=='0')
		{
			i++;
		}
		cout<<i<<"\n";
	}
	return 0;
}
