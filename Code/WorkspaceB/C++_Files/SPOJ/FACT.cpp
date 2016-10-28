#include <iostream>
#include <math.h>
using namespace std;
int main()
{
	int num;
	cin>>num;
	int square_root = (int) sqrt(num);
	for (int i = 1; i <=square_root; i++)
	{ 
		if (num % i == 0)
		{
		cout << i<<endl;
		cout<<(num/i)<<endl;
		}
	}
	return 0;
}
