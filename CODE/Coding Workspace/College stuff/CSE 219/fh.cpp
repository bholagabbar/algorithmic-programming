#include <iostream>
#include <fstream>
using namespace std;

int main()
{
	fstream file;
	file.open("name.txt",ios::in | ios::out | ios::trunc);
	file<<"Hello my is\n";
	file<<"Shreyans\n";
	file<<"I am in VIT\n";
	file<<"Chennai\n";
	file.seekg(0);
	while(!file.eof())
	{
		string x;
		file>>x;
		cout<<x<<endl;
	}
	file.close();
	return 0;
}