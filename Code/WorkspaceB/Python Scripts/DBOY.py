'''input
1
4
1 2 3 4
1 4 5 3
'''
import sys

inf=sys.maxsize
tc=eval(input())
while tc>0:
	n=eval(input())
	h=input().split(' ')#dis
	p=input().split(' ')#pumps fuel
	dp=[]
	sum=0

	for i in range (n):
		val=int(h[i])#dist for del e.i need to find min pumps for this
		dp.append([inf]*(val+1))
		
		dp[i][0]=0
		#for each del
		for j in range(1,val+1):
			#for the pumps
			for k in range (0,n):
				p[k]=int(p[k])
				
				if p[k]<=j and 1+dp[i][j-p[k]]<dp[i][j]:
					dp[i][j]=1+dp[i][j-p[k]]

				elif p[k]>j:
					break

		sum+=dp[i][val]

	print(sum)
	tc-=1

