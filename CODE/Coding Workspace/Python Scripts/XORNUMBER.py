import math
t=eval(input())
for q in range(t):
	n=int(input())
	x=int(math.log(n+1,2))
	if 1<<x==n+1:
		y=n//2
		if x!=1:
			print(y)
		else: #it's not -1 for 1!
			print("2")
	else:
		print("-1")