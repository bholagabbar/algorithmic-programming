'''input
2
1 10
100 10000
'''
import math

tc=eval(input())
for i in range (tc):
	#s=input()
	s=input().split(' ')
	a=int(s[0])
	b=int(s[1])
	cnt=0
	sqa=int(math.sqrt(a))
	sqb=int(math.sqrt(b))
	if sqa*sqa==a or sqb*sqb==b:
		cnt+=1

	cnt+=(sqb-sqa)
	print (cnt)
