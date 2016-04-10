#include <bits/stdc++.h>
using namespace std;
#define endl '\n'
#define push_back emplace_back
 
//Created by Shreyans Sheth [bholagabbar] using Sublime 3
 
int u[5001];//Union Array
int rnk[5001];//Rank for each node

class Node
{
public:
 
	int v1,v2,w,c;
	Node(int V1,int V2,int W)
	{
		this->v1=V1;
		this->v2=V2;
		this->w=W;
	}
};
 
class Asc
{
public:
	bool operator ()( const Node &e1, const Node &e2 ) const { return e1.w < e2.w; }	
};
 
class Des
{
public:
	bool operator ()( const Node &e1, const Node &e2 ) const { return e2.w < e1.w; }	
};

inline int FIND(int x)//Finding the parent of the current Node. Path compression documentation below
{
	if(u[x]!=u[u[x]])
	{
		u[x]=FIND(u[x]);
	}
	return u[x];	
}
 
inline bool UNION (int x, int y) // Setting the two parents of these nodes equal. Essentially, 'merging' the two sets :)
{	
	int px=FIND(x),py=FIND(y);
 
	//Union by rank
	if(px==py) return false;
	
	if(rnk[px]>rnk[py]) swap(px,py);
 
	else if(rnk[px]==rnk[py]) rnk[py]++; 
 
	u[px]=py;
	return true;
}
 
inline void u_init(int l)//Initialising union array to elements itself first and rank to 1
{
	for(int i=0;i<=l;i++)
	{
		u[i]=i;
		rnk[i]=1;
	}
}
 
int main()
{
	ios_base::sync_with_stdio(false);cin.tie(NULL);//FAST IO
	int tc;
	cin>>tc;
	while(tc--)
	{
		int n,M1,M2;
		cin>>n>>M1>>M2;
		vector <Node> m1;
		vector <Node> m2;
		u_init(n);
		
		for(int i=0;i<M1;i++)//Other companies
		{
			int x1,y1,w1;
			cin>>x1>>y1>>w1;
			m1.push_back(Node(x1,y1,w1));
		}
 
		for(int i=0;i<M2;i++)//chef company
		{
			int x1,y1,w1;
			cin>>x1>>y1>>w1;
			m2.push_back(Node(x1,y1,w1));
		}
		
		/*
		Always retrieve elements from the back of a vector to avoid resizing
		From back it takes O(1) to retrive and remove else it takes O(n) time and TLE
		*/

		sort(m2.begin(),m2.end(),Asc());
		sort(m1.begin(),m1.end(),Des());
		long long sum=0,cprof=0;
		int ecnt=0;
 
		while(m2.size()!=0&&ecnt<n-1)//First chef
		{
			Node cur=m2[m2.size()-1];
			m2.pop_back();
			if(UNION(cur.v1,cur.v2))//They don't add cycles
			{
				ecnt++;
				cprof+=cur.w;
			}
		}

		while(m1.size()!=0&&ecnt<n-1)//Other companies
		{
			Node cur=m1[m1.size()-1];
			m1.pop_back();
			if(UNION(cur.v1,cur.v2))//They don't add cycles
			{
				ecnt++;
				sum+=cur.w;
			}
		}
 
 		if(ecnt==n-1)//MST possible
		{
			cout<<cprof<<" "<<(cprof+sum)<<endl;
		}
		else
		{
			cout<<("Impossible\n");
		}
	}
	return 0;
}