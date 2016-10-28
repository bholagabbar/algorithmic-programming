def MergeAndCntInv(l,r,a):
	i=j=k=cnt=0
	ll,rl,al=len(l),len(r),len(a)
	#Counting Split Inversions

	'''Essentially left inversions from sorted array which become split inversions
	inside of themselves, right inversions same fo for right sorted array and then stich the 2 together by final
	split inversion counting 	
	'''
	while i<ll or j<rl:
		if i==ll:
			a[k]=r[j]
			j+=1

		elif j==rl:
			a[k]=l[i]
			i+=1

		elif l[i]<=r[j]:
			a[k]=l[i]
			i+=1

		else:
			a[k]=r[j]
			j+=1
			cnt+=(ll-i)
		k+=1

	return cnt


def MergeSort(a):
	n=len(a)
	
	if n<2:
		return 0

	mid=n//2
	l=a[0:mid]
	r=a[mid:n]
	
	return (MergeSort(l)+MergeSort(r)+MergeAndCntInv(l,r,a))

with open("E:\Shreyans\Coursera Algos 1\Week 1\IntegerArray.txt","r") as f:
	a=[]
	for i in f:
		a.append(int(i))
print(MergeSort(a))