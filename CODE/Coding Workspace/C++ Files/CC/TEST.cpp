#include <bits/stdc++.h>
using namespace std;

int a[1000005];

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

int partition(int l ,int r)
{
	swap(a[l],a[l+rand()%(r-l+1)]);
	int pos=l+1;
	int pivot=a[l];
	for(int i=l+1;i<=r;i++)
		if(a[pos]<pivot)
		{
			swap(a[pos],a[i]);
			pos++;
		}
	swap(a[--pos],a[l]);
	return pos;
}

void quickSort(int l, int r)
{
	if(l<r)
	{
		int p=partition(a,l,r);
		quickSort(a,0,p-1);
		quickSort(a,p+1,r);
	}
}

int main()
{
	int tc=scanFast();
	int tc=scanFast();
	
	// while(tc--)
	// {
	// 	int n=scanFast();
	// 	for(int i=0;i<n;i++)
	// 		a[i]=scanFast();
	// 	quickSort(0,n-1);
	// 	for(int i=0;i<n;i++)
	// 		printf("%d\n",a[i]);
}
	