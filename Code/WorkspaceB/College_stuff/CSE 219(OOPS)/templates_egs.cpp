#include <iostream>
#include <vector>
using namespace std;
//Implementing templates with multiple arguments

/*template <class x1, class x2>
class t1
{
public:
	void compare(x1 x,x2 y);
};

template <class x1, class x2>
void t1<x1,x2>::compare(x1 x, x2 y)
{
	if(x>y)
	{
		cout<<x<<" is greater"<<endl;
	}
	else
	{
		cout<<y<<" is greater"<<endl;
	}
}

void mul_temp_eg()
{
	t1<int, int> obj;
	t1<char, char> obj2;
	t1<float, float> obj3;
	obj.compare(1,2);
	obj2.compare('a','g');
	obj3.compare(1.2,3.5);
}*/

//non generic-> Having non type arguments
template <class x, int times=5>
class gen1
{
public:
	x a;
	void getdata()
	{
		cout<<"Enter any datatype"<<endl;
		cin>>a;
	}
	void print()
	{
		int y=times;
		while(y--)
		{
			cout<<a<<endl;
		}
	}
};

void gen1_call()
{
	gen1<string, 2> obj;
	obj.getdata();
	obj.print();
	gen1<string> obj1;//will take default parameter
	obj1.getdata();
	obj1.print();
}

//Setting default type to one type

template <class x, class y=int>
class gen2
{
public:
	x a;
	y b;
	gen2(x a1, y b1)
	{
		a=a1;
		b=b1;
	}
	gen2(x a1)
	{
		a=a1;
	}
};

void gen2_call()
{
	gen2<float,string> obj(5.14,"hello");
	cout<<obj.a<<" "<<obj.b;
	gen2<char> obj2('a');
	cout<<obj2.a<<" "<<obj2.b;
}

int main()
{
	//stack_call();
	//mul_temp_eg();
	gen1_call();
	gen2_call();
	return 0;
}
