import math
t=int(input());
for q in range(t):
	n=int(input())
	if n==1:
		print("1")
	elif n==2:
		print("2")
	else:
		ans=3+((n+1-3)//2)
		print(int(ans))