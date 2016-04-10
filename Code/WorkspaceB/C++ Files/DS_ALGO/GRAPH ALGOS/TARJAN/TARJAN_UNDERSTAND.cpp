/*input
0 1
1 2
2 0
1 3
1 4
1 6
3 5
*/
#include <bits/stdc++.h>
using namespace std;
#define sz 100001

//const int n=875715;
vector <int> a[sz]; //Graph as adjacency list
int low[sz]; //Lowest node reachable from given node
int disc[sz]; //Stores order in which node was discovered
stack <int> s; //Stack to store the members of a SSC
bool instack[sz]; //To check if element is in the stack
int block[sz]; //stores number of the SCC
int cc=0;

void DFS(int x)
{
	static int tm=0; //Time for each nodes discovered
	low[x]=disc[x]=tm; //Time discovered
	s.push(x); //Pushing element onto stack
	instack[x]=true; //Current element is in the stack
	for(int i:a[x]) //Iterating through vertices of current node
	{
		if(disc[i]==-1)
		{
			DFS(i);//Recursively executing DFS on this node
			low[x]=min(low[x],low[i]); //Lowest anchestor node reachable (Tree Edge)
		}
		else if(instack[i]) //Checking if it is not a cross edge (Back Edge)
			low[x]=min(low[x],disc[i]); //Lowest anchestor reachable
	}
	int size=0;
	if(low[x] ==disc[x])//Head of the SCC found
	{
		cc++;
		while(low[x]==s.top()) 
		{
			int y=s.top(); //Getting the element
			s.pop();
			instack[y]=0; //Now not in stack
			block[y]=cc;
		}
		//For last element
		int y=s.top();
		s.pop();
		instack[y]=0;
		block[y]=cc;
	}
}

void Tarjan()
{
	for(int i=1;i<n;i++) //Initiliazing values
	{
		low[i]=disc[i]=-1;
		instack[i]=0;
	}
	for(int i=1;i<n;i++)
		if(disc[i]==-1) //Node not discovered as yet
			DFS(i); //Run DFS on this
}

int main()
{
    //freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
    //long long tc=5105043;
    int tc=7;
    for(int i=0;i<tc;i++)
    {
    	int x,y;
    	cin>>x>>y;
    	a[x].push_back(y);
    }
    Tarjan();
    for(auto it:block)
    {
    	cout<<it<<"\n";
    }
	return 0;
}