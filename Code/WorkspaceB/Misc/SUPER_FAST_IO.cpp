//Doesnt work on windows. Only OJ
#include <bits/stdc++.h>
using namespace std;

inline int scanFast()
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
    int n=scanFast();
    printf("%d\n",n);
    return 0;
}