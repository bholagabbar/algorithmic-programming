#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define push_back emplace_back

//Created by Shreyans Sheth [bholagabbar]

//Observation: Add powers only till next. As greater ones won't contribute. Also, m cant be in more tha 1 subset
//Also, there are no similar elements in each computation

vector<long long> p;

void Addpow(long long w,long long m)
{
	p.push_back(1);
	p.push_back(m);
	unsigned long long w1=w;
	while(w1<=m)
	{
		p.push_back(w1);
		w1*=w;
	}
	p.push_back(w1);
}

int main()
{
	ios_base::sync_with_stdio(false);
    //freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
 	long long w,m;
 	cin>>w>>m;
 	if(w==2)
 	{
 		cout<<"YES";
 		return 0;
 	}
 	Addpow(w,m);
 	cout<<endl;
 	unordered_set <long long> s;
 	unordered_set<long long>::iterator it;
 	for(long long i=1;i<(1<<p.size());i++)
 	{
 		unsigned long long sum=0;
 		for(int j=0;j<p.size();j++)
 		{
 			if(((1<<j)&i)>0)
 			{
 				sum+=p[j];
 			}
 		}
 		it=s.find(sum);
 		if(it!=s.end())
 		{
 			cout<<"YES";
 			return 0;
 		}
 		s.insert(sum);
 	}
    cout<<"NO";
	return 0;
}