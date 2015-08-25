'''input
6
milk 58
Ciel's Drink 80
The curry 2nd edition 888888
rice omelet 85855
unagi 1
   The first    and last letters can be a space    358
'''
sum=0
for tc in range(int(input())):
	a=input().strip().split()
	n=int(a[len(a)-1])
	c8,c5,c3=0,0,0
	flag=1
	while(n>0):
		rem=n%10
		n=n//10
		if rem !=8 and rem!=5 and rem!=3:
			flag=0
			break
		else:
			if rem==8:
				c8+=1
			elif rem==5:
				c5+=1
			elif rem==3:
				c3+=1
	if flag==1:
		if c8>=c5 and c5>=c3:
			sum+=1

print(sum)





