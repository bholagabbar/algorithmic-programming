#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar]

bool a[1000001];
long size=sizeof(a)/sizeof(bool);

void SOE()
{
	memset(a,1,sizeof(a)); //Setting all to true
	a[0]=a[1]=0; //0 and 1 are not primes
	for(long i=2;i<=sqrt(size);i++) //Check till only the square root for prime factors
		if(a[i]) //If it is a prime, all the factors are marked non prime
			for(long j=i*i;j<=size;j+=1) //marking all factors non prime
				a[j]=0;
}


int main()
{
	ios_base::sync_with_stdio(false);
    //freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
    SOE();
    cout<<"Primes uptil 10^6 found";
	return 0;
}