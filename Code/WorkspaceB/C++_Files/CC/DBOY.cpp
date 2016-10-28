/*input
1
4
1 2 3 4
1 4 5 3
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
 
//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int dp[505][1005];
int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int tc;
	cin>>tc;
	while(tc-->0)
    {
        int n;
        cin>>n;
        int h[n];
        int p[n];
        int max=-1;
        for(int i=0;i<n;i++)
        {
            cin>>h[i];

            if(h[i]>max)
            	max=h[i];
        }

        for(int i=0;i<n;i++)
        {
            cin>>p[i];
        }
        
        int val=2*max;
        int dp[val+1];
        
        dp[0]=0;
        for(int j=1;j<=val;j++)
        {
        	dp[j]=10000000;
        }
        
        for(int j=1;j<=val;j++)
        {
            for(int k=0;k<n;k++)
            {
            	if(p[k]<=j && 1+dp[j-p[k]]<dp[j])
            	{
            	    dp[j]=1+dp[j-p[k]];
            	}
            }
        }
        
        long sum=0;
        for(int i=0;i<n;i++)
        {
        	sum+=dp[2*h[i]];
        }
        cout<<sum<<endl;
    }	
 
	return 0;
} 