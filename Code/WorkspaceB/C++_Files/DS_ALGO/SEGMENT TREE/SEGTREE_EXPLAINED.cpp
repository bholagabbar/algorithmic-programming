/*input
4
-1 2 4 0
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define STsize 100001

/*Segtrees using lazy. Lazy Propogation mean that you update the tree as and when required.
You store the update values in an array called lazy. Now when that node is queried, you update it
and then carry forward the update to it's child nodes. 

In the normal updation method, we would have to update the child nodes always
and this could become very time consuming
*/
//Also refer MARBLEGF.cpp

//SEGMENT TREE: BUILD, MAX_RANGE_QUERY, UPDATE

int a [STsize];
int st [STsize<<2];
int lazy [STsize<<2];

void buildST(int pos, int lo, int hi) //Building Segment Tree
{
    if(lo>hi) return;//Wrong values
    //Left Child: 2*pos, Right child: 2*pos+1
    if(lo==hi)
    {
        st[pos]=a[lo]; //Getting the array element at the position of the leaf to be inserted 
        return;
    }
    buildST(2*pos,lo,(lo+hi)/2); //Recursively Building Left child
    buildST(2*pos+1,1+(lo+hi)/2,hi); //Recursively building Right Child
    st[pos]=max(st[2*pos],st[1+ 2*pos]); //setting the parent node as the max of the children node
}

int RMAXQ(int node, int a,int b, int i, int j)//Range Maximum Query in [i,j]
{
	if(lazy[node]!=0)//Node needs to be updated
	{
		st[node]+=lazy[node];//Updating it since now it is queried.

		if(a!=b)//Not a leaf node
		{
			//Carryforward update to child nodes
			lazy[2*node]+=lazy[node];//Flagging left child
			lazy[2*node +1]+=lazy[node];//Flagging Right child
		}
		lazy[node]=0;//Now fully updated. Hence no value to be stored in lazy
	}

	if(i>b || j<a || a>b)//Not overlapping
		return -(INT_MAX);

	if(a>=i && b<=j)//Completely overlapping
		return st[node];//returning value at node

		//Partial overlap
				//Left child,low, mid, i,j     //Right child, mid, high, i,j           
	return max(RMAXQ(2*node ,a, (a+b)/2 ,i ,j) , RMAXQ(2*node+1, 1+ (a+b)/2, b, i, j));
}

void updateST(int node, int a,int b, int i, int j, int value) //Updating array in [i,j] hence update the SegTree
{//Refer similar commands documentation in RMAXQ

	if(lazy[node]!=0)
	{
		st[node]+=lazy[node];
		if(a!=b)
		{
			lazy[2*node]+=lazy[node];
			lazy[2*node+1]+=lazy[node];
		}
		lazy[node]=0;
	}
	if(i>b || j<a || a>b)//Not overlapping
		return;

	if(a>=i && b<=j)//Overlapping
	{
		st[node] +=value;//Updating values
		if(a!=b)
		{//Flagging children
			lazy[2*node]+=value;
			lazy[2*node +1]+=value;
		}
		return;
	}

	updateST(2*node, a, (a+b)/2, i,j,value);
	updateST(2*node+1, 1+ (a+b)/2, b, i,j,value);
	st[node]=max(st[2*node],st[2*node+1]);
}

//Driver f'n to test

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int n;//size of array
    cin>>n;
    for(int i=0;i<n;i++)
    	cin>>a[i];
    buildST(1,0,n-1);//Building SegTree

	updateST(1,0,n-1,1,n,5);

	for(int i=1;i<=7;i++)
	{
		cout<<st[i]<<" ";
	}
	
	cout<<endl<<endl;
	

	cout<<RMAXQ(1,0,n-1,1,4)<<endl;//RMAXQ for whole;*/

	for(int i=1;i<=7;i++)
	{
		cout<<st[i]<<" ";
	}
	
	cout<<endl<<endl;	
	return 0;
}
