/*input
1 1 5
4 5
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
typedef long double ld;
const ld sq2=1.414213562373095048801688724209698078569671875376948;

//Created by Shreyans Sheth [bholagabbar]

int main()
{
	BoostIO;
	//ReadFile;
	ld i,k,s,ans,a_i,b_i;
	cin>>i>>k>>s>>a_i>>b_i;
	if((ll)i%2==0)
    {
        if(k>=i)
        {
            if((ll)(k-i)%2==0)
                ans=(a_i+b_i)*ceil(pow(16.0,((k-i)/2.0)-(s/4.0)));
            else
                ans=(a_i+b_i)*ceil(pow(16.0,(((k-i)/2.0)-(s/4.0))))*4.0*sq2;
        }
        else
        {
            if((ll)(k-i)%2==0)
                ans=(a_i+b_i)/ceil(pow(16.0,((i-k)/2.0)+(s/4.0)));
            else
                ans=(a_i+b_i)/ceil(pow(16.0,(((i-k)/2.0)+(s/4.0))))*2.0*sq2;
        }
    }
    else
    {
        if(k>=i)
        {
            if((ll)(k-i)%2==0)
                ans=(a_i+b_i)*ceil(pow(16.0,((k-i)/2.0)-(s/4.0)));
            else
                ans=(a_i+b_i)*ceil(pow(16.0,(floor((k-i)/2.0)-(s/4.0))))*2.0*sq2;
        }
        else
        {
            if((ll)(k-i)%2==0)
                ans=(a_i+b_i)/ceil(pow(16.0,((i-k)/2.0)+(s/4.0)));
            else
                ans=(a_i+b_i)/ceil(pow(16.0,(floor((i-k)/2.0)+(s/4.0))))*4.0*sq2;
        }
    }
    printf("%Lf",ans);
	return 0;
}