#include <iostream>
using namespace std;

class student
{
	public:
     string name,rno,sname;
     float cgpa;
     int nc;
     string *a;
};

int main()
{
    cout<<"Enter no of studets"<<endl;
    int ni;
    cin>>ni;
    student list[ni];
    for(int k=0;k<ni;k++)
    {
			
      string na,r,sn;
      float cg;
      int nc;
      cout<<"Enter name, roll no, sname, cgpa, no of courses for student "<<(k+1)<<" "<<endl;
      cin>>na>>r>>sn>>cg>>nc;
      list[k].name=na;
      list[k].rno=r;
      list[k].sname=sn;
      list[k].cgpa=cg;
      list[k].nc=nc;
      list[k].a=new string[nc];
      cout<<"Enter courses\n";
      for(int i=0;i<nc;i++)
      {
			string y;
			cin>>y;
			list[k].a[i]=y;

		}
    }
    cout<<"Enter registration number to search"<<endl;
    string rx;
    cin>>rx;
    for(int i=0;i<ni;i++)
    {
			if(list[i].rno.compare(rx)==0)
			{
				cout<<list[i].name<<" "<<list[i].rno<<" "<<list[i].sname<<" "<<list[i].cgpa<<endl;
				cout<<"Courses\n";
				for(int j=0;j<list[i].nc;j++)
				{
					cout<<list[i].a[j]<<endl;
				}
				break;
			}	
			if(i==ni-1)
			{
				cout<<"Sorry no match\n";
			}
		}
		
		string scn;
		cout<<"Enter school whose students you want to list\n";
		cin>>scn;
		for(int i=0;i<ni;i++)
		{
			if(list[i].sname.compare(scn)==0)
			{
				cout<<list[i].name<<endl;
			}
		}
		cout<<endl;
		
		cout<<"Listing CGPA of 9 and above\n";
		for(int i=0;i<ni;i++)
		{
			if(list[i].cgpa>=9.0)
			{
				cout<<list[i].name<<" "<<list[i].cgpa<<" "<<endl;
			}
		}
}
  