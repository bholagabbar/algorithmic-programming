//Shreyans Sheth [bholagabbar]

#include <bits/stdc++.h>
#define read_file freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define boost_IO ios_base::sync_with_stdio(0), cin.tie(0)
#define get_precision(s,p) fixed<<setprecision(p)<<s
#define CLR(s) memset(&s, 0, sizeof s)
#define hash_set unordered_set    //JAVA Feels :')
#define hash_map unordered_map
#define PB push_back
#define MP make_pair
#define F first
#define S second
#define endl '\n'

using namespace std;

typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

static const ll MOD=1e9+7;
static const int sz=1e5+1;

ll dp[2001][2001][5];

int main()
{
    boost_IO;
    int n;
    cin>>n;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin>>dp[i][j][0];
        }
    }
    for(int i=1;i<n;i++){
        for(int j=0;j<n;j++){
            if(j-1>=0){
                dp[i][j][1]+=dp[i-1][j-1][0]+dp[i-1][j-1][1];
            }
            if(j+1<n){
                dp[i][j][2]+=dp[i-1][j+1][0]+dp[i-1][j+1][2];
            }
        }
    }
    for(int i=n-2;i>=0;i--){
        for(int j=n-1;j>=0;j--){
            if(j+1<n){
                dp[i][j][3]+=dp[i+1][j+1][0]+dp[i+1][j+1][3];
            }
            if(j-1>=0){
                dp[i][j][4]+=dp[i+1][j-1][0]+dp[i+1][j-1][4];
            }
        }
    }
    tuple<int,int,ll> even=make_tuple(0,0,-1), odd=make_tuple(0,0,-1);
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            ll curr_sum=dp[i][j][0]+dp[i][j][1]+dp[i][j][2]+dp[i][j][3]+dp[i][j][4];
            tuple<int,int,ll> ins=make_tuple(i+1,j+1,curr_sum);
            if((i+j)%2==0){
                if(curr_sum>get<2>(even)){
                    even=ins;
                }
            } else {
                if(curr_sum > get<2>(odd)){
                    odd=ins;
                }
            }
        }
    }
    cout<<get<2>(even)+get<2>(odd)<<endl;
    cout<<get<0>(even)<<" "<<get<1>(even)<<" "<<get<0>(odd)<<" "<<get<1>(odd);
    return 0;
}