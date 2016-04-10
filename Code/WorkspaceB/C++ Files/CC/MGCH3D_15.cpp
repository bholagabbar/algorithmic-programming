/*input
10 5
45 70 41
9 1 43
1 68 8
70 76 7
1 19 33
71 70 53
42 54 71
11 13 30
16 63 25
30 24 34
56 61 29 7328
63 32 18 365
37 41 11 2332
36 19 43 7432
68 55 46 6338
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
 
//Created by Shreyans Sheth [bholagabbar]
 
int main()
{
    //ReadFile;
    double n,q,a,b,c,d;
    scanf("%lf%lf",&n,&q);
    //if(q*n*n â�¤ 77777777)
    {
        double x [(int)n];
        double y [(int)n];
        double z [(int)n];
        for(int i=0;i<n;i++)
            scanf("%lf%lf%lf",&x[i],&y[i],&z[i]);
        while(q--)
        {
            scanf("%lf%lf%lf%lf",&a,&b,&c,&d);
            double ans=0;
            for(int i=0;i<n;i++)
                for(int j=i+1;j<n;j++)
                    //if(i!=j)
                        ans+=2*abs(a*(x[i]-x[j])+b*(y[i]-y[j])+c*(z[i]-z[j])+d)/((n*(n-1.0))*sqrt(pow(x[i]-x[j],4)+pow(y[i]-y[j],4)+pow(z[i]-z[j],4)));
            printf("%.6f\n",ans);
        }
    }
    return 0;
} 