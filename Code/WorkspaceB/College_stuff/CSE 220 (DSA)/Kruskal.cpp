#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int* u; //DSU array

class Edge //Struct to hold edges
{
public:
    int v1,v2,w;
    Edge(){}
    Edge(int v1,int v2, int w)
    {
        this->v1=v1;
        this->v2=v2;
        this->w=w;
    }
};

int FIND(int x)
{
    if(u[x]!=u[u[x]])
        u[x]=FIND(u[x]);
    return u[x];
}

bool UNION(int x, int y)
{
    int px=FIND(x),py=FIND(y);//Parent vertices of x and y
    if(px==py)
        return false;
    //Otherwise do not form a loop. Hence merge
    u[px]=py;
    return true;
}

int main()
{
    int n,v1,v2,e,m;
    cin>>n; //number of vertices
    cin>>m; //Number of edges
    u=new int[n+1];
    for(int i=0;i<=n;i++) //Initilaizing DSU array
        u[i]=i;
    class comparator { public: bool operator()(const Edge &e1, const Edge &e2) { return e1.w>e2.w;}};// Comparator for Edges
    priority_queue<Edge,vector<Edge>, comparator> pq; //Maintains set of edges in ascending order
    Edge edges[n-1]; //Maintains final set of edges
    for(int i=0;i<m;i++)
    {
        cin>>v1>>v2>>e; //Vertex 1, Vertex 2, Weight
        Edge x(v1,v2,e);
        pq.push(x); //Pushing node into priority queue
    }
    int cnt=0;
    while(cnt!=n-1) //Number of edges in a tree= n-1
    {
        Edge x=pq.top();
        pq.pop();
        if(UNION(x.v1,x.v2)) //If these vertices do not form a loop, add them to the MST
            edges[cnt++]=x;
    }
    cout<<"\nEdges are:\n";
    for(int i=0;i<n-1;i++) //Displaying final set of edges
        cout<<(char)(edges[i].v1+64)<<" "<<(char)(edges[i].v2+64)<<" "<<edges[i].w<<endl; //Printing as A,B,C etc
    return 0;
}
