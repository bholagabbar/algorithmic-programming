#include <iostream>
using namespace std;
class i20
{
	public:
		string name,type;
		int capacity;
	i20()
	{
		name="i20";
		type="hatchback";
		capacity=4;
	}
};
class i20_magna:virtual public i20
{
public:
	string spfeature1;
	private:
	float mil;
	string price;
	public:
	i20_magna()
	{
		spfeature1="Maganlium Rims";
		mil=25.5;
		price ="6k";
	}
	friend void getdata(int c);
};
class i20_sportz:virtual public i20
{
public:
	string spfeature2;
	private:
	float mil;
	string price;;
	public:
	i20_sportz()
	{
		spfeature2="Dual Airbags";
		mil=23.3;
		price ="7k";
	}
	friend void getdata(int c);
};
class i20_asta:public i20_magna,public i20_sportz
{
public:
	string spfeature3;
	private:
	float mil;
	string price;
	public:
	i20_asta()
	{
		spfeature3=spfeature1+" & "+spfeature2+" with Sunroof!";
		mil=23.3;
		price="8k";
	}

	friend void getdata(int c);
};

void getdata(int c)
{
	x:if(c==1)
	{
		i20_magna obj;
		cout<<"Car name: "<<obj.name;
		cout<<"\nType: "<<obj.type;
		cout<<"\ncapacity: "<<obj.capacity;
		cout<<"\nMileage: "<<obj.mil;
		cout<<"\nSpecial Feature: "<<obj.spfeature1;
		cout<<"\nPrice: "<<obj.price;
	}
	else if(c==2)
	{
		i20_sportz obj;
		cout<<"Car name: "<<obj.name;
		cout<<"\nType: "<<obj.type;
		cout<<"\ncapacity: "<<obj.capacity;
		cout<<"\nMileage: "<<obj.mil;
		cout<<"\nSpecial Feature: "<<obj.spfeature2;
		cout<<"\nPrice: "<<obj.price;
	}
	else if(c==3)
	{
		i20_asta obj;
		cout<<"Car name: "<<obj.name;
		cout<<"\nType: "<<obj.type;
		cout<<"\ncapacity: "<<obj.capacity;
		cout<<"\nMileage: "<<obj.mil;
		cout<<"\nSpecial Feature: "<<obj.spfeature3;
		cout<<"\nPrice: "<<obj.price;
	}
	else
	{
		cout<<"Wrong. Try Again\n";
		cin>>c;
		goto x;
	}
	cout<<"\nThanks!\n";
}


int main()
{
	cout<<"Choose the following for details on your favourite i20 model!\n1. Magna\n2. Sportz\n3. Asta\n";
	int c;
	cin>>c;
	getdata(c);
	return 0;
}