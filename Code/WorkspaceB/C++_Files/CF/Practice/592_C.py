'''input
10 3 2
'''
import fractions
t,a,b=map(int,input().split())
lcm=(a*b)//fractions.gcd(a,b)
mi=min(a,b)
ans=mi*(t//lcm)+mi-1
umax=(t//lcm)*lcm +mi-1
if umax>t: #cant be greater than total
	ans+=(t-umax);
hcf=fractions.gcd(ans,t)
ans//=hcf
t//=hcf
print(str(ans)+'/'+str(t))