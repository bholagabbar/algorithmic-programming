'''input
2
1 1 1 3
14 7 2 4
'''
#use PYPY

def convert(a):
	a=str(a)
	while len(a)!=1:
		sum=0
		for i in a:
			sum+=int(i)
		a=str(sum)
	return int(a)

tc=int(input())
for q in range(tc):
	a,d,l,r=map(int, raw_input().split())
	sum,ans,start,cnt=convert(a),0,a+d,1
	conv=sum
	while convert(start)!=conv:
		sum+=convert(start)
		start+=d
		cnt+=1
	ans-=sum*((l-1)//cnt)
	start=a+(l-2)*d
	for i in range(0,(l-1)%cnt):
		ans-=convert(start)
		start-=d
	ans+=sum*(r//cnt)
	start=a+(r-1)*d
	for i in range (0,r%cnt):
		ans+=convert(start)
		start-=d
	print ans