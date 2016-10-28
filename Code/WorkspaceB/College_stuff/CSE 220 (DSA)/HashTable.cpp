#include <iostream>
#include <vector>
#include <list>
using namespace std;

class HashTable
{
private:
	int size;
	int elements;
	vector<list<long int> > table;
	int getHash(long int key)
	{
		return (key%(long int)size);
	}
	double loadFactor()
	{
		return (double)elements/(double)size;
	}
	void resizeTable()
	{
		size=size*2+1;
		table.resize(size);
	}
public:
	HashTable()
	{
		size=173;
		elements=0;
		table.resize(173);
	}
	void Insert(long int x)
	{
		int pos=getHash(x);
		table[pos].push_front(x);
		elements++;
		double lf=loadFactor();
		if(lf>1.5)
			resizeTable();
	}
	bool Find(long int x)
	{
		int pos=getHash(x);
		for(list<long int>::iterator it=table[pos].begin(); it!=table[pos].end();it++)
			if(*it==x)
				return 1;
		return 0;
	}
	void printData()
	{
		for(int i=0;i<size;i++)
			for(list<long int>::iterator it=table[i].begin(); it!=table[i].end();it++)
				cout<<*it<<" ";
	}
};

int main()
{
	HashTable hs;
	cout<<"Print -1 to end inserting elements\n";
	long int x;
	cin>>x;
	while(x!=-1)
	{
		hs.Insert(x);
		cin>>x;
	}
	cout<<"Enter element to search. -1 to End\n";
	cin>>x;
	while(x!=-1)
	{
		if(hs.Find(x))
			cout<<"Element Exists\n";
		else
			cout<<"Element NOT present\n";
		cin>>x;
	}	
	return 0;
}