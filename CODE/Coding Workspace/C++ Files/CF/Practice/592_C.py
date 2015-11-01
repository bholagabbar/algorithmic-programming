'''input
5814 31 7
'''
import fractions
t,a,b=map(int,input().split())
if a==1 or b==1:
    if a==1 and b==1:
        num=den=1
    else:
        num=t//max(a,b)
        den=t
else:
    lcm=(a*b)//fractions.gcd(a,b)
    num=t-(t//a+t//b-t//lcm)
    den=t
g=fractions.gcd(num,den)
num=num//g
den=den//g
print(str(num)+'/'+str(den))
print(den-num)