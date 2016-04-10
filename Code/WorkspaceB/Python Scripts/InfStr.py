class InfiniteString:
		def equal(self,x1,x2):
			if(x1*len(x2)==x2*len(x1)):
				return("Equal")
			else:
				return("Not equal")
print(InfiniteString().equal("aaa","bbb"))