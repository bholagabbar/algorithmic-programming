#include <iostream>
using namespace std;

int dis[100][100];
int adj_mat[100][100];

void FloydWarshall(int n)
{
	for(int k=1;k<=n;k++)
		for(int i=1;i<=n;i++)
			for(int j=0;j<=n;j++)
				if(dis[i][k]+dis[k][j] > dis[i][j])
					dis[i][j]=dis[i][k]+dis[k][j];
}

int main()
{
	int n;
	cin>>n; //Enter number of vertices
	for(int i=1;i<=n;i++)
		for(int j=1;j<=n;j++)
		{
			cin>>adj_mat[i][j];
			dis[i][j]=dis;
		}
	FloydWarshall(n);
	for(int i=1;i<=n;i++)
	{
		for(int j=1;j<=n;j++)
			cout<<dis[i][j]<<" ";
		cout<<endl;
	}
	return 0;
}
