#include "BIT.h"

#define LSOne(s) s&(-s) //Goes to next/previous node in BIT 

FenwickTree::FenwickTree(int size) //Initializes Fenwick Tree
{
	this->size=size;
	bit=new int[size+1];//FenwickTree is 1-indexed
	for(int i=0;i<=size;i++)//Initilaizes BIT to 0
		bit[i]=0;
}

void FenwickTree::Build(int *a,int n)//Array, size
{
	for(int i=1;i<=n;i++)
	{
		int k=i;//Pointer to FenwickTree Node
		while(k<=n)
		{
			bit[k]+=a[i];//Adding value to the FenwickTree node
			k+=(k&(-k));//Shifts to Parent
		}
	}
}

void FenwickTree::Update(int index, int val) //Updates all values after 'index' with val
{
	int k=index;//1 based queries
	while(k<=size)
	{
		bit[k]+=val;
		k+=LSOne(k);
	}
}

long FenwickTree::Query(int index) //Return prefix sum uptil 'index'
{
	long sum=0;
	while(index>0)
	{
		sum+=bit[index];
		index-= (index&(-index));
	}
	return sum;
}

long FenwickTree::rangeQuery(int i, int j) //Return cumulative frequencies uptil 'index'
{
	long a1=Query(i-1);
	long a2=Query(j);
	return a2-a1;
}