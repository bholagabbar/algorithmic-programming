'''input
2
9 77 69
98 99 0
'''
tc=eval(input().strip())
for tl in range (0,tc):
	s1=input().strip().split(' ')
	a=int(s1[0])
	b=int(s1[1])
	c=int(s1[2])
	ans=0
	f=float((str(a)+'.'+str(b)))
	m=f
	cnt=0
	cd=float('0.'+str(c))
	while cnt<=10000 and (a>0 or b>=c):
		if(b>=c):
			b-=c
		elif b<c:
			a-=1
			b+=100
			b-=c
		
		a,b=b,a
		cnt+=1
		f=float((str(a)+'.'+str(b)))
		if f>m:
			m=f
			ans=cnt

	print (ans)
