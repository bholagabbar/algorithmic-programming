//Shreyans Sheth [bholagabbar]
 
//Implementation test
 
#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define getPrecision(s,p) fixed<<setprecision(p)<<s
#define boostIO ios_base::sync_with_stdio(0), cin.tie(0)
#define CLR(s) memset(&s, 0, sizeof s)
#define hashset unordered_set	//JAVA Feels :')
#define hashmap unordered_map
#define pb push_back
#define mp make_pair
#define sz 1000001
#define F first
#define S second
#define endl '\n'
 
typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
 
int *a;

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
	boostIO;
	int n;
	cin>>n;
    a=new int[n];
	for(int i=0;i<n;i++)
		cin>>a[i];
	MergeSort(a,0,n-1);
	for(int i=0;i<n;i++)
		cout<<a[i]<<endl;
	return 0;
} 