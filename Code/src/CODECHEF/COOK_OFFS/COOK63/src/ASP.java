/*input
2
3
1 2 3
5
2 4 1 3 5
*/

//Sorry JAVA babes

/*#include <bits/stdc++.h>
        using namespace std;
        #define ReadFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
        #define BoostIO ios_base::sync_with_stdio(false)
        #define pll pair<long long int,long long int>
        #define CLR(s) memset(&s, 0, sizeof(s))
        #define hashset unordered_set
        #define hashmap unordered_map
        #define pii pair<int,int>
        #define pb push_back
        #define mp make_pair
        #define F first
        #define S second
        #define endl '\n'

        typedef long long int ll;
        typedef long double ld;

        inline int SCANFAST()
        {
        int num = 0;
        char c = getchar_unlocked();
        bool flag = 0;
        while(!((c>='0' & c<='9') || c == '-'))
        c=getchar_unlocked();
        if(c == '-')
        {
        flag = 1;
        c=getchar_unlocked();
        }
        while(c>='0' && c<='9')
        {
        num = (num<<1)+(num<<3)+c-'0';
        c=getchar_unlocked();
        }
        if(flag==0)
        return num;
        else
        return -1*num;
        }

//Created by Shreyans Sheth [bholagabbar]

        int main()
        {
        //ReadFile;
        //BoostIO;
        int t;
        t=SCANFAST();
        //cin>>t;
        while(t--)
        {
        int n,flag=1;
        ll prev2,prev1,x;
        //cin>>n;
        n=SCANFAST();
        //cin>>prev2;
        prev2=SCANFAST();
        if(n==1)
        {
        //cout<<"YES\n";
        printf("YES\n");
        continue;
        }
        else if(n==2)
        {
        //cin>>prev1;
        prev=SCANFAST();
        //cout<<"YES\n";
        printf("YES\n");
        continue;
        }
        else
        {
        //cin>>prev1;
        prev=SCANFAST();
        if(prev1<prev2)
        swap(prev1,prev2);
        for(int i=2;i<n;i++)
        {
        //cin>>x;
        x=SCANFAST();
        if(flag==1)
        {
        if(x<prev1)
        {
        //cout<<"swapping 1 "<< x<<" "<<prev1;
        swap(prev1,x);
        }
        if(prev1<prev2)
        {
        //cout<<"Not correct "<< prev1<<" "<<prev2;
        flag=0;
        }
        }
        }
        if(flag==0)
        printf("NO\n");
        else
        printf("YES\n");
        }
        }

        return 0;
        }
        */