'''input
1
abbabaab
'''
tc=eval(input())
while tc>0:
	s=input()
	if s==s[::-1]:
		print('1')
	else:
		print('2')
	tc-=1