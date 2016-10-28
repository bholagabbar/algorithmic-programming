t=int(input())
for ts in range (t):
	s1=input()
	s2=input()
	f=1
	for i in range (len(s1)):
		if s1[i]!='?' and s2[i]!='?' and s1[i]!=s2[i]:
			f=0
			break
	if f==1:
		print("Yes")
	else:
		print("No")