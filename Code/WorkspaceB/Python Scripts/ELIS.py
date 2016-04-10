'''input
5
1 4 2 4 3
'''
n=int(input().strip())
a=input().split()
for i in range(len(a)):
	a[i]=int(a[i])
dp=[0]*(len(a))
for i in range(len(a)):
	dp[i]=1
	for j in range(i-1,-1,-1): #looped backwards to check for smaller numbers
		if a[j]<a[i] and dp[j]+1>dp[i]: #check if the len of the subsequence including this is longer
			dp[i]=dp[j]+1
print(max(dp))