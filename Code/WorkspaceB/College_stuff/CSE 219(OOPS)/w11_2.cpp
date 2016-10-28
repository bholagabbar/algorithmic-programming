#include <iostream>
using namespace std;
class bank
{
public:
string name,acno,pan,deb;
int bal,dob,exp;
void getData()
{
cout<<"Enter Name, Account No, PanCard No, Debit card No, Balance, Year of DOB, Expiry year date"<<endl;
cin>>name>>acno>>pan>>deb>>bal>>dob>>exp;
}
};
int main()
{
try{
lab:
bank x;
x.getData();
//now checking acc no
int flag=1;
for(int i=0;i<x.acno.size();i++)
{
if(x.acno.at(i)<48||x.acno.at(i)>57)
{
flag =0;
break;
}
}
if(flag==0)
{
throw (1);
}
//now chcking dob
if(x.dob<1960)
{
throw (2);
}
//negative balk
if(x.bal<0)
{
throw (3);
}
//pan size
if(x.pan.size()>10)
{
throw (4);
}
//expiry
if(x.exp>2030)
{
throw (5);
}
cout<<"Would you like to make a transaction? 1. Deposit. 2. to Withdraw 0 to exit"<<endl;
int ch;
cin>>ch;
if(ch==0)
{
return 0;
}
else
{
if(ch==1)
{
cout<<"Enter amount"<<endl;
int amt;
cin>>amt;
x.bal=x.bal+amt;
cout<<"Balance is now:"<<x.bal<<endl;
goto lab;
}
else
{
cout<<"Enter amount"<<endl;
int amt;
cin>>amt;
x.bal=x.bal-amt;
cout<<"Balance is now:"<<x.bal<<endl;
goto lab;
}
}
}
catch(int y)
{
switch(y)
{
case 1:
cout<<"Accno should contain only digits"<<endl;
break;
case 2:
cout<<"DOB must be greater than 1960"<<endl;
break;
case 3:
cout<<"Account bal should not be negative"<<endl;
break;
case 4:
cout<<"Pan card no sohuld bne less than 10 digits"<<endl;
break;
case 5:
cout<<"Expiry should be before 2030"<<endl;
break;
}
return 0;
}
}
