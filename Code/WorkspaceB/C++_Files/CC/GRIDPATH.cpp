#include <bits/stdc++.h>
using namespace std;

//AC!!!!!!!
//When tiles are neighbours was corner case

bool BFS();
bool FinalBFS(int x1, int y1);//Checks for adjacent uncracked tiles around main destination

struct node
{
	int x;
	int y;
};

char grid[502][502];
int r=0,c=0,s1=0,s2=0,f1=0,f2=0;
int dx[]={1,-1,0,0};
int dy[]={0,0,-1,1};
int flag=0;

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	cin>>r>>c;//rows columns
	for(int i=0;i<r;i++)
	{
		string x1;
		cin>>x1;
		for(int j=0;j<c;j++)
		{
			grid[i][j]=x1[j];
		}
	}//built grid
	cin>>s1>>s2;//source coords
	cin>>f1>>f2;//dest coords
	s1--;s2--;f1--;f2--;
	if(s1==f1&&s2==f2)//if start equals dest
	{
		flag=2;
		if(FinalBFS(s1,s2))
		{
			cout<<"YES\n";
		}
		else
		{
			cout<<"NO\n";
		}
	}
	else
	{
		if(BFS())
		{
			//cout<<"Hurray "<<flag<<endl;
			if(flag==1)//Cracked. Easy
			{
				cout<<"YES\n";	
			}
			else
			{
				if(FinalBFS(f1,f2))
				{
					cout<<"YES\n";	
				}
				else
				{
					cout<<"NO\n";		
				}
			}
		}
		else
		{
			cout<<"NO\n";
		}
	}
	return 0;
}

bool BFS()
{
	node s;//source
	s.x=s1,s.y=s2;
	queue <node> q;
	q.push(s);
	while(!q.empty())
	{
		node p=q.front();
		q.pop();
		for(int i=0;i<4;i++)
		{
			if(((p.x+dx[i]>=0)&&(p.x+dx[i]<r))&&((p.y+dy[i]>=0)&&(p.y+dy[i]<c))&&((grid[p.x+dx[i]][p.y+dy[i]]=='.')||(p.x+dx[i]==f1&&p.y+dy[i]==f2)))
			{
				int cx,cy;
				cx=p.x+dx[i];
				cy=p.y+dy[i];
				//cout<<(cx+1)<<" "<<(cy+1)<<endl;
				if(cx==f1&&cy==f2)//Destination
				{
					for(int ix=0;ix<4;ix++)
					{
						if(((cx+dx[ix]>=0)&&(cx+dx[ix]<r))&&((cy+dy[ix]>=0)&&(cy+dy[ix]<c))&&(cx+dx[ix]==s1&&cy+dy[ix]==s2)&&grid[cx][cy]=='.')
						{
							flag=2;
						}
					}
					if(flag!=2&&grid[cx][cy]=='X')//Cracked. Direct entry
					{
						flag=1;
					}
					for(int i2=0;i2<r;i2++)
					{
						for(int j2=0;j2<c;j2++)
						{
							if(grid[i2][j2]=='V')
							{
								grid[i2][j2]='.';
							}
						}
					}
					return true;
				}
				else//Normal unbroken tile
				{
					grid[cx][cy]='V';//uncracked but added to queue. Can be used to step on
					node temp;
					temp.x=cx;
					temp.y=cy;
					q.push(temp);
				}
			}
		}
	}
	return false;
}

bool FinalBFS(int x1, int y1)
{	
	int cnt=0;
	for(int i=0;i<4;i++)
	{
		if(((x1+dx[i]>=0)&&(x1+dx[i]<r))&&((y1+dy[i]>=0)&&(y1+dy[i]<c))&&(grid[x1+dx[i]][y1+dy[i]]=='.'))//valid?
		{
			cnt++;
			if(flag==2)
			{
				return true;
			}
			else if(flag==0&&cnt==2)
			{
				return true;
			}
		}
	}
	return false;
}