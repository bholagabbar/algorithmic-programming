//Created by Shreyans Sheth [bholagabbar] using Sublime 3

#include <bits/stdc++.h>
using namespace std;
//MACROS
#define endl '\n'
#define cout cout.flush()

int main()
{
	ios_base::sync_with_stdio(false);cin.tie(NULL);//FAST IO
	string a;
	cin>>a;
	if(a.size()<5)
	{
		cout<<"NO";
	}	
	else
	{
		int b=0,s=0,n=0;
		for(int i=0;i<a.size();i++)
		{
			if(a.at(i)>=97&&a.at(i)<=122)
			{
				s++;
			}
			else if(a.at(i)>=65&&a.at(i)<=90)
			{
				b++;
			}
			else if(a.at(i)>=48&&a.at(i)<=57)
			{
				n++;
			}
		}
		if(b>0&&s>0&&n>0)
		{
			cout<<"YES";
		}
		else
		{
			cout<<"NO";
		}
	}
	return 0;
}