/*input
5 3
1000 1002 1003 1004 1005
S 0 2
S 0 3
S 1 4
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define size 1000005

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int st[size<<2];//Segment Tree
int lazy [size<<2]={0};//Lazy Array
int arr[size];//Input Array

void Build(int node,int a,int b)
{
    if(a>b)
        return;
    
    if(a==b)
    {
        st[node]=arr[a];
        return;
    }
    
    Build(2*node, a, (a+b)/2);
    Build(2*node+1, 1+ (a+b)/2, b);
    
    st[node]=(st[2*node] + st[2*node +1]);
}

int QSUM(int node, int a,int b, int i,int j)//return maximum in hte min range
{
    if(i>b || j<a ||a>b)
        return 0;
    
    if(i<=a && j>=b)
        return st[node];
    
    return (QSUM(2*node, a, (a+b)/2, i ,j) + QSUM(2*node +1 , 1 +(a+b)/2, b, i ,j));
}


//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int n,m;
	cin>>n>>m;
	for(int i=0;i<n;i++)
	{
		cin>>arr[i];
	}		
	Build(1,0,n-1);
	char act;
	int a,b;
	for(int i=0;i<m;i++)
	{
		cin>>act;
		if(act=='S')
		{
			cin>>a>>b;
			cout<<QSUM(1,0,n-1,a,b)<<endl;
		}
	}
	return 0;
}