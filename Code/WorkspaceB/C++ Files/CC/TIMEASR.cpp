#include <bits/stdc++.h>
using namespace std;

vector<pair<double,pair<int,int>>> v;

void preCompute()
{
	double hadd=0,min=0;
	for(int i=0;i<12;i++)
	{
		for(int j=0;j<60;j++)
		{
			double kurt_angle=abs(min-(0.5*(double)j));
			if(kurt_angle>180)
				kurt_angle=360-kurt_angle;
			v.push_back({kurt_angle,{i,j}});
			min+=6;
		}
		min=(hadd-=30);
	}
	sort(v.begin(),v.end());
}


int main()
{
	preCompute();
	int tc;
	cin>>tc;
	while(tc--)
	{
		double n;
		cin>>n;
		int dis=0;
		while((n-v[dis].first)>(1/120.0))
			dis++;
		set<string> s;
		while(dis!= v.size() && (v[dis].first-n)<(double)(1/120.0))
		{
			string hours=to_string(v[dis].second.first);
			string minutes=to_string(v[dis].second.second);
			if(hours.size()<2)
				hours="0"+hours;
			if(minutes.size()<2)
				minutes="0"+minutes;
			string curr_time=hours+":"+minutes;
			s.insert(curr_time);
			dis++;
		}	
		for(auto i:s)
			cout<<i<<"\n";
	}
}