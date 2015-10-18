/*input
4
1 0.5
2 0.5
3 0.5
4 0.5
*/
#include <bits/stdc++.h>
using namespace std;
#define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define BoostIO ios_base::sync_with_stdio(false)
#define pb emplace_back
#define mp make_pair
#define pii pair<int,int>
#define endl '\n'

typedef long long int ll;
const double ia=1000000000.0;
//Created by Shreyans Sheth [bholagabbar]

int main()
{
	BoostIO;
	//ReadFile;
	int tc;
	cin>>tc;
	while(tc--)
	{
		int m;
		double p;
		cin>>m>>p;
		if(m==1)
		{
			printf("%.2f 0.00\n",ia);
		}
		else if(m==2)
		{
			double f=(p)*ia;
			double c=(1.0-p)*ia;
			printf("%.2f %.2f\n",c,f);
		}
		else if(m==3)
		{
			double f=(p-(p*p*p))*ia;
			double c=(1.0-p+(p*p*p))*ia;
			printf("%.2f %.2f\n",c,f);	
		}
		else 
		{
			cout<<"1\n";
		}
	}
	return 0;
}