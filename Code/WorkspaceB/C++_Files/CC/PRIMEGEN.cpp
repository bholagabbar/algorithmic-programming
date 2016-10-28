#include <bits/stdc++.h>
#include <fstream>
#define endl '\n'
using namespace std;
int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	ifstream infile;
	infile.open("pr.txt");
	string x;
	while(!infile.eof())
	{
		infile>>x;
		cout<<x;
		x="";
	}
	infile.close();
	ofstream outfile;
	//outfile.open("store.txt");
	//outfile<<cx;
	//outfile.close();
	//cout<<x;
	return 0;
}