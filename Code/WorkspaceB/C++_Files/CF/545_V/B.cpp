//Team H@ckJack: Shantanutrip

#include <bits/stdc++.h>
using namespace std;
#define pll pair<long long,long long>
#define pii pair<int, int>
#define f first
#define s second
#define MAX 100010
#define INF LONG_MAX
#define ReadFile freopen("I:/CODE/INPUT.txt","r",stdin)
#define endl '\n'
#define pb emplace_back
#define MOD 1000000007
#define Boost ios_base::sync_with_stdio(false)

typedef long long int ll;
char arr[MAX];
int main()
{
    //ReadFile;
    Boost;
    string s1,s2;
    cin>>s1;
    cin>>s2;
    int n=s1.size();
    int prev=2;
    int cnt=0;
    for(int i=0;i<n;i++)
    {
        if(s1[i]==s2[i])arr[i]=s1[i];
        else
        {
            if(prev==1)
            {
                arr[i]=s2[i];
                prev=2;
            }
            else 
            {
                arr[i]=s1[i];
                prev=1;
            }
            cnt++;
        }
    }
    if(cnt%2==0)
    {
        for(int i=0;i<n;i++)cout<<arr[i];
        cout<<endl;
    }
    else cout<<"impossible"<<endl;
    return 0;
}