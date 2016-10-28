/*input
+
-
*/
#include <bits/stdc++.h>
using namespace std;
#define readFile freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
#define boostIO ios_base::sync_with_stdio(false)
#define ld long double
#define ll long long int
#define CLR(s) memset(&s, 0, sizeof(s))
#define scani(s) scanf("%d",&s)
#define scanl(s) scanf("%lld",&s)
#define hashset unordered_set //JAVA feels :')
#define hashmap unordered_map
#define pll pair<ll,ll>
#define pii pair<int,int>
#define pb push_back
#define mp make_pair
#define F first
#define S second
#define endl '\n'

double fact(double x)
{
	double fact=1.0;
	for(int i=1;i<=x;i++)
		fact=fact*(i*1.0);
	return fact;
}


int main()
{
	//readFile;
	string a,b;
	cin>>a>>b;
	int plus1=0,minus1=0,plus2=0,minus2=0,q=0;
	for(int i=0;i<a.size();i++)
		a[i]=='+'?plus1++:minus1++;
	for(int i=0;i<b.size();i++)
	{
		if(b[i]=='+')
			plus2++;
		else if(b[i]=='-')
			minus2++;
		else
			q++;
	}
	double ans=0;
	if(q==0 && (plus1==plus2 && minus1==minus2))
	{
		ans=1;
		printf("%.9f",ans);
	}
	else if((q==0 && (plus1+minus1!=plus2+minus2)) || ((plus1-plus2<0 || minus1-minus2<0)))
		printf("%.9f",ans);
	else if(q!=0)
	{
		ans=(fact(q)/(1.0*fact(plus1-plus2)*fact(minus1-minus2)))/((1<<q)*1.0);
		printf("%.9f",ans);
	}
	return 0;
}