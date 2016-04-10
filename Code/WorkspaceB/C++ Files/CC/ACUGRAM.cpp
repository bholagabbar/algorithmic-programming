#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
int main()
{
	int x;
	cin>>x;
	while(x--)
	{
		int n;
		cin>>n;
		string s[n];
		for(int j=0;j<n;j++)
		{
			cin>>s[j];
		}
		sort(s, s+n);
		for(int j=0;j<n;j++)
		{
			if(j!=n-1)
			cout<<s[j]<<endl;
		else
			cout<<s[j];
		}
	}
	return 0;
}