'''input
3
1 1
1 2
2 3
'''

import math
import fractions

tc=eval(input())
for tc in range (tc):
	s=input().split(' ')
	a=int(s[0])
	b=int(s[1])
	x=math.ceil(a/2)*(b//2)
	y=math.ceil(b/2)*(a//2)
	#print(x,y)
	z1=(x+y)
	z2=(a*b)
	#print(z1,z2)
	g=fractions.gcd(z1,z2)
	#print(g)
	z1=z1//g
	z2=z2//g
	print(str(z1)+'/'+str(z2))


