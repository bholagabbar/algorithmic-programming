/*input
1
(a+(b*c))
*/
#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define endl '\n'

typedef long long int ll;

//Created by Shreyans Sheth [bholagabbar]

int priority(char x)
{
    if(x=='(' || x==')')
        return 0;
    if(x=='+'|| x=='-')
        return 1;
    if(x=='*' || x=='/')
        return 2;
    return 3;
}

int main()
{
	BoostIO;
	//ReadFile;
	int tc;
	cin>>tc;
	while(tc--)
	{
		string x;
		cin>>x;
		cout<<x<<endl;
		stack<char> s;
		for(int i=0;i<x.size();i++)
		{
			if((x[i]>=65 && x[i]<=90) || (x[i]>=97 && x[i]<=122) ||(x[i]>=48 && x[i]<=57))
				cout<<x[i];
			else if(x[i]=='*' || x[i]=='-' || x[i]=='+' || x[i]=='/' || x[i]=='^' || x[i]=='(')
			{
				while(!s.empty() && priority(x[i])>=priority(s.top()))
				{
					cout<<s.top();
					s.pop();
				}
				s.push(x[i]);
			}
			else if(x[i]==')')
			{
				while(x[i]!='(')
				{
					cout<<s.top();
					s.pop();
				}
				s.pop();
			}
		}
		while(!s.empty())
		{
			cout<<s.top();
			s.pop();
		}
		cout<<endl;
	}
	return 0;
}