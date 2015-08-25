#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

class A
{

public:
	int y;
};

class B:protected A
{

};

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	//cin.tie(NULL);//Untie streams before submission
	B obj;
	//obj.x=3;
	obj.y=4;
	//cout<<B.x;
	cout<<obj.y;

	return 0;
}