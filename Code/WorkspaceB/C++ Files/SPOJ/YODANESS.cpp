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

int merge(string arr[],  int left, int mid, int right, int n)
{
string temp [n];
int i, j, k;
int inv_count = 0;

i = left;
j = mid; 
k = left;
while ((i <= mid - 1) && (j <= right))
{
	if (arr[i].compare(arr[j])<=0)
	{
	temp[k++] = arr[i++];
	}
	else
	{
	temp[k++] = arr[j++];
	inv_count = inv_count + (mid - i);
	}
}

while (i <= mid - 1)
	temp[k++] = arr[i++];


while (j <= right)
	temp[k++] = arr[j++];

for (i=left; i <= right; i++)
	arr[i] = temp[i];

return inv_count;
}

int mergeSort(string arr[], int left, int right,int n)
{
int mid, inv_count = 0;
if (right > left)
{
	mid = (right + left)/2;
	inv_count = mergeSort(arr, left, mid,n);
	inv_count += mergeSort(arr, mid+1, right,n);
	inv_count += merge(arr, left, mid+1, right,n);
}
return inv_count;
}


int main(int argv, char** args)
{
int tc;
  cin>>tc;
  while(tc--)
  {
  	int n;
  	cin>>n;
  	string arr[n];
    string temp[n];
  	for(int i=0;i<n;i++)
  		cin>>arr[i];
  	cout<<mergeSort(arr,0,n-1,n)<<endl;
  }
}
