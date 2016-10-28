#include <iostream>
#include <string.h>
using namespace std;
class bank
{
	public:
	int accno,bal;
	char name[100];
	void getdata()
	{
		cout<<"Enter your Account number balance and name"<<endl;
		cin>>accno>>bal>>name;
	}
};	


bank operator +(bank obj,int x)
{
	obj.bal=obj.bal+1000;
	return(obj);
}

int operator >(bank o1, bank o2)
{
	if(o1.bal>o2.bal)
	{
		return 1;
	}
	else
	{
		return 0;
	}
}

int operator ==(bank ob1,bank ob2)
{
	if(strcmp(ob1.name,ob2.name)==0)
	{
		return 1;
	}
	else
	{
		return 0;
	}
}

int main()
{
	bank o1,o2;
	o1.getdata();
	o2.getdata();
	o1=o1+1000;
	o2=o2+1000;
	cout<<"Account balance for customers 1 and 2 after 1000 Rs bonus is "<<o1.bal<<" & "<<o2.bal<<endl;
	if(o1>o2)
	{
		cout<<"Max  account balance is possessed by customer 1 whose name is "<<o1.name<<" and balance is "<<o1.bal<<endl;
	}
	else if(o2>o1)
	{
		cout<<"Max  account balance is possessed by customer 2 whose name is" <<o2.name<<" and balance is "<<o2.bal<<endl;
	}
	if(o1==o2)
	{
		cout<<"Names are equal"<<endl<<"and the Name is: "<<o1.name<<endl;
	}
	else
	{
		cout<<"Names not equal"<<endl<<"Name 1 is: "<<o1.name<<"Name 2 is: "<<o2.name;
	}
	return 0;
}