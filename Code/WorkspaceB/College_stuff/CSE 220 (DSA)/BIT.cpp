#include <iostream>
#include <cstdlib>
#define LSOne(s) s&(-s) //Next/Previous node in BIT
using namespace std;

class FenwickTree //Equivalent to 'Binary Indexed Tree (BIT)'
{
private:
	int *bit;
	int size;
public:
	FenwickTree(int size); //Initializes Fenwick Tree
	{
		this->size=size;
		bit=new int[size+1];//BIT is 1-indexed
		memset(bit,0,sizeof(bit));//Initililzes BIT to 0
	}

	void Build(int *a,n)//Array, size
	{
		for(int i=0;i<n;i++)
		{
			int k=1;//Pointer to BIT Node
			while(k<=n)
			{
				bit[k]+=a[i];//Adding value to the BIT node
				k+=LSOne(k);//Shifts to Parent
			}
		}
	}

	void Update(int index, int val) //Updates all values after 'index' with val
	{
		int k=index;//1 based queries
		while(k<=size)
		{
			bit[k]+=val;
			k+=LSOne(k)
		}
	}

	long Query(int index) //Return prefix sum uptil 'index'
	{
		long sum=0;
		while(index>0)
		{
			sum+=bit[index];
			index-= LSOne(index);
		}
		return sum;
	}

	long rangeQuery(int i, int j) //Return cumulative frequencies uptil 'index'
	{
		long a1=Query(i-1);
		long a2=Query(j);
		return a1-a1;
	}
};

int main()
{
	
}