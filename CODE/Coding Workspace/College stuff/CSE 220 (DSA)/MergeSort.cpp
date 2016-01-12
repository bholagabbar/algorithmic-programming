#include <iostream>
using namespace std;

void Merge(int a[], int leftArr[], int rightArr[], int size, int lsize, int rsize)
{
    int i=0,j=0,k=0;
    while (i<lsize && j<rsize)
    {
        if (leftArr[i]<=rightArr[j])
            a[k++]=leftArr[i++];
        else
            a[k++]=rightArr[j++];
    }
    while(i<lsize)
        a[k++]=leftArr[i++];
    while(j<rsize)
        a[k++]=rightArr[j++];
}

void MergeSort(int a[], int l, int r)
{
    if(l<r)
    {
        int size=r-l+1;
        int mid=size/2;
        int l[mid], r[size-mid];
        for(int i=0;i<mid;i++)
            l[i]=a[i];
        for(int i=mid;i<size;i++)
            r[i-mid]=a[i];
        MergeSort(l,0,mid-1);
        MergeSort(r,mid,size-1);
        Merge(a,l,r,size,mid,size-mid);
    }
}

int main()
{
    int n=7;
    int a[]={1,7,3,4,7,1,8};
    MergeSort(a,0,n-1);
    for(int i=0;i<n;i++)
        cout<<a[i]<<" ";
}