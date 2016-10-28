#include <iostream>
#include <string>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n,k1,q;
		string s;
		cin>>n>>k1>>q;
		cin>>s;
		while(q--)
		{
			int l,r;
			int cnt=0;
			cin>>l>>r;
			string s1=s.substr(l-1,(r-l)+1);
			for(int j= 0 ;j<s1.size();j++ )
                {
                    for(int k = 1 ; k <= s1.size()-j ; k++ )
                    {
                        string s2 = s1.substr(j, k);
                        int cnt1=0;
                        int cnt0=0;
                        //cout<<s2<<endl;
                        for(int l=0;l<s2.size();l++)
                        {
                            if(s2.at(l)=='1')
                            {
                                cnt1++;
                            }
                            else
                            {
                                cnt0++;
                            }
                            if(cnt1>k1||cnt0>k1)
                            {
                            	break;
                            }
                        }
                        if(cnt1<=k1&&cnt0<=k1)
                        {
                            cnt++;
                        }
                    }
                }
                cout<<cnt<<endl;
		}
	}
	return 0;
}