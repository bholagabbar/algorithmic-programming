/*input
1
2
5
7
1 2 1
2 3 2
2 4 6
5 2 1
5 1 3
4 5 2
3 4 3
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define push_back emplace_back

//Created by Shreyans Sheth [bholagabbar] using Sublime 3

int u[100001];//Union Array
int r[100001];//Rank for each node

class Node //Custom datatype to store <From vertext, To vertex, Weight of connecting edge>
{
public:

	int v1,v2,w;
	Node(int V1,int V2,int W)
	{
		this->v1=V1;
		this->v2=V2;
		this->w=W;
	}
	
	//Comparator to sort edges
	bool operator<( const Node &e ) const { return e.w < w; }
};

inline int FIND(int x)//Finding the parent of the current Node. Path compression documentation below
{
	if(u[x]!=u[u[x]])
	{
		/*
		Finding the parent of each node. In the process, setting the parent
		of the current element and all the elements encountered in the 
		recursive tree (essentially, all nodes below the parent) where the parent
		is the first element in the branch of the tree/ladder
		*/
		u[x]=FIND(u[x]);
	}
	return u[x];
}

inline bool UNION (int x, int y) // Setting the two parents of these nodes equal. Essentially, 'merging' the two sets :)
{	
	int px=FIND(x),py=FIND(y);//Parents of these nodes

	/*Without Union by Rank, it's much easier to understand:

	int px=FIND(x),py=FIND(y);//Parents of these nodes
	if(px==py) return false;//Parents are equal. Don't merge
 
	u[px]=py;//Without Union by r. Setting parents equals and merging sets as mentioned before
	return true;
	*/

	//Union by rank
	if(px==py) return false;//Parents are equal. Don't merge
	
	if(r[px]>r[py]) swap(px,py);//Making sure r of x is smaller

	else if(r[px]==r[py]) r[py]++; // if both are equal, the combined tree becomes 1 deeper

	u[px]=py;//Setting parents equals and merging sets as mentioned before
	return true;
}

void u_init(int l)//Initialising union array to elements itself first
{
	for(int i=1;i<=l;i++)
	{
		u[i]=i;
		r[i]=1;
	}
}

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int tc;
	cin>>tc;
	while(tc--)
	{
		int n,m,p;
		cin>>p>>n>>m;
		vector <Node> edges;
		u_init(n);
		
		for(int i=0;i<m;i++)//Building edges data with <v1,v2,w>
		{
			int x1,y1,w1;
			cin>>x1>>y1>>w1;
			edges.push_back(Node(x1,y1,w1));
		}
		sort(edges.begin(),edges.end());//Sorting edges in ascending order order
		
		unsigned long long sum=0;
		int ecnt=0;
		
		while(ecnt!=n-1)//Edges in a spanning tree equals n-1. Duh
		{
			Node cur=edges[edges.size()-1];
			edges.pop_back();
			if(UNION(cur.v1,cur.v2))//They don't add cycles hence add a brach to the MST
			{
				ecnt++;
				sum+=(cur.w*p);//Sum of edges of MST
			}
		}
		cout<<sum<<endl;
		return 0;
	}
}