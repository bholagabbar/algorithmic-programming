#include <iostream>
using namespace std;
class shape
{
public:
	int x,y;
	void getdata(int a,int b)
	{
		x=a;
		y=b;
	}
	virtual void display_area(){}//redefined in derived classes
};
class rect:public shape
{
public:
	void display_area()
	{
		cout<<"Area of rectangle is: "<<(x*y);
	}
};
class tri:public shape
{
public:
	void display_area()
	{
		cout<<"Area of triangle is: "<<(0.5*x*y);
	}
};
class circle:public shape
{
public:
	void display_area()
	{
		cout<<"Area of Circle is: "<<(3.14*x*x);
	}
};
int main()
{
	cout<<"Enter 2 numbers x and y to find area of given figures\n";
	float x,y;
	cin>>x>>y;
	cout<<"Choose:\n1. Area of rectangle\n2. Area of triangle\n3. Area of Circle\n";
	int c;
	x:cin>>c;
	if(c==1)
	{
		rect obj;
		obj.getdata(x,y);
		obj.display_area();
	}
	else if(c==2)
	{
		tri obj;
		obj.getdata(x,y);
		obj.display_area();
	}
	else if(c==3)
	{
		circle obj;
		obj.getdata(x,y);
		obj.display_area();
		cout<<"\n2nd parameter unused\n";
	}
	else
	{
		cout<<"Wrong chice. Try again\n";
		goto x;
	}
	cout<<"\nEnd\n";
	return 0;
}