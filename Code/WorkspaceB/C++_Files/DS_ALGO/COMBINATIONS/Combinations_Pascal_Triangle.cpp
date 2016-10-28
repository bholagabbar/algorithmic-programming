/*input
5 5 100000000
*/
#include<iostream>
using namespace std;
#include<vector>
 
/*
    C(n,r) mod m
    Using recurrence:
    C(i,k) = C(i-1,k-1) + C(i-1,k)
    Time Complexity: O(n*r)
    Space Complexity: O(n*r)
*/
 
long long Calculate(int n, int r, int MOD)
{
    vector< vector<long long> > C(n+1,vector<long long> (r+1,0));
 
    for (int i=0; i<=n; i++)
    {
        for (int k=0; k<=r && k<=i; k++)
            if (k==0 || k==i)
            {
                C[i][k] = 1;
                cout<<i<<" "<<k<<" "<<C[i][k]<<endl;
            }
            else
            {
                C[i][k] = (C[i-1][k-1] + C[i-1][k])%MOD;
                cout<<i<<" "<<k<<" "<<C[i][k]<<endl;
            }
    }
    return C[n][r];
}
int main()
{
    int n,r,m;
    while (~scanf("%d%d%d",&n,&r,&m))
    {
        printf("%lld\n",Calculate(n, r, m));
    }
}