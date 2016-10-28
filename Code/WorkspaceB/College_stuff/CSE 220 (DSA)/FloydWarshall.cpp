#include <iostream>
using namespace std;

int dis[251][251];

void FloydWarshall(int n)
{
<<<<<<< HEAD
	for(int k=1;k<=n;k++)
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				if(i!=j && i!=k && j!=k && dis[i][k]+dis[k][j]<dis[i][j])
					dis[i][j]=dis[i][k]+dis[k][j];
=======
    for(int k=1;k<=n;k++)
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                if(i!=j && i!=k && j!=k && dis[i][k]+dis[k][j]<dis[i][j])
                    dis[i][j]=dis[i][k]+dis[k][j];
>>>>>>> ea1fe64cc3715c94504a2b632613279521c9f48c
}

int main()
{
<<<<<<< HEAD
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
=======
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
>>>>>>> ea1fe64cc3715c94504a2b632613279521c9f48c
