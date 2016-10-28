/*input
5
383
915
100
886
777
*/
#include <iostream>
#include <math.h>
#define LEFT(s) 2*s
#define RIGHT(s) 2*s+1
using namespace std;

int *a;
int n;

void MaxHeapify(int i)
{
	int l=LEFT(i);
	int r=RIGHT(i);
	int largest=i;
	if(l<=n && a[l]>a[i])
		largest=l;
	if(r<=n && a[r]>a[largest])
		largest=r;
	if(largest!=i)
	{
		std::swap(a[i],a[largest]);
		MaxHeapify(largest);
	}
}

void BuildMaxHeap()
{
	for(int i=floor(n/2);i>=1;i--)
		MaxHeapify(i);
}

void HeapSort()
{
	BuildMaxHeap();
	for(int i=n;i>=2;i--)
	{
		swap(a[i],a[1]);
		n--;
		MaxHeapify(1);
	}
}


int main()
{
	cin>>n;
	int x=n;
	a=new int[n+1];
	for(int i=1;i<=n;i++)
		cin>>a[i];
	HeapSort();
	for(int i=1;i<=x;i++)
		cout<<a[i]<<endl;
}