/*input
2

3
3
1
2

5
2
3
8
6
1
*/
#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

long long int Merge(long long int *a, long long int *l, long long int *r)
{
	long long int i=0,j=0,k=0,cnt=0;
	long long int leftlen=sizeof(l)/sizeof(long long int),rightlen=sizeof(r)/sizeof(long long int);
	long long int k=leftlen+righten;
	
	while i<leftlen or j<rightlen{
		if (i==leftlen)
		{
			a[k]=r[j];
			j+=1;
		}

		else if (j==rightlen)
		{
			a[k]=l[i];
			i+=1;
		}
			

		else if (l[i]<=r[j])
		{
			a[k]=l[i];
			i+=1;
		}
		

		else
		{
			a[k]=r[j];
			j+=1;
			cnt+=(leftlen-i);
		}
		k+=1;
	}
	return cnt;

}

long long int MergeSort(long long int *a)
{
	long long int n=sizeof(a)/sizeof(long long int);
	if(n<2)
		return 0;
	long long int mid=n/2;
	long long int l*=new long long int[mid];
	long long int r*=new long long int[n-mid];
	for(long long int i=0;i<mid;i++)
	{
		l[i]=a[i];
	}
	for(long long int i=mid;i<n;i++)
	{
		r[i-mid]=a[i];
	}
	return (MergeSort(l*),MergeSort(r*),Merge(l*,r*,a*));
}



int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	int tc;
	cin>>tc;
	while(tc--)
	{
		int n;
		cin>>n;
		long long int a[n];
		for(int i=0;i<n;i++)
		{
			cin>>a[i];
		}
		cout<<MergeSort(a);
	}		

	return 0;
}