#include <bits/stdc++.h>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(false);//FAST IO
	int t;
	cin>>t;
    for(int i=0;i<t;i++)
    {
        int n,m;
        cin>>n>>m;
        int no[m];
        for(int j=0;j<m;j++)
        {
            cin>>no[j];
        }
        int max[m];
        int p[m];
        for(int j=0;j<m;j++)
        {
            p[no[j]]=0;
            if(j==0)
            {
                max[no[j]]=p[no[j]];
            }
            else
            {
                if(p[no[j]]>max[no[j]])
                {
                    max[no[j]]=p[no[j]];
                }
            }
            for(int k=no[j]+1;k<n;k++)
            {
                p[k]=p[k-1]+1;
                if(j==0)
                {
                    max[k]=p[k];
                }
                else
                {
                    if(p[k]>max[k])
                    {
                        max[k]=p[k];
                    }
                }
            }
            for(int k=no[j]-1;k>=0;k--)
            {
                p[k]=p[k+1]+1;
                if(j==0)
                {
                    max[k]=p[k];
                }
                else
                {
                    if(p[k]>max[k])
                    {
                        max[k]=p[k];
                    }
                }
            }
        }
        for(int j=0;j<n;j++)
        {
            cout<<max[j]<<" ";
        }
		cout<<endl;
	}
	return 0;
}