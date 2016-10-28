n=eval(input("Enter n: ")) # keep sub 20-ish max
for i in range(0,(2**n)):# loop from 0 to (2^n)-1
    cursub="Subset "+str(i+1)+" Contains Elements: "
    for j in range(0,n):
        if((1<<j) & i >0): #Checking if jth bit in i is set
            cursub+=(str(j+1)+" ")   
    print (cursub)
print ("All ", (2**n)," Subsets printed")