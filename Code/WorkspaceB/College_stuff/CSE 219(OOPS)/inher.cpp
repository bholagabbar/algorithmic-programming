#include <iostream>
using namespace std;
/*class shape
{
public:
	virtual void draw(int size =100)
	{
		cout<<size<<endl;
	}
};

class circle:public shape
{
public:
	void draw(int size =200)
	{
		cout<<size<<endl;
	}
};

int main()
{
	shape a;
	shape *ptr;
	ptr=&a;
	ptr->draw();
	circle c;
	ptr=&c;
	ptr->draw();
	return 0;
}*/

class Base2
{
public:
	int y;
	/*Base2(int nvalue2)
	{
		y=nvalue2;
		cout<<"y is assg: "<<y<<endl;
	}*/	
};


class Base
{
public:
	int x;
	/*Base(int nvalue)
	{
		x=nvalue;
		cout<<"x is assg: "<<x<<endl;
	}*/
};

class Derived: public Base,public Base2 //This matters for order in which constructor is called
{
public:
    double m_dvalue;
 
    //Derived(double dValue, int nValue,int nValue2): Base(nValue),Base2(nValue2)
    Derived(dValue)
    {
    	this-> m_dvalue=dValue;
    	//cout<<"m_dvalue is assg: "<<m_dvalue<<endl;
    }
};

int main(int argc, char const *argv[])
{
	Derived d(4.3);
	cout<<d.x<<endl<<d.y<<endl<<d.m_dvalue<<endl;
	return 0;
}