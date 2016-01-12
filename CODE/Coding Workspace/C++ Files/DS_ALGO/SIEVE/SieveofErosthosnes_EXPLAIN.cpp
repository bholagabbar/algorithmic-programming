#include <bits/stdc++.h>
using namespace std;
#define endl '\n'

//Created by Shreyans Sheth [bholagabbar]

#define size 100005
bool prime[size];

void Sieve()
{
	for(int i=2;i<size;i++) //Setting all to true
		prime[i]=1;
	prime[0]=prime[1]=0; //0 and 1 are not primes
	for(long i=2;i<=sqrt(size);i++) //Check till only the square root for prime factors
		if(prime[i]) //If it is a prime, all the factors are marked non prime
			for(long j=i*i;j<size;j+=i) //marking all factors non prime
				prime[j]=0;
}


int main()
{
	ios_base::sync_with_stdio(false);
    //freopen("E:/Shreyans/Documents/Coding Workspace/STDINPUT.txt","r",stdin);
    Sieve();
    cout<<"Primes uptil 10^6 found";
	return 0;
}