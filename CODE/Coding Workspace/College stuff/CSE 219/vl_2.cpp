/*2.	VIT University is planning to construct Academic Block 1 and 2. 
Help the Engineer to plan for the budget and to purchase the number of equipments 
'to be bought for the lecture hall in academic Block 1 and 2. Acad. B1 has 8 floors and Acad.
 B2 has 12 floors, each floor contains 12 lecture halls except ground floor. In Academic Block 2,
  3rd and 4th floor has only Labs, 7th floor has an auditorium and seminar hall. 
  Calculate the total number of Equipments to be purchased only for lecture halls in 
  both Academic Block 1 and 2. Also generate the total budget for the same using pure virtual function. 

Estimation of Cost (Indian Rupees) for single equipment for a Lecture Hall:
Projector – 90,000.00, Chalk_board – 5,000.00, Marker_boards – 10,000.00, 
Fan – 2, 000.00 ( single class room has 8 fans), Tubelight – 300.00 (Single class room has 6 
Tubelights), Student Desk – 2,000.00 (Single class room has 40 Desks)
*/

#include <iostream>
using namespace std;

void total();

class AB
{
public:
	void calculate()=0;//pure virtul function
};

class AB1:public AB
{
public:
	double cost;
	void calculate()
	{
		this->cost=7*(90000)+(500000)+(10000)+(16000)+1800+(40*2000);
	}
	void DisplayCost()
	{
		cout<<"Cost for AB1: "<<this->cost<<endl;
	}
	friend void total();
};

class AB2:public AB
{
public:
	double cost;
	void calculate()
	{
		this->cost=9*(90000)+(500000)+(10000)+(16000)+1800+(40*2000);
	}
	void DisplayCost()
	{
		cout<<"Cost for AB2: "<<this->cost<<endl;
	}	
	friend void total();
};

void total()
{
	AB1 x;
	AB2 y;
	double tot=x.cost+y.cost;
	cout<<"Total Cost is: "<<tot<<endl;
}

int main()
{
	AB1 x;
	AB2 y;
	x.calculate();
	x.DisplayCost();
	y.calculate();
	y.DisplayCost();
	total();
	return 0;
}