/*input
3
3
14
7
*/
#include <iostream>
#include <vector>
using namespace std;
#define endl '\n'
#define pb emplace_back

vector <string> a;

int init()
{
	a.pb("1/1");
	int cnt =1;
	int z=2;
	int flag=1;
	while (flag==1)
	{
	    if (z%2==0)
	    {
	        int x=1;
	        int y=z;
	        while (y!=0)
	        {
	            a.pb(to_string(x)+"/"+to_string(y));
	            y=y-1;
	            x=x+1;
	            cnt=cnt+1;
	            if (cnt>1000000){
	                flag=0;
	                break;
	            }
	        }
	    }
	    else
	    {
	        z%2==1;
	        int x=z;
	        int y=1;
	        while (x!=0)
	        {
	            a.pb(to_string(x)+"/"+to_string(y));
	            x=x-1;
	            y=y+1;
	            cnt=cnt+1;
	            if (cnt>1000000)
	            {
	                flag=0;
	                break;
	            }
	        }
	    }
	    z=z+1;
	}
}

//Created by Shreyans Sheth [bholagabbar] using Sublime 3 and SublimeInput Plugin

int main()
{
	ios_base::sync_with_stdio(false);//FAST IO
	init();
	int tc,n;
	cin>>tc;
	while(tc--)
	{
		cin>>n;
		cout<<"TERM "<<n<<" IS "<<a[n-1]<<endl;
	}	
	return 0;
}