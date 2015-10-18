#include <iostream>
using namespace std;

void Merge(int a[],int l[], int r[],int ll,int rl,int n)
{
	int i=0,j=0,k=0;
	while(i!=ll && j!=rl)
	{
		if(i==ll & j<rl)
			a[k++]=a[j++];
		else if(j==rl && i<ll)
			a[k++]=a[i++];
		else if(l[i]<r[j])
			a[k++]=l[i++];
		else
			a[k++]=r[j++];
	}
	return;
}

void Sort(int a[],int s, int e)
{

	int n=e-s+1;
	for(int i=0;i<n;i++)
		cout<<a[i]<<" ";
	cout<<endl;
	if(n<2)
		return;
	int mid=(n+1)>>1;
	int ls[mid];
	int rs[mid];
	int las=0,ras=0;
	for(int i=0;i<mid;i++){
		ls[i]=a[i];las++;
	}
	for(int j=mid;j<n;j++){
		rs[j-mid]=a[j];ras++;
	}
	Sort(ls,0,las);
	Sort(rs,0,ras);
	Merge(a,ls,rs,las,ras,n);
}

int main()
{
	int a[]={1,7,6,100,75,2,400,6,2,90};
	Sort(a,0,sizeof(a)/sizeof(int)-1);
	for(auto i:a)
		cout<<i<<" ";
}

