/*input
5 6
html text/html
htm text/html
png image/png
svg image/svg+xml
txt text/plain
index.html
this.file.has.lots.of.dots.txt
nodotsatall
virus.exe
dont.let.the.png.fool.you
case.matters.TXT
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar]

int main()
{
	ios_base::sync_with_stdio(false);
    //freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
 	int n,q;
 	cin>>n>>q;
 	unordered_map<string,string> m;
 	unordered_map<string,string>::iterator it;
 	for(int i=0;i<n;i++)
 	{
 		string x,y;
 		cin>>x>>y;
 		m[x]=y;
 	}
 	for(int i=0;i<q;i++)
 	{
 		string x;
 		cin>>x;
 		size_t g=x.find_last_of('.');
 		if(g!=string::npos)
 		{
 			string y=x.substr(g+1,x.size()-g);
 			it=m.find(y);
 			if(it==m.end())
 				cout<<"unknown\n";
 			else
 				cout<<m[y]<<endl;
 		}
 		else
 		{
 			cout<<"unknown\n";
 		}
 	}
	return 0;
}