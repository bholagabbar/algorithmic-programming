//DFS: http://ideone.com/jlsQnW
#include <iostream>
using namespace std;

bool adj_matrix[101][101]={0};//Adjacency matrix. 1 represents an edge between indices i and j
bool visited[101]={0};//Visited array for DFS to avoid visiting visited vertices again
int n;//Number of vertices in the graph

void DFS(int s)
{
	visited[s]=1;
	cout<<s<<" ";
	for(int i=1;i<=n;i++)
		if(adj_matrix[s][i]==1 && !visited[i])//Not visited and edge exists
			DFS(i);//Recursively calling DFS for the node
}

int main() 
{
	//cout<<"Enter number of vertices in the graph\n";
	cin>>n;
	int m;//Number of edges
	cin>>m;
	//cout<<"Enter number of edges\nVertices in the graph should be numbered between 1 to 100\n";
	for(int i=0;i<m;i++)
	{
		int x,y;
		cin>>x>>y;
		adj_matrix[x][y]=1;
		//adj_matrix[y][x]=1;//Add this to build an undirected graph
	}
	int s;
	//cout<<"Enter source for DFS\n";
	cin>>s;
	cout<<"DFS with Source "<<s<<"\n";
	DFS(s);
	cout<<"\nDONE";
	return 0;
}