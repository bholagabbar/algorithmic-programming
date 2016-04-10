#include <bits/stdc++.h>
using namespace std;
int main()
{
	ios_base::sync_with_stdio(false);cin.tie(0);//FAST IO
	string a1,b1;
	cin>>a1>>b1;
	int n=a1.size();
    int m=b1.size();
	char a [n+1];
    char b [m+1];
    for (int i = 1; i <=n; i++)
    {
        a[i] = a1.at(i - 1);
    }
    for (int i = 1; i <=m; i++)
    {
        b[i] = b1.at(i - 1);
    }
    int dp[n+1][m+1];
    
    for (int i = 0; i <=n; i++)
    {
        dp[i][0]=0;
    }
    for (int i = 0; i <=m; i++)
    {
        dp[0][i]=0;
    }
    for (int i = 1; i <=n; i++)
    {
        for (int j = 1; j <=m; j++)
        {
            if (a[i] == b[j])
            {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            }
            else
            {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
   	cout<<dp[n][m]<<"\n";
	return 0;
}