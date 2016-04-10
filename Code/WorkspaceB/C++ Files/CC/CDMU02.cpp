#include <stdio.h>  
#include <string.h>  
#include <set>
int main()
    {
        char s[1000000];
        int n;
        scanf("%s",&s);
        std::set<char> st;
        for(int j=0;j<strlen(s);j++)
        {
            st.insert(s[j]);
        }
        scanf("%d",&n);
        for(int i=0;i<n;i++)
        {
            char c;
            long a1,b1;
            scanf("\n%c %ld %ld",&c,&a1,&b1);
            long x=0;
            bool is_in = st.find(c)!= st.end();
            if(is_in==true)
            {
                for(long j=a1-1;j<b1;j++)
                {
                    if(s[j]==c)
                    {
                        x++;
                    }
                }
            }
            printf("%ld\n",x);
        }
        return 0;
    }