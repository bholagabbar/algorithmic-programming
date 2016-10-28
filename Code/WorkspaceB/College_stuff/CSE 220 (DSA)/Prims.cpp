#include <iostream>
#include <set>
#include <vector>
#define pb push_back
#define mp make_pair
using namespace std;

typedef pair<int, int> pii;

int main()
{
    int n,e;
    cout<<"Enter number of vertices and edges\n";
    cin>>n>>e;
    vector<pii> graph[n+1];
    cout<<"Enter vertex v1, v2, weight\n";
    for(int i=0;i<e;i++)
    {
        int v1,v2,w;
        cin>>v1>>v2>>w;
        graph[v1].pb(mp(v2,w));
        graph[v2].pb(mp(v1,w)); //Undirected graph
    }
    int s=1; //Starting vertex
    set<int> vis;
    vis.insert(s);
    cout<<"\nEdges of the MST are:\n";
    while(vis.size()!=n)
    {
        //Now iterate through every every edge connected to ever visted vertex and choose the minimum
        int minw=100000;
        int vert1=0,vert2=0;
        for(set<int>::iterator it=vis.begin();it!=vis.end();it++) //Every vertex visited
            for(int j=0;j<graph[*it].size();j++) //Edge of every visited vertex
            {
                pii curr=graph[*it][j]; //Connected Vertex-Wight pair
                set<int>::iterator it2=vis.find(curr.first);
                if(it2==vis.end() && curr.second<minw) //If this vertex does not exist in set and weight is minimum currently, choose it
                {
                    vert1=*it;
                    vert2=curr.first;
                    minw=curr.second;
                }
            }
        vis.insert(vert2);
        cout<<(char)(vert1+64)<<" "<<(char)(vert2+64)<<" "<<minw<<endl; //Edge of the MST
    }
    //getchar();getchar();
    return 0;
}
