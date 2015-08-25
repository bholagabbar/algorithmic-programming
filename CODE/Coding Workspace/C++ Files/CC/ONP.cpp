/*input
1
A*(B+C*D)+E
*/
/*O/P
abc*+
ab+zx+*
at+bac++cd+^*
*/
#include <iostream>
#include <stack>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

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
	ios_base::sync_with_stdio(false);//FAST IO
	int tc;
	cin>>tc;
	while(tc--)
	{
		string x;
		cin>>x;
		stack <char> s;
		for(int i=0;i<x.size();i++)
		{
			if(x[i]!='+' && x[i]!='-' && x[i]!='/' && x[i]!='*' && x[i]!='^' && x[i]!='(' && x[i]!=')')
			{
				cout<<x[i];
			}
			else if(x[i]=='(')
			{
				s.push(x[i]);
			}
			else if(x[i]!=')')
			{
				while(s.size()>0 && priority(s.top()>=priority(x[i])))
				{
					cout<<s.top();
					s.pop();
				}
				s.push(x[i]);
			}
			else if(x[i]==')')
			{
				while(s.top()!='(')
				{
					cout<<s.top();
					s.pop();
				}
				s.pop();
			}
		}
		while(s.size()!=0)
		{
			cout<<s.top();
			s.pop();
		}
		cout<<endl;
	}

	return 0;
}