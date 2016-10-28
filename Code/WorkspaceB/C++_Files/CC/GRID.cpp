#include <iostream>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(false);cin.tie(0);
    int t;
    cin>>t;
    while (t--)
    {
        int n=0;
        cin>>n;
        char a [n][n];
        for(int j=0;j<n;j++)
        {
            cin>>a[j];
        }
        int ans=0;
        for(int j=0;j<n;j++)
            {
                for(int k=n-1;k>=0;k--)
                {
                    if((char)a[k][j]=='.')
                    {
                        int flag=1;
                        for(int k1=j+1;k1<n;k1++)
                        {
                            if((char)a[k][k1]=='#')
                            {
                                flag=0;
                                break;
                            }
                        }
                        if(flag==1)
                        {
                            ans++;
                        }
                    }
                    else
                    {
                        break;
                    }
                }
            }
        cout<<ans<<"\n";
    }
    return 0;
}

