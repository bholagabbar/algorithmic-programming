#include <iostream>
#include <string>
#include <set>
using namespace std;

//Created by Shreyans Sheth [bholagabbar]

int main()
{
	//ReadFile;
	int n;
	cin>>n;
	set<string> hs;
	string x;
	set<string>::iterator it;
	for(int i=0;i<n;i++)	
	{
		cin>>x;
		it=hs.find(x);
		if(it!=hs.end())
		{
			int cnt=1;
			while(it!=hs.end())
				it=hs.find(x=x+std::to_string(cnt++));
			cout<<x<<endl;
			hs.insert(x);
		}
		else
		{
			hs.insert(x);
			cout<<"OK\n";
		}
	}
	return 0;
}