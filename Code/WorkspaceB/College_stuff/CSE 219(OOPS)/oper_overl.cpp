#include <iostream>
#include <string>
#include <cstdlib>
using namespace std;

class B;
class A
{
	int age;
	string name;

public:	
	A ()
	{
	}

	void operator++(int dummy)
	{
		cout<<"Postfix operator overloaded\n";
		age++;
	}
	void operator++()
	{
		cout<<"Prefix operator overloaded\n";
		++age;
	}

	int getAge()
	{
		return this-> age;
	}

	string getName()
	{
		return this-> name;
	}
	
	friend ostream &operator <<(ostream &output, A *p);
	friend istream &operator >>(istream &input, A *p);
	friend A* operator+(A* g, B x);
};

class B
{
	int a;
public:
	B(int x)
	{
		this-> a=x;
	}

	friend A* operator+(A* g, B x);
};

//Overlaoded operators

void *operator new(size_t size)
{
	cout<<"Overloaded new operator\t size is: "<<size<<endl;
	void *pointer;
	pointer=malloc(size);
	return pointer;
}

void operator delete (void *pointer)
{
	cout<<"Overloaded Delete\n";
	free(pointer);
	cout<<"Memory freed\n";
}

ostream &operator <<(ostream &output, A *p)
{
	output<<"Overloaded << operator\n";
	output<<"Name is "<<p->name<<"And age is "<<p->age<<endl;
	return output;
}

istream &operator >>(istream &input, A *p)
{
	cout<<"Overloaded >> operator. Proceeding to input values\n";
	
	input>>p->name>>p->age;
	return input;
}

A* operator+(A* g, B x)
{
	g-> age= g-> age+ x.a;
	return g;
}

//Finished overloading operators

int main()
{
	A *ps=new A;
	cin>>ps;//>>overlaod
	cout<<ps;//<<overload
	int age;
	
	*ps++;
	age=ps->getAge();
	cout<<"New Age is "<<age<<endl;//unary postfix
	
	++*ps;
	age=ps->getAge();
	cout<<"New Age is "<<age<<endl;//unary prefix
	
	ps=ps+2;//Binary 
	age=ps->getAge();
	cout<<"New Age is "<<age<<endl;//unary prefix

	return 0;
}