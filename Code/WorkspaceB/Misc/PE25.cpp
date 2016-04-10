#include <iostream>    
#include <algorithm>    
using namespace std;
int main () 
{
	ios_base::sync_with_stdio(false);cin.tie(0);
	int a[] = {0,1,2,3,4,5,6,7,8,9};
	int cnt=1;
	while(cnt<1000000)
	{
		next_permutation(a,a+10);
		cnt++;
	}
	for(int j:a)
	{
		cout<<j;
	}
	cout<<"\n";
	return 0;
}