#include <bits/stdc++.h>
using namespace std;

int BFS();
//well sublime 
char grid[30][30];
int distances[30][30];
int r=0,c=0,s1=0,s2=0,f1=0,f2=0;
int dx[]={1,-1,0,0};
int dy[]={0,0,-1,1};
set<pair<int,int>> points;

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int t;
	cin>>t;
	while(t--)
	{
		points.clear();//clearing set
		cin>>r;//rows columns
		c=r;
		for(int i=0;i<r;i++)
		{
			string x1;
			cin>>x1;
			for(int j=0;j<c;j++)
			{
				grid[i][j]=x1[j];
				distances[i][j]=-1;
				if(x1[j]=='*')//Found treasures
				{
					pair<int, int>tmp=make_pair(i,j);
					points.insert(tmp);//adding treasures to set
				}
			}
		}//built grid
		s1=s2=0;
		distances[s1][s2]=0;//for 0,0
		int ansd=0;
		int flag=1;
		while(!points.empty())
        {
            for(int i=0;i<r;i++)
            {
                for (int j = 0; j < c; j++)
                {
                    distances[i][j]=-1;
                    if(grid[i][j]=='V')//Visited
                    {
                        grid[i][j]='.';//Accesibly again in next walk
                    }
                }
            }
            distances[s1][s2]=0;//next source specified in BFS function
            int dis=BFS();
            if(dis!=-1)
            {
                ansd += dis;
            }
            else
            {
                cout<<"-1\n";
                flag = 0;
                break;
            }
        }
        if(flag==1)//This means that all treasures collected. Applying BFS for (n,n)
        {
            for(int i11=0;i11<r;i11++)//resetting
            {
                for(int j1=0;j1<c;j1++)
                {
                    if(grid[i11][j1]=='V')
                    {
                        grid[i11][j1]='.';
                    }
                    distances[i11][j1]=0;
                }
            }
            f1=r-1;f2=c-1;
            grid[f1][f2]='*';//setting destination as treasure itself
            int x=BFS();
            if(x!=-1)
            {
                cout<<(ansd+x)<<endl;
            }
            else
            {
                cout<<"-1\n";
            }
        }
	}
	return 0;
}

int BFS()
{
    queue<pair<int,int>> q;//Queue for BFS
    pair<int,int> src=make_pair(s1,s2);//source coordinates
    q.push(src);
    while(!q.empty())
    {
        pair<int,int> p=q.front();
        q.pop();
        for(int i=0;i<4;i++)
        {
            if(((p.first+dx[i]>=0)&&(p.first+dx[i]<r))&&((p.second+dy[i]>=0)&&(p.second+dy[i]<c))&&(grid[p.first+dx[i]][p.second+dy[i]]!='#'))
            {//If point is in range
                int cx,cy;
                cx=p.first+dx[i];
                cy=p.second+dy[i];
                distances[cx][cy]=distances[p.first][p.second]+1;//Distances
                if(grid[cx][cy]=='*')//destination
                {
                    for(pair<int,int> rm:points)// finding the node and removing it
                    {
                        if(rm.first==cx&&rm.second==cy)
                        {
                            points.erase(rm);
                            break;
                        }
                    }
                    grid[cx][cy]='.';//It is walkable again
                    s1=cx;s2=cy;//next source set
                    return distances[cx][cy];
                }
                else if(grid[cx][cy]=='.')//Normal tile. Now setting to visited
                {
                    grid[cx][cy]='V';//Adding to visited
                    pair<int,int> temp=make_pair(cx,cy);
                    q.push(temp);
                }
            }
        }
    }
    return -1;
}