'''input
3
2
14
7
'''

sum=[]

def init_sum():
    cnt=1
    for i in range (1,4472):
        sum.append((i*(i+1))>>1)

def find(n):
    for i in range (len(sum)):
        if n<=sum[i]:
        	if ((n*(n+1))>>1)==sum[i]:
        		return (n)
        	else:
        		return (i+1)

init_sum()
tc=eval(input())
for i in range(tc):
    n=eval(input())
    n1=find(n)
    z=sum[n1-1]
    x=z-n+1
    y=(n1+1)-x
    if(n1%2==1):
        print ('TERM '+str(n)+' IS '+str(x)+'/'+str(y))
    else:
        print ('TERM '+str(n)+' IS '+str(y)+'/'+str(x))