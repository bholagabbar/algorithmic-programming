/*input
3 3
hi,I'mChuYuXun..YouaresohandsomethatIfallinlovewithyou
butIlovesevenk..you'dbettergoaway
55555555555
ChuYuXun
you
55555555
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int z[5000000];
int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int n,m;
	cin>>n>>m;
	string a[n],x;
	for(int i=0;i<n;i++)
	{
		cin>>a[i];
	}		
	for(int q=0;q<m;q++)
	{
		cin>>x;
		long ans=0;
		for(int j=0;j<n;j++)
		{
			string s=x+"$"+a[j];
			int n1=s.size();
			for(int i=1,l=0,r=0;i<n1;i++)
			{
				z[i]=0;
				if(i<r)
				{
					z[i]=min(r-i+1,z[i-l]);
				}
				while(i+z[i]<n1 && s[i+z[i]]==s[z[i]])
				{
					z[i]++;
				}
				if(i+z[i]-1>r)
				{
					l=i,r=i+z[i]-1;
				}
				if(i>x.size() && z[i]==x.size())
				{
					ans++;
					break;
				}
			}
		}
		cout<<ans<<endl<<endl;
	}

	return 0;
}