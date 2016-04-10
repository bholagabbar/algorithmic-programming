#include <iostream>
using namespace std;
#include "Segment_tree.cpp"


int main()
{
	int n;
	cout<<"Enter size of initial array\n";
	cin>>n;
	int array[n];
	cout<<"Enter the array\n";
	for(int i=0;i<n;i++)
		cin>>array[i];
	segmentTree st(n);
	st.buildST(1,0,n-1,array);
	cout<<"Built a Segment Tree for the array to execute queries\n";
	cout<<"Enter 1 to Query, 0 to Update, -1 to Exit\n";
	int q,a,b,val;
	cin>>q;
	while(q!=-1)
	{
		if(q==1)
		{
			cout<<"Enter 'a' and 'b' for Range Sum query between a and b\n";
			cin>>a>>b;
			cout<<st.RSumQ(1,0,n-1,a-1,b-1)<<endl;
		}
		else if(q==0)
		{
			cout<<"Enter index 'a' and 'b' to update with value 'val'\n";
			cin>>a>>b>>val;
			st.updateST(1,0,n-1,a-1,b-1,val);
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