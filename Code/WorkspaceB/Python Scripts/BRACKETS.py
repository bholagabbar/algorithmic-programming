'''input
1
()((()()))
'''
def mbal(a):
	bal=0
	mb=0
	for i in range(len(a)):
		if(a[i]=='('):
			bal+=1
		elif(a[i]==')'):
			bal-=1
		mb=max(mb,bal)

	return mb

tc=eval(input())
for t in range (tc):
	mxb=mbal(input())
	a='('*mxb+')'*mxb
	print(a)