#ifndef BIT_H
#define BIT_H

class FenwickTree //Equivalent to 'Binary Indexed Tree (BIT)'
{
private:
	int *bit;
	int size;
public:
	
	FenwickTree(int size); //Constructor to initialize the BIT
	void Build(int *a,int n); //Builds the Fenwick Tree for the given array
	void Update(int index, int val); //Updates all nodes including 'index' with val
	long Query(int index); //Return prefix sum uptil 'index'
	long rangeQuery(int i, int j) ;//Return cumulative frequencies uptil 'index'
};

#endif 
