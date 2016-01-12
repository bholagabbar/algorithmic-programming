#include <iostream>
using namespace std;

int dis[251][251];

void FloydWarshall(int n)
{
	for(int k=1;k<=n;k++)
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				if(i!=j && i!=k && j!=k && dis[i][k]+dis[k][j]<dis[i][j])
					dis[i][j]=dis[i][k]+dis[k][j];
}

int main()
{
	int n;
	cin>>n;
	for(int i=1;i<=n;i++) //Input adjacency matrix
		for(int j=1;j<=n;j++)
			cin>>dis[i][j];
	FloydWarshall(n);
	for(int i=1;i<=n;i++) //Printing shortest path from vertex i to j
	{
		for(int j=1;j<=n;j++)
			cout<<dis[i][j]<<" ";
		cout<<endl;
	}
	return 0;
}