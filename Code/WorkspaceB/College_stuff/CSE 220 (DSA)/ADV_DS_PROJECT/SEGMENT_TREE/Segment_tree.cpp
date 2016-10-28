class segmentTree
{
private:
	int *st;
	int *lazy;
public:
	segmentTree(int n)
	{
		st=new int[n<<2];
		lazy=new int[n<<2];
		for(int i=0;i<(n<<2);i++)
			st[i]=lazy[i]=0;
	}

	void buildST(int pos, int lo, int hi, int *a) //Building Segment Tree
	{
	    if(lo>hi) return;//Wrong values
	    //Left Child: 2*pos, Right child: 2*pos+1
	    if(lo==hi)
	    {
	        st[pos]=a[lo]; //Getting the array element at the position of the leaf to be inserted 
	        return;
	    }
	    buildST(2*pos,lo,(lo+hi)/2, a); //Recursively Building Left child
	    buildST(2*pos+1,1+(lo+hi)/2,hi ,a); //Recursively building Right Child
	    st[pos]=(st[2*pos]+st[1+ 2*pos]); //setting the parent node as the max of the children node
	}

	int RSumQ(int node, int a,int b, int i, int j)//Range Maximum Query in [i,j]
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
			return 0;

		if(a>=i && b<=j)//Completely overlapping
			return st[node];//returning value at node

			//Partial overlap
					//Left child,low, mid, i,j     //Right child, mid, high, i,j           
		return (RSumQ(2*node ,a, (a+b)/2 ,i ,j) + RSumQ(2*node+1, 1+ (a+b)/2, b, i, j));
	}

	void updateST(int node, int a,int b, int i, int j, int value) //Updating array in [i,j] hence update the SegTree
	{//Refer similar commands documentation in RSumQ

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
		st[node]=(st[2*node]+st[2*node+1]);
	}
};