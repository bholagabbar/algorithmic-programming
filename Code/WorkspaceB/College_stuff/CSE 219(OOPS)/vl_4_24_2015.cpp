/*
1.	Tax deduction table to be generated for Employee of VIT University. If the annual salary of the 
employee is less than 5 lakhs 10%, greater than 5 lakhs 20% and greater than 10 lakhs 30% of the Annual 
salary to be deducted as tax in equal installments for 12 months. Create a class Salary 
with Employee_Name, ID and Designation as Data Members of the Base class. Create a class Deduction 
as the derived class for processing the above scenario. 

Designation Criteria:
Assistant Professor: Basic – 18000, Associate Professor: Basic – 25000, 
Professor: Basic – 30000. [HRA 30% of Basic, DA 80% of Basic.]
Annual Salary   = Gross Salary * 12  
Gross Salary      = Basic + HRA + DA
*/


#include <iostream>
using namespace std;
class Salary
{
public:
	string Employee_Name,ID,Designation;
	void getData()
	{
		cin>>Employee_Name;
		cin>>ID;
		cin>>Designation;
	}
};

class Deduction:public Salary
{
public:
	double basic,hra,da,annual,gross;
	void Process()
	{
		
		if(Designation.compare("Assistant")==0)
		{
			basic=18000;
		}
		else if(Designation.compare("Associate")==0)
		{
			basic=25000;
		}
		else
		{
			basic =30000;
		}
		hra =0.30*basic;
		da=0.80*basic;
		gross=basic+hra+da;
		annual=gross*12;
	}
	void Display()
	{
		cout<<"Basic: "<<basic<<"\nHRA: "<<hra<<"\nDA: "<<da<<"\nGross: "<<gross<<"\nAnnual "<<annual<<endl;
	}
};

int main()
{
	Deduction x;
	x.getData();
	x.Process();
	x.Display();
	return 0;	
}