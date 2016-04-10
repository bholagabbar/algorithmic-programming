'''input
2
3
3 3 3
4
1 2 3 3
'''
tc=eval(input())
for t in range(tc):
	n=eval(input())
	a=input().strip().split(' ')
	x=set()
	for i in range (n):
		x.add(a[i])
	print(len(x))