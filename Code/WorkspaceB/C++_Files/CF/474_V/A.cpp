/*input
R
s;;upimrrfod;pbr
*/
#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	char c;
	cin>>c;
	map<char,char> R;
	map<char,char> L;
	string x1="qwertyuiop";
	string x2="asdfghjkl;";
	string x3="zxcvbnm,./";
	for(int i=1;i<x1.size();i++)//keyboard shifted right
	{
		R[x1[i]]=x1[i-1];
		//cout<<x1[i]<<" "<<x1[i-1]<<endl;
	}
	for(int i=1;i<x2.size();i++)//keyboard shifted right
	{
		R[x2[i]]=x2[i-1];
		//cout<<x1[i]<<" "<<x1[i-1]<<endl;
	}
	for(int i=1;i<x3.size();i++)//keyboard shifted right
	{
		R[x3[i]]=x3[i-1];
		//cout<<x1[i]<<" "<<x1[i-1]<<endl;
	}
	R['a']='a';
	R['q']='q';
	R['z']='z';
	for(int i=0;i<x1.size()-1;i++)
	{
		L[x1[i]]=x1[i+1];
	}
	for(int i=0;i<x2.size()-1;i++)
	{
		L[x2[i]]=x2[i+1];
	}
	for(int i=0;i<x3.size()-1;i++)
	{
		L[x3[i]]=x3[i+1];
	}
	L['p']='p';
	L[';']=';';
	L['/']='/';
	string ip;
	cin>>ip;
	if(c=='R')
	{
		for(int i=0;i<ip.size();i++)
			cout<<R[ip[i]];
	}
	else
	{
		for(int i=0;i<ip.size();i++)
			cout<<L[ip[i]];	
	}
	return 0;
}