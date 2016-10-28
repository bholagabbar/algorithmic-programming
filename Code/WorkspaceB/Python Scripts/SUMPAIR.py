'''input
3
3 3
3 5 8
4 3
5 8 10 12
5 3
3 2 8 17 15
'''
def MergeAndCntInv(l,r,a,D):
	i=j=k=cnt=0
	ll,rl,al=len(l),len(r),len(a)
	while i<ll or j<rl:
		if i==ll:
			a[k]=r[j]
			j+=1

		elif j==rl:
			a[k]=l[i]
			i+=1

		elif l[i]<=r[j]:
			if(l[i]-r[j]<D):
				cnt+=l[i]
				cnt+=r[j]
			a[k]=l[i]
			i+=1

		else:
			a[k]=r[j]
			j+=1
		k+=1

	return cnt


def MergeSort(a,D):
	n=len(a)
	
	if n<2:
		return 0

	mid=n//2
	l=a[0:mid]
	r=a[mid:n]
	
	return (MergeSort(l,D)+MergeSort(r,D)+MergeAndCntInv(l,r,a,D))

tc=int(input())
while tc>0:
	s=input().split()
	D=int(s[0])
	n=int(s[1])
	s1=input().split()
	a=[]
	for i in range(len(s1)):
		a.append(int(s1[i]))
	print(MergeSort(a,D))
	tc-=1