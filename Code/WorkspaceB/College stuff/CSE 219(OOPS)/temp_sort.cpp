#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

template <class T>
T* bsort(T a[], int size)
{
	for(int i=0;i<size;i++)
	{
		for(int j=i+1;j<size;j++)
		{
			if(a[j]<a[i])
			{
				T temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		
	}
	return a;
}

int main()
{
	int a[5]={2,4,1,2,5};
	char b[5]={'b','a','d','c','e'};
	int *c=bsort(a,5);
	for(int i=0;i<5;i++)
	{
		cout<<c[i]<<" ";
	}
	cout<<endl;
	char *d=bsort(b,5);
	for(int i=0;i<5;i++)
	{
		cout<<d[i]<<" ";
	}
	return 0;
}