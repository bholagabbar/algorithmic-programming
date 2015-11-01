#include <iostream>
#include <vector>
#include <utility>
#include <set>
#define MAX 1e8//very large number

using namespace std;

typedef vector<int> vi;

typedef pair<int,int> ii;

typedef vector<ii> vii;

typedef vector<vii> vvii;


int main()

{
  int V;

 cin>>V;//Number of vertices

 vvii G(V);//The weighted undirected graph

 vector<bool>disc(V,false);//whether the vertex is discovered or not

 vi d(V,MAX);//all d[] initialised

 vi par(V,-1);//parent of the vertex

 vii edge;//The edges of the MST

 int E;

 cout<<"Edges\n";

 cin>>E;

 cout<<"Input every edge\n";

 for(int i=0;i<E;i++)

 {int u,v,wt;

  cin>>u;

  cin>>v;

  cin>>wt;

  G[u].push_back(make_pair(v,wt));

  G[v].push_back(make_pair(u,wt));}

  cout<<"Choose start vertex from 0 to "<<V-1<<endl;

  int s;

  cin>>s;

  set<ii> Q;//set is a RBT.Since this is a set of pairs.A pair(i,j)<pair(l,m) if i<l.if i=l then j<m

  for(int i=0;i<V;i++)

    Q.insert(make_pair(d[i],i));//Insert all the vertices in the Queue

  Q.erase(Q.find(make_pair(d[s],s)));

  d[s]=0;//Thus in this set the first element is an edge weight since we want it to be sorted by edge weights

  Q.insert(make_pair(d[s],s));

  while(!Q.empty())

  {ii top=*Q.begin();

   Q.erase(Q.begin());

   int v=top.second;//the vertex whose adjacent vertices have to be analyzed

   disc[v]=true;

   if(v!=s)//ie v isn't the source vertex since in the first iteration we have the source vertex

   edge.push_back(make_pair(par[v],v));

   for(int i=0;i<G[v].size();i++)

   {if(disc[G[v][i].first]==false)//The vertex isn't visited only their d[] will change

    {int v2=G[v][i].first;

int cost=G[v][i].second;//weight of edge v,v2

if(d[v2]>cost)

{Q.erase(Q.find(make_pair(d[v2],v2)));

  d[v2]=cost;

  Q.insert(make_pair(d[v2],v2));

  par[v2]=v;//parent will be updated in this loop

  }

}

   }

   }

  cout<<"MST edge set is"<<endl; 

  for(int i=0;i<edge.size();i++)

  cout<<edge[i].first<<","<<edge[i].second<<endl;

  return 0;}