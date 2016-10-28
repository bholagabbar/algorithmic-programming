/*input
18
3 4 2 1 5 7 9 7 10 5 12 3 1 1 2 1 3 2
1
4 10
*/
#include <bits/stdc++.h>
#include <cstdio>
using namespace std;
#define endl '\n'
#define N 100003

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin


	int maxSt [N<<2];//Max SegTree
    int minSt [N<<2];//Min SegTree
    int arr [N];//Array with I/P
    
    void BuildMax(int node,int a,int b)
    {
        if(a>b)
            return;
        
        if(a==b)
        {
            maxSt[node]=arr[a];
            return;
        }
        
        BuildMax(2*node, a, (a+b)/2);
        BuildMax(2*node+1, 1+ (a+b)/2, b);
        
        maxSt[node]=max(maxSt[2*node], maxSt[2*node +1]);
    }

     void BuildMin(int node,int a,int b)
    {
        if(a>b)
            return;

        if(a==b)
        {
            minSt[node]=arr[a];
            return;
        }

        BuildMin(2*node, a, (a + b)/2);
        BuildMin(2* node + 1, 1+(a + b)/2, b);

        minSt[node]=min(minSt[2*node], minSt[2*node + 1]);
    }

     int QueryMax(int node, int a,int b, int i,int j)//return maximum in hte min range
    {
        if(i>b || j<a ||a>b)
            return INT_MIN;
        
        if(i<=a && j>=b)
            return maxSt[node];
        
        return max(QueryMax(2*node, a, (a+b)/2, i ,j), QueryMax(2*node +1 , 1 +(a+b)/2, b, i ,j));
    }

     int QueryMin(int node, int a,int b, int i,int j)//return maximum in hte min range
    {
        if(i>b || j<a ||a>b)
            return INT_MAX;

        if(i<=a && j>=b)
            return minSt[node];

        return min(QueryMin(2*node, a, (a+b)/2, i, j), QueryMin(2*node +1, 1 +(a+b)/2, b, i, j));
    }


int main()
{
	
	int n,l,r;
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	{
		scanf("%d",&arr[i]);
	}
	int q;
	double res;

	BuildMax(1,0,n-1);
	BuildMin(1,0,n-1);

	scanf("%d",&q);
	while(q--)
	{
		scanf("%d%d",&l,&r);

		double a=QueryMin(1,0,n-1,l,r);//Min of Middle part that was put on fire

        int b=a+ QueryMax(1,0,n-1,0,l-1);//Max Left Part plus time for a

        int c=a+ QueryMax(1,0,n-1,r+1,n-1);//Max Right Part plus time for a

        double d=a+ ((QueryMax(1,0,n-1,l,r)-a))/2.0;//a+ Max of mid part by 2

        double Maxt= max(d,max((double)b,(double)c));

        printf("%.1lf\n",Maxt);

	}
	return 0;
}