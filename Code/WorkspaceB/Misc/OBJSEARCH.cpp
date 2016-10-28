#include <iostream>
using namespace std;

class A
{
public:
	int a, b;
};

int main()
{
	A objarr[10]; //Object array
	for(int i=0;i<10;i++)//Populating the class array variable randomly (i and i+2. Can change to anythign)
	{
		objarr[i].a=i; 
		objarr[i].b=i+2;
	}
	int fa=7,fb=9;//If these values match any objects values, you have found the object
	for(int i=0;i<10;i++)
	{
		if(objarr[i].a==fa && objarr[i].b==fb)//Matching fa and fb to the objects values and checking if they match
		{
			cout<<"Object found at index "<<(i+1)<<endl;//Found. Return
			cout<<"a= "<<objarr[i].a<<" & b= "<<objarr[i].b<<endl;
			return 0;
		}
	}
	cout<<"Object not found with mathing values";//Not found
	return 0;
}