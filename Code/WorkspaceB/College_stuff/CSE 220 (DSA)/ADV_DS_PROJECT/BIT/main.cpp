#include <iostream>
#include "BIT.cpp"
using namespace std;

int main()
{
	int n;
	cout<<"Enter size of initial array\n";
	cin>>n;
	int array[n+1];
	cout<<"Enter the array\n";
	for(int i=1;i<=n;i++)
		cin>>array[i];
	FenwickTree bit(n);//Initliazed Fenwick Tree
	bit.Build(array,n);
	cout<<"Built a Fenwick Tree for the array to execute queries\n";
	cout<<"Enter 1 to Query, 0 to Update, -1 to Exit\n";
	int q,a,b,val;
	cin>>q;
	while(q!=-1)
	{
		if(q==1)
		{
			cout<<"Enter 'a' and 'b' for Range Sum query between a and b\n";
			cin>>a>>b;
			cout<<bit.rangeQuery(a,b)<<endl;
		}
		else if(q==0)
		{
			cout<<"Enter index 'a' to update with value 'val'\n";
			cin>>a>>val;
			bit.Update(a,val);
			cout<<"Update done\n";
		}
		else
		{
			cout<<"Sorry enter again:\n";
			goto nxt;
		}
		nxt:cout<<"Enter 1 to Query, 0 to Update, -1 to Exit\n";
		cin>>q;
	}
	return 0;
}