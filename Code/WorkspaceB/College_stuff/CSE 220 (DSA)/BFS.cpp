//BFS: http://ideone.com/X6OgjQ
#include <iostream>
#include <queue> 
using namespace std;

bool adj_matrix[101][101]={0};//Adjacency matrix. 1 represents an edge between indices i and j
int n;//Number of vertices in the graph

void BFS(int s)
{
	queue<int> q; //Inbuilt C++ queue. Included in header file <queue> and std namespace
	bool visited[n+1]={0}; //Visited array for BFS to avoid visiting visited vertices again
	q.push(s); //C++ function to push value into the queue
	visited[s]=1;
	cout<<"BFS from Source Vertex "<<s<<":\n";
	while(!q.empty())
	{
		int curr=q.front(); //Element at the front of the queue (again, C++ queue function)
		cout<<curr<<" "; //Current element in the BFS run
		q.pop(); //Removing that element (C++ inbuilt function again)
		for(int i=1;i<=n;i++)
			if(adj_matrix[curr][i]==1 && !visited[i])//If there exists and edge and the vertex is not visited
			{
				q.push(i); //Add that element to the queue
				visited[i]=1; //Now it has been visited
			}
	}
	cout<<"\nDONE";
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
		adj_matrix[y][x]=1;//Remove this if you want a directed graph. Currently assuming undirected
	}
	int s;
	//cout<<"Enter source for BFS\n";
	cin>>s;
	BFS(s);
	return 0;
}