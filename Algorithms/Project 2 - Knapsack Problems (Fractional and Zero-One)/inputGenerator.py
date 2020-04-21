import os,sys,random

n=10 #Number of Entries to Generate

file = open(os.path.join(sys.path[0],"input.txt"), 'a')

for x in range(n+1):
    file.write("(%d,%d)\n"%(random.randint(1,99),random.randint(1,99)))

file.close()
