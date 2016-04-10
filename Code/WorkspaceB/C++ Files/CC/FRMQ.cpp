/*input
3
1 2 3
3 0 1
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int a[100001];
int st[4*100001];

void build(int pos, int lo, int hi)
{
    if(lo>hi) return;//Wrong values
    //Left Child: 2*pos, Right child: 2*pos+1
    if(lo==hi)
    {
        st[pos]=a[lo];
        return;
    }
    build(2*pos,lo,(lo+hi)/2);
    build(2*pos+1,1+(lo+hi)/2,hi);

    st[pos]=max(st[2*pos],st[1+ 2*pos]);
}

int RMaxQ(int pos,int lo, int hi, int i, int j)//Range Maximum Query between i,j
{
    if (i>hi || j<lo)
        return -INT_MIN;

    if (i<=lo && j>=hi)
        return st[pos];

    return max(RMaxQ(2*pos,lo,(lo+hi)/2,i,j),RMaxQ(2*pos+1,1+(lo+hi)/2,hi,i,j));//returns minimum in range from l,r
}

int main()
{
    ios_base::sync_with_stdio(false);//FAST IO
    int n;
    cin>>n;
    for(int i=0;i<n;i++)
    {
        cin>>a[i];
    }
    build(1,0,n-1);

    long long sum=0;
    int m,x,y;
    cin>>m>>x>>y;
    while(m--)
    {
        sum+=RMaxQ(1,0,n-1,min(x,y),max(x,y));
        x=(x+7)%(n-1);
        y=(y+11)%n;
    }
    cout<<sum;
    return 0;
}